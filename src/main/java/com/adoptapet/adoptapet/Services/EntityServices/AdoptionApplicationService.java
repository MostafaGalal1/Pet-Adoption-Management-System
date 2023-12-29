package com.adoptapet.adoptapet.Services.EntityServices;
import com.adoptapet.adoptapet.Dtos.AdoptionApplicationDto;
import com.adoptapet.adoptapet.Dtos.ImageDto;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplication;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplicationId;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.Status;
import com.adoptapet.adoptapet.Mappers.AdoptionApplicationMapper;
import com.adoptapet.adoptapet.Mappers.ImageMapper;
import com.adoptapet.adoptapet.Repositories.AdoptionApplicationRepository;
import com.adoptapet.adoptapet.Repositories.ImageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<AdoptionApplicationDto> getAll() {
        return adoptionApplicationRepository.findAll().stream().map(adoptionApplicationMapper::toDto).collect(Collectors.toList());
    }

    public void add(AdoptionApplicationDto applicationDto) {
        AdoptionApplication adoptionApplication = adoptionApplicationMapper.toEntity(applicationDto);
        adoptionApplicationRepository.save(adoptionApplication);
    }

    public void delete(AdoptionApplicationId id) {
        adoptionApplicationRepository.findById(id);
    }

    public void updateStatus(AdoptionApplicationId applicationId, Status newStatus) {
        System.out.println(applicationId.getAdopter());
        AdoptionApplication adoptionApplication = adoptionApplicationRepository.findById(applicationId)
                .orElseThrow(() -> new EntityNotFoundException("Adoption application not found"));
        adoptionApplication.setStatus(newStatus);
        adoptionApplicationRepository.save(adoptionApplication);
    }


}
