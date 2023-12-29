package com.adoptapet.adoptapet.Services;
import com.adoptapet.adoptapet.Dtos.AdoptionApplicationDto;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplication;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplicationId;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.Status;
import com.adoptapet.adoptapet.Mappers.AdoptionApplicationMapper;
import com.adoptapet.adoptapet.Repositories.AdoptionApplicationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdoptionApplicationService {
    private final AdoptionApplicationMapper adoptionApplicationMapper;
    private final AdoptionApplicationRepository adoptionApplicationRepository;

    @Autowired
    public AdoptionApplicationService(AdoptionApplicationMapper adoptionApplicationMapper, AdoptionApplicationRepository adoptionApplicationRepository) {
        this.adoptionApplicationMapper = adoptionApplicationMapper;
        this.adoptionApplicationRepository = adoptionApplicationRepository;
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
        AdoptionApplication adoptionApplication = adoptionApplicationRepository.findById(applicationId)
                .orElseThrow(() -> new EntityNotFoundException("Adoption application not found"));
        adoptionApplication.setStatus(newStatus);
        adoptionApplicationRepository.save(adoptionApplication);
    }
}
