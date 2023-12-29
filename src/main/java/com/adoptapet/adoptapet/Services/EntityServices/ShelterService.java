package com.adoptapet.adoptapet.Services.EntityServices;
import com.adoptapet.adoptapet.Dtos.ShelterDto;
import com.adoptapet.adoptapet.Entities.Shelter;
import com.adoptapet.adoptapet.Exceptions.ShelterExceptions.ShelterAlreadyExistsException;
import com.adoptapet.adoptapet.Exceptions.ShelterExceptions.ShelterNotFoundException;
import com.adoptapet.adoptapet.Mappers.ShelterMapper;
import com.adoptapet.adoptapet.Repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterService {
    private final ShelterRepository shelterRepository;
    private final ShelterMapper shelterMapper;

    @Autowired
    public ShelterService(ShelterRepository shelterRepository, ShelterMapper shelterMapper) {
        this.shelterRepository = shelterRepository;
        this.shelterMapper = shelterMapper;
    }

    public List<ShelterDto> getAllShelters() {
        return shelterMapper.toDtoList(shelterRepository.findAll());
    }

    public ShelterDto getShelter(int shelterId) {
        if (shelterRepository.findById(shelterId).isEmpty())
            throw new ShelterNotFoundException();
        Shelter shelter = shelterRepository.findById(shelterId).get();
        return shelterMapper.toDto(shelter);
    }

    public void addShelter(ShelterDto shelterDto) {
        if (shelterRepository.findById(shelterDto.getId()).isPresent())
            throw new ShelterAlreadyExistsException();
        Shelter shelter = shelterMapper.toEntity(shelterDto);
        shelterRepository.save(shelter);
    }

    public void updateShelter(ShelterDto shelterDto) {
        if (shelterRepository.findById(shelterDto.getId()).isEmpty())
            throw new ShelterNotFoundException();
        Shelter shelter = shelterRepository.findById(shelterDto.getId()).get();
        shelterMapper.partialUpdate(shelterDto, shelter);
        shelterRepository.save(shelter);
    }

    public void deleteShelter(int shelterId) {
        if (shelterRepository.findById(shelterId).isEmpty())
            throw new ShelterNotFoundException();
        shelterRepository.deleteById(shelterId);
    }
}
