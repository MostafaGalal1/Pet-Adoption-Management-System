package com.adoptapet.adoptapet.Services.EntityServices;

import com.adoptapet.adoptapet.Dtos.PetDto;
import com.adoptapet.adoptapet.Entities.Pet.Pet;
import com.adoptapet.adoptapet.Entities.Shelter;
import com.adoptapet.adoptapet.Mappers.PetMapper;
import com.adoptapet.adoptapet.Repositories.PetRepository;
import com.adoptapet.adoptapet.Repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;

    private final ShelterRepository shelterRepository;

    private final PetMapper petMapper;

    @Autowired
    public PetService(PetRepository petRepository, PetMapper petMapper, ShelterRepository shelterRepository) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
        this.shelterRepository = shelterRepository;
    }

    public List<PetDto> getAllPets() {
        List<Pet> pets = petRepository.findAll();
        return petMapper.toDtoList(pets);
    }

    public PetDto getPet(int petId) {
        Pet pet = petRepository.findById(petId).orElse(null);
        return petMapper.toDto(pet);
    }

    public void addPet(PetDto petDto) {
        Pet pet = petMapper.toEntity(petDto);
        petRepository.save(pet);
    }

    public void updatePet(PetDto petDto) {
        Pet pet = petRepository.findById(petDto.getId()).orElse(null);
        petMapper.partialUpdate(petDto, pet);
        petRepository.save(pet);
    }

    public void deletePet(int id) {
        petRepository.deleteById(id);
    }

    public List<PetDto> filterPets(String criteria, String value) {
        List<Pet> pets = null;
        switch (criteria) {
            case "breed" -> pets = petRepository.getPetsByBreedAndAdopted(value, false);
            case "age" -> pets = petRepository.getPetsByAgeAndAdopted(Integer.parseInt(value), false);
            case "species" -> pets = petRepository.getPetsBySpeciesAndAdopted(value, false);
            case "shelter" -> {
                Shelter shelter = shelterRepository.getShelterByLocation(value);
                pets = petRepository.getPetsByShelterAndAdopted(shelter, false);
            }
        }
        List<PetDto> petDtoList = new ArrayList<>();
        if (pets != null) {
            for (Pet pet : pets) {
                petDtoList.add(petMapper.toDto(pet));
            }
        }
        return petDtoList;
    }

    public Page<Pet> findAllPets(Specification<Pet> specification, int pageCount) {
        Pageable pageable = PageRequest.of(pageCount, 10);
        return petRepository.findAll(specification, pageable);
    }
}
