package com.adoptapet.adoptapet.Services;
import com.adoptapet.adoptapet.Dtos.AdoptionApplicationDto;
import com.adoptapet.adoptapet.Dtos.ImageDto;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplication;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplicationId;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.Status;
import com.adoptapet.adoptapet.Mappers.AdoptionApplicationMapper;
import com.adoptapet.adoptapet.Mappers.ImageMapper;
import com.adoptapet.adoptapet.Repositories.AdoptionApplicationRepository;
<<<<<<< Updated upstream:src/main/java/com/adoptapet/adoptapet/Services/AdoptionApplicationService.java
=======
import com.adoptapet.adoptapet.Repositories.ImageRepository;
>>>>>>> Stashed changes:src/main/java/com/adoptapet/adoptapet/Services/EntityServices/AdoptionApplicationService.java
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdoptionApplicationService {
    private final AdoptionApplicationMapper adoptionApplicationMapper;
    private final AdoptionApplicationRepository adoptionApplicationRepository;
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    @Autowired
    public AdoptionApplicationService(AdoptionApplicationMapper adoptionApplicationMapper, AdoptionApplicationRepository adoptionApplicationRepository, ImageRepository imageRepository, ImageMapper imageMapper) {
        this.adoptionApplicationMapper = adoptionApplicationMapper;
        this.adoptionApplicationRepository = adoptionApplicationRepository;
        this.imageRepository = imageRepository;
        this.imageMapper = imageMapper;
    }

//    public List<AdoptionApplicationDto> getAll() {
//        List<AdoptionApplication> adoptionApplications = adoptionApplicationRepository.findAll();
//        System.out.println(adoptionApplications.size());
//        List<AdoptionApplicationDto> adoptionApplicationDtos = new ArrayList<>();
//        return null;
//    }

    public List<AdoptionApplication> getAll() {
        List<AdoptionApplication> adoptionApplications = adoptionApplicationRepository.findAll();
        System.out.println(adoptionApplications.size());
        return adoptionApplications;
    }

    public void add(AdoptionApplicationDto applicationDto) {
        AdoptionApplication adoptionApplication = adoptionApplicationMapper.toEntity(applicationDto);
        adoptionApplicationRepository.save(adoptionApplication);
    }

    public void delete(AdoptionApplicationId id) {
        adoptionApplicationRepository.findById(id);
    }

    public void updateStatus(AdoptionApplicationId applicationId, Status newStatus) {
<<<<<<< Updated upstream:src/main/java/com/adoptapet/adoptapet/Services/AdoptionApplicationService.java
=======
        System.out.println(applicationId.getAdopter());
>>>>>>> Stashed changes:src/main/java/com/adoptapet/adoptapet/Services/EntityServices/AdoptionApplicationService.java
        AdoptionApplication adoptionApplication = adoptionApplicationRepository.findById(applicationId)
                .orElseThrow(() -> new EntityNotFoundException("Adoption application not found"));
        adoptionApplication.setStatus(newStatus);
        adoptionApplicationRepository.save(adoptionApplication);
    }
<<<<<<< Updated upstream:src/main/java/com/adoptapet/adoptapet/Services/AdoptionApplicationService.java
=======

    public List<ImageDto> getImages(int petId) {
        return imageMapper.toDtoList(imageRepository.findAllByPetId(petId));
    }

>>>>>>> Stashed changes:src/main/java/com/adoptapet/adoptapet/Services/EntityServices/AdoptionApplicationService.java
}
