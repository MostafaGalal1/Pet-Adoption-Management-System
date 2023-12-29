package com.adoptapet.adoptapet.Services.EntityServices;

import com.adoptapet.adoptapet.Dtos.AdopterDto;
import com.adoptapet.adoptapet.Entities.Adopter;
import com.adoptapet.adoptapet.Mappers.AdopterMapper;
import com.adoptapet.adoptapet.Repositories.AdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdopterService {

    private final AdopterRepository adopterRepository;

    private final AdopterMapper adopterMapper;

    @Autowired
    public AdopterService(AdopterRepository adopterRepository, AdopterMapper adopterMapper) {
        this.adopterRepository = adopterRepository;
        this.adopterMapper = adopterMapper;
    }

    public List<AdopterDto> getAllAdopters() {
        return adopterMapper.toDtoList(adopterRepository.findAll());
    }

    public AdopterDto getAdopter(int adopterId) {
        Adopter adopter = adopterRepository.findById(adopterId).orElse(null);
        return adopterMapper.toDto(adopter);
    }

    public ResponseEntity<String> add(AdopterDto adopterDto) {
        Adopter adopter = adopterMapper.toEntity(adopterDto);
        if (!adopterRepository.existsByAccount(adopter.getAccount())) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        adopterRepository.save(adopter);
        return new ResponseEntity<>("Adopter added", HttpStatus.ACCEPTED);
    }

    public void updateAdopter(AdopterDto adopterDto) {
        Adopter adopter = adopterRepository.findById(adopterDto.getId()).orElse(null);
        adopterMapper.partialUpdate(adopterDto, adopter);
        adopterRepository.save(adopter);
    }

    public void deleteAdopter(int adopterId) {
        adopterRepository.deleteById(adopterId);
    }
}
