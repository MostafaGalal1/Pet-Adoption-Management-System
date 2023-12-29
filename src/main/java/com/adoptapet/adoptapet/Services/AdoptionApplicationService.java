package com.adoptapet.adoptapet.Services;
import com.adoptapet.adoptapet.Dtos.AdoptionApplicationDto;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplication;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplicationId;
import com.adoptapet.adoptapet.Mappers.AdoptionApplicationMapper;
import com.adoptapet.adoptapet.Repositories.AdoptionApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<AdoptionApplicationDto> getAll() {
        List<AdoptionApplication> adoptionApplications = adoptionApplicationRepository.findAll();
        System.out.println(adoptionApplications);
        return adoptionApplicationMapper.toDtoList(adoptionApplications);
    }

    public void add(AdoptionApplicationDto applicationDto) {
        AdoptionApplication adoptionApplication = adoptionApplicationMapper.toEntity(applicationDto);
        adoptionApplicationRepository.save(adoptionApplication);
    }

    public void delete(AdoptionApplicationId id) {
        adoptionApplicationRepository.findById(id);
    }
}
