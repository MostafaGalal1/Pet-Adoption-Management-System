package com.adoptapet.adoptapet.Services;

import com.adoptapet.adoptapet.Dtos.AdopterDto;
import com.adoptapet.adoptapet.Entities.Adopter;
import com.adoptapet.adoptapet.Repositories.AdopterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdopterService {

    private final AdopterRepository adopterRepository;

    public AdopterService(AdopterRepository adopterRepository) {
        this.adopterRepository = adopterRepository;
    }

    public ResponseEntity<String> add(AdopterDto adopterDto) {
        Adopter adopter = Adopter.convert(adopterDto);
        if (!adopterRepository.existsByAccount(adopter.getAccount())) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        adopterRepository.save(adopter);
        return new ResponseEntity<>("Adopter added", HttpStatus.ACCEPTED);
    }
}
