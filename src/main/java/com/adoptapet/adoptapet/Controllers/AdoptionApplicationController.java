package com.adoptapet.adoptapet.Controllers;
import com.adoptapet.adoptapet.Dtos.AdoptionApplicationDto;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplicationId;
import com.adoptapet.adoptapet.Services.AdoptionApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/application")
public class AdoptionApplicationController {
    private final AdoptionApplicationService adoptionApplicationService;

    @Autowired
    public AdoptionApplicationController(AdoptionApplicationService adoptionApplicationService) {
        this.adoptionApplicationService = adoptionApplicationService;
    }

//    @GetMapping("/{shelterId}")
//    public ResponseEntity<List<AdoptionApplicationDto>> getAllAdoptionApplications(@PathVariable int shelterId) {
//        return ResponseEntity.ok(adoptionApplicationService.getAllAdoptionApplications());
//    }

    @GetMapping()
    public ResponseEntity<List<AdoptionApplicationDto>> getAllAdoptionApplications() {
        return ResponseEntity.ok(adoptionApplicationService.getAll());
    }

    @PostMapping
    public ResponseEntity<String> addAdoptionApplication(@RequestBody AdoptionApplicationDto applicationDto) {
        adoptionApplicationService.add(applicationDto);
        return ResponseEntity.ok("Adoption application added");
    }

    @DeleteMapping("/{applicationId}")
    public ResponseEntity<String> deleteAdoptionApplication(@PathVariable AdoptionApplicationId applicationId) {
        adoptionApplicationService.delete(applicationId);
        return ResponseEntity.ok("Adoption application deleted");
    }


}
