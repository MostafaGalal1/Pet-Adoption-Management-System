package com.adoptapet.adoptapet.Controllers;
import com.adoptapet.adoptapet.Dtos.AdopterDto;
import com.adoptapet.adoptapet.Services.EntityServices.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adopters")
public class AdopterController {
    private final AdopterService adopterService;

    @Autowired
    public AdopterController(AdopterService adopterService) {
        this.adopterService = adopterService;
    }

    @GetMapping
    public ResponseEntity<List<AdopterDto>> getAllAdopters() {
        return ResponseEntity.ok(adopterService.getAllAdopters());
    }

    @GetMapping("/{adopterId}")
    public ResponseEntity<AdopterDto> getAdopter(@PathVariable int adopterId) {
        return ResponseEntity.ok(adopterService.getAdopter(adopterId));
    }

    @PostMapping
    public ResponseEntity<String> addAdopter(@RequestBody AdopterDto adopterDto) {
        adopterService.add(adopterDto);
        return ResponseEntity.ok("Adopter added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateAdopter(@RequestBody AdopterDto adopterDto) {
        adopterService.updateAdopter(adopterDto);
        return ResponseEntity.ok("Adopter updated successfully");
    }

    @DeleteMapping("/{adopterId}")
    public ResponseEntity<String> deleteAdopter(@PathVariable int adopterId) {
        adopterService.deleteAdopter(adopterId);
        return ResponseEntity.ok("Adopter deleted successfully");
    }
}