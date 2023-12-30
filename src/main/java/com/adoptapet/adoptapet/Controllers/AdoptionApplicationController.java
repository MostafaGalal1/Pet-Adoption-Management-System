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
<<<<<<< Updated upstream
        List<AdoptionApplicationDto> applicationDtos = adoptionApplicationService.getAll();
        return ResponseEntity.ok(applicationDtos);
=======
        System.out.println("jjj");
        List<AdoptionApplicationDto> list = adoptionApplicationService.getAll();
        return ResponseEntity.ok(list);
>>>>>>> Stashed changes
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAdoptionApplication(@RequestBody AdoptionApplicationDto applicationDto) {
        adoptionApplicationService.add(applicationDto);
        return ResponseEntity.ok("Adoption application added");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAdoptionApplication(@RequestBody AdoptionApplicationId applicationId) {
        adoptionApplicationService.delete(applicationId);
        return ResponseEntity.ok("Adoption application deleted");
    }

    @PutMapping("/accept")
    public ResponseEntity<?> acceptApplication(@RequestBody AdoptionApplicationId applicationId) {
        adoptionApplicationService.updateStatus(applicationId, APPROVED);
        return ResponseEntity.ok("Adoption Application Accepted");
    }

    @PutMapping("/decline")
    public ResponseEntity<?> declineApplication(@RequestBody AdoptionApplicationId applicationId) {
        adoptionApplicationService.updateStatus(applicationId, REJECTED);
        return ResponseEntity.ok("Adoption Application Rejected");
    }
    
}
