package com.adoptapet.adoptapet.Services.EntityServices;

import com.adoptapet.adoptapet.Dtos.PetDto;
import com.adoptapet.adoptapet.Entities.Pet.Pet;
import com.adoptapet.adoptapet.Entities.Shelter;
import com.adoptapet.adoptapet.Exceptions.PetExceptions.PetAlreadyExistsException;
import com.adoptapet.adoptapet.Exceptions.PetExceptions.PetNotFoundException;
import com.adoptapet.adoptapet.Mappers.PetMapper;
import com.adoptapet.adoptapet.Repositories.PetRepository;
import com.adoptapet.adoptapet.Repositories.ShelterRepository;
import jakarta.persistence.EntityManager;
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
    private static final int PAGE_SIZE = 10;
    private final PetRepository petRepository;
    private final ShelterRepository shelterRepository;
    private final PetMapper petMapper;
    private final EntityManager entityManager;

    @Autowired
    public PetService(PetRepository petRepository, PetMapper petMapper, ShelterRepository shelterRepository, EntityManager entityManager) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
        this.shelterRepository = shelterRepository;
        this.entityManager = entityManager;
    }

    public List<PetDto> getAllPets() {
        List<Pet> pets = petRepository.findAll();
        return petMapper.toDtoList(pets);
    }

    public List<PetDto> getAllPets(int shelterId) {
        List<Pet> pets = petRepository.findAllByShelterId(shelterId);
        return petMapper.toDtoList(pets);
    }

    public PetDto getPet(int petId) {
        if (petRepository.findById(petId).isEmpty())
            throw new PetNotFoundException();
        Pet pet = petRepository.findById(petId).get();
        return petMapper.toDto(pet);
    }

    public Pet getPetEntity(int petId) {
        if (petRepository.findById(petId).isEmpty())
            throw new PetNotFoundException();
        return petRepository.findById(petId).get();
    }

    public int addPet(PetDto petDto) {
        if (petRepository.findById(petDto.getId()).isPresent())
            throw new PetAlreadyExistsException();
        Pet pet = petMapper.toEntity(petDto);
        if (shelterRepository.findById(petDto.getShelter().getId()).isPresent()) {
            Shelter shelter = shelterRepository.findById(petDto.getShelter().getId()).get();
            pet.setShelter(shelter);
        }
        petRepository.save(pet);
        return pet.getId();
    }

    public void updatePet(PetDto petDto) {
        if (petRepository.findById(petDto.getId()).isEmpty())
            throw new PetNotFoundException();
        Pet pet = petRepository.findById(petDto.getId()).get();
        petRepository.save(pet);
    }

    public void deletePet(int id) {
        if (petRepository.findById(id).isEmpty())
            throw new PetNotFoundException();
        petRepository.deleteById(id);
    }

    public List<PetDto> filterPets(String criteria, String value) {
        List<Pet> pets = null;
        switch (criteria) {
            case "breed" -> pets = petRepository.getPetsByBreedIgnoreCaseAndAdopted(value, false);
            case "age" -> pets = petRepository.getPetsByAgeAndAdopted(Integer.parseInt(value), false);
            case "species" -> pets = petRepository.getPetsBySpeciesIgnoreCaseAndAdopted(value, false);
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

    public List<PetDto> filterPets(String criteria, String value, int shelterId) {
        List<Pet> pets = null;
        switch (criteria) {
            case "breed" -> pets = petRepository.getPetsByBreedIgnoreCaseAndAdoptedAndShelterId(value, false, shelterId);
            case "age" -> pets = petRepository.getPetsByAgeAndAdoptedAndShelterId(Integer.parseInt(value), false, shelterId);
            case "species" -> pets = petRepository.getPetsBySpeciesAndAdoptedAndShelterId(value, false, shelterId);
            case "shelter" -> {
                Shelter shelter = shelterRepository.getShelterByLocationAndId(value, shelterId);
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

    public List<?> getValues(String criteria) {
        System.out.println(criteria);
        if(criteria.equalsIgnoreCase("shelter")) {
            String query = "SELECT DISTINCT s.location FROM Shelter s";
            return entityManager.createNativeQuery(query).getResultList();
        }
        else {
            String query = "SELECT DISTINCT p." + criteria + " FROM Pet p";
            return entityManager.createNativeQuery(query).getResultList();
        }
    }
    
    public Page<Pet> findAllPets(Specification<Pet> specification, int pageCount) {
        Pageable pageable = PageRequest.of(pageCount, PAGE_SIZE);
        return petRepository.findAll(specification, pageable);
    }
}
