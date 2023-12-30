package com.adoptapet.adoptapet.Controllers;
import com.adoptapet.adoptapet.Dtos.ShelterDto;
import com.adoptapet.adoptapet.Services.EntityServices.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelter")
public class ShelterController {

    private final ShelterService shelterService;

    @Autowired
    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @GetMapping
    public ResponseEntity<List<ShelterDto>> getAllShelters() {
        return ResponseEntity.ok(shelterService.getAllShelters());
    }

    @GetMapping("{shelterId}")
    public ResponseEntity<ShelterDto> getShelter(@PathVariable int shelterId) {
        return ResponseEntity.ok(shelterService.getShelter(shelterId));
    }

    @PostMapping
    public ResponseEntity<String> addShelter(@RequestBody ShelterDto shelterDto) {
        shelterService.addShelter(shelterDto);
        return ResponseEntity.ok("Shelter added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateShelter(@RequestBody ShelterDto shelterDto) {
        shelterService.updateShelter(shelterDto);
        return ResponseEntity.ok("Shelter updated successfully");
    }

    @DeleteMapping("{shelterId}")
    public ResponseEntity<String> deleteShelter(@PathVariable int shelterId) {
        shelterService.deleteShelter(shelterId);
        return ResponseEntity.ok("Shelter deleted successfully");
    }
}
