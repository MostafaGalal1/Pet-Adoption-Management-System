package com.adoptapet.adoptapet.Controllers;
import com.adoptapet.adoptapet.Dtos.AdoptionApplicationDto;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplication;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplicationId;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.Status;
import com.adoptapet.adoptapet.Services.AdoptionApplicationService;
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

//    @GetMapping()
//    public ResponseEntity<List<AdoptionApplicationDto>> getAllAdoptionApplications() {
//        System.out.println("lllll");
//        return ResponseEntity.ok(adoptionApplicationService.getAll());
//    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AdoptionApplication>> getAllAdoptionApplications() { // TODO be modified
        System.out.println("lllll");
        List<AdoptionApplication> list = adoptionApplicationService.getAll();
        return ResponseEntity.ok(list);
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
