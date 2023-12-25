package com.adoptapet.adoptapet.Services;
import com.adoptapet.adoptapet.Dtos.ShelterDto;
import com.adoptapet.adoptapet.Entities.Shelter;
import com.adoptapet.adoptapet.Mappers.ShelterMapper;
import com.adoptapet.adoptapet.Repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelterService {
    private final ShelterRepository shelterRepository;
    private final ShelterMapper shelterMapper;

    @Autowired
    public ShelterService(ShelterRepository shelterRepository, ShelterMapper shelterMapper) {
        this.shelterRepository = shelterRepository;
        this.shelterMapper = shelterMapper;
    }

    public void add(ShelterDto shelterDto) {
        Shelter shelter = shelterMapper.toEntity(shelterDto);
        shelterRepository.save(shelter);
    }

    public void update(ShelterDto shelterDto) {
        Shelter shelter = shelterRepository.findById(shelterDto.getId()).orElse(null);
        shelterMapper.partialUpdate(shelterDto, shelter);
        shelterRepository.save(shelter);
    }

    public void delete(int shelterId) {
        shelterRepository.deleteById(shelterId);
    }
}
