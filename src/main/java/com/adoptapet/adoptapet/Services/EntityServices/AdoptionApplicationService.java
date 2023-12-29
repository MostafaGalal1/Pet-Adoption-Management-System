package com.adoptapet.adoptapet.Services.EntityServices;
import com.adoptapet.adoptapet.Dtos.AdoptionApplicationDto;
import com.adoptapet.adoptapet.Entities.Adopter;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplication;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplicationId;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.Status;
import com.adoptapet.adoptapet.Entities.Pet.Pet;
import com.adoptapet.adoptapet.Mappers.AdoptionApplicationMapper;
import com.adoptapet.adoptapet.Repositories.AdoptionApplicationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptionApplicationService {
    private final AdoptionApplicationMapper adoptionApplicationMapper;
    private final AdoptionApplicationRepository adoptionApplicationRepository;
    private final PetService petService;
    private final AdopterService adopterService;

    @Autowired
    public AdoptionApplicationService(AdoptionApplicationMapper adoptionApplicationMapper, AdoptionApplicationRepository adoptionApplicationRepository, PetService petService, AdopterService adopterService) {
        this.adoptionApplicationMapper = adoptionApplicationMapper;
        this.adoptionApplicationRepository = adoptionApplicationRepository;
        this.petService = petService;
        this.adopterService = adopterService;
    }

    public List<AdoptionApplicationDto> getAll() {
        return adoptionApplicationRepository.findAll().stream().map(adoptionApplicationMapper::toDto).collect(Collectors.toList());
    }

    public List<AdoptionApplicationDto> getAll(int shelterId) {
        List<AdoptionApplication> applications = adoptionApplicationRepository.findAllByShelterId(shelterId);
        System.out.println(applications.size());
        return adoptionApplicationMapper.toDtoList(applications);
    }

    public void add(AdoptionApplicationDto applicationDto) {
        AdoptionApplication adoptionApplication = adoptionApplicationMapper.toEntity(applicationDto);
        adoptionApplicationRepository.save(adoptionApplication);
    }

    public void delete(int petId, int adopterId) {
        Pet pet = petService.getPetEntity(petId);
        Adopter adopter = adopterService.getAdopterEntity(adopterId);
        AdoptionApplicationId applicationId = new AdoptionApplicationId(pet, adopter);
        adoptionApplicationRepository.deleteById(applicationId);
    }

    public void updateStatus(int petId, int adopterId, Status newStatus) {
        Pet pet = petService.getPetEntity(petId);
        Adopter adopter = adopterService.getAdopterEntity(adopterId);
        AdoptionApplicationId applicationId = new AdoptionApplicationId(pet, adopter);
        AdoptionApplication adoptionApplication = adoptionApplicationRepository.findById(applicationId)
                .orElseThrow(() -> new EntityNotFoundException("Adoption application not found"));
        adoptionApplication.setStatus(newStatus);
        adoptionApplicationRepository.save(adoptionApplication);
    }


}
