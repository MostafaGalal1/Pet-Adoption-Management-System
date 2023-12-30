package com.adoptapet.adoptapet.Services.EntityServices;

import com.adoptapet.adoptapet.Dtos.AdopterDto;
import com.adoptapet.adoptapet.Dtos.SignUpDto;
import com.adoptapet.adoptapet.Entities.Adopter;
import com.adoptapet.adoptapet.Exceptions.AdopterExceptions.AdopterAlreadyExistsException;
import com.adoptapet.adoptapet.Exceptions.AdopterExceptions.AdopterNotFoundException;
import com.adoptapet.adoptapet.Mappers.AdopterMapper;
import com.adoptapet.adoptapet.Repositories.AdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (adopterRepository.findById(adopterId).isEmpty())
            throw new AdopterNotFoundException();
        Adopter adopter = adopterRepository.findById(adopterId).get();
        return adopterMapper.toDto(adopter);
    }

    public void add(AdopterDto adopterDto) {
        if (adopterRepository.findById(adopterDto.getId()).isPresent())
            throw new AdopterAlreadyExistsException();
        Adopter adopter = adopterMapper.toEntity(adopterDto);
        adopterRepository.save(adopter);
    }

    public void add(SignUpDto signUpDto) {
        Adopter adopter = adopterMapper.toEntity(signUpDto);
        adopter.setId(adopter.getAccount().getId());
        adopterRepository.save(adopter);
    }

    public void updateAdopter(AdopterDto adopterDto) {
        if (adopterRepository.findById(adopterDto.getId()).isEmpty())
            throw new AdopterNotFoundException();
        Adopter adopter = adopterRepository.findById(adopterDto.getId()).get();
        adopterMapper.partialUpdate(adopterDto, adopter);
        adopterRepository.save(adopter);
    }

    public void deleteAdopter(int adopterId) {
        if (adopterRepository.findById(adopterId).isEmpty())
            throw new AdopterNotFoundException();
        adopterRepository.deleteById(adopterId);
    }
}
