package com.adoptapet.adoptapet.Services;

import com.adoptapet.adoptapet.Dtos.AdopterDto;
import com.adoptapet.adoptapet.Entities.Adopter;
import com.adoptapet.adoptapet.Mappers.AdopterMapper;
import com.adoptapet.adoptapet.Repositories.AdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdopterService {

    private final AdopterRepository adopterRepository;

    private final AdopterMapper adopterMapper;

    @Autowired
    public AdopterService(AdopterRepository adopterRepository, AdopterMapper adopterMapper) {
        this.adopterRepository = adopterRepository;
        this.adopterMapper = adopterMapper;
    }

    public ResponseEntity<String> add(AdopterDto adopterDto) {
        Adopter adopter = adopterMapper.toEntity(adopterDto);
        if (!adopterRepository.existsByAccount(adopter.getAccount())) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        adopterRepository.save(adopter);
        return new ResponseEntity<>("Adopter added", HttpStatus.ACCEPTED);
    }
}
