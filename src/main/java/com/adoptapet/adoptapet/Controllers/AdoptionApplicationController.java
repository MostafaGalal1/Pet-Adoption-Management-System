package com.adoptapet.adoptapet.Controllers;
import com.adoptapet.adoptapet.Dtos.AdoptionApplicationDto;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplication;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplicationId;
import com.adoptapet.adoptapet.Services.EntityServices.AdoptionApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.adoptapet.adoptapet.Entities.AdoptionApplication.Status.*;

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

    @GetMapping("/getAll")
    public ResponseEntity<List<AdoptionApplicationDto>> getAllAdoptionApplications() {
        List<AdoptionApplicationDto> applicationDtos = adoptionApplicationService.getAll();
        return ResponseEntity.ok(applicationDtos);
    }

    @GetMapping("/getAll/{shelterId}")
    public ResponseEntity<List<AdoptionApplicationDto>> getAllAdoptionApplications(@PathVariable int shelterId) {
        System.out.println(shelterId);
        List<AdoptionApplicationDto> applicationDtos = adoptionApplicationService.getAll(shelterId);
        return ResponseEntity.ok(applicationDtos);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAdoptionApplication(@RequestBody AdoptionApplicationDto applicationDto) {
        adoptionApplicationService.add(applicationDto);
        return ResponseEntity.ok("Adoption application added");
    }

    @DeleteMapping("/delete/{petId}/{adopterId}")
    public ResponseEntity<String> deleteAdoptionApplication(@PathVariable int petId, @PathVariable int adopterId) {
        adoptionApplicationService.delete(petId, adopterId);
        return ResponseEntity.ok("Adoption application deleted");
    }

    @PutMapping("/accept/{petId}/{adopterId}")
    public ResponseEntity<?> acceptApplication(@PathVariable int petId, @PathVariable int adopterId) {
        adoptionApplicationService.updateStatus(petId, adopterId, APPROVED);
        return ResponseEntity.ok("Adoption Application Accepted");
    }

    @PutMapping("/decline/{petId}/{adopterId}")
    public ResponseEntity<?> declineApplication(@PathVariable int petId, @PathVariable int adopterId) {
        adoptionApplicationService.updateStatus(petId, adopterId, REJECTED);
        return ResponseEntity.ok("Adoption Application Rejected");
    }

}
