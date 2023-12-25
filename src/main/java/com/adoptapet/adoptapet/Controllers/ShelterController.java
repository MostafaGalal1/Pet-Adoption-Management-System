package com.adoptapet.adoptapet.Controllers;
import com.adoptapet.adoptapet.Dtos.ShelterDto;
import com.adoptapet.adoptapet.Services.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shelter")
public class ShelterController {

    private final ShelterService shelterService;

    @Autowired
    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @PostMapping
    public ResponseEntity<String> addShelter(ShelterDto shelterDto) {
        shelterService.add(shelterDto);
        return ResponseEntity.ok("Shelter added");
    }

    @PutMapping
    public ResponseEntity<String> updateShelter(ShelterDto shelterDto) {
        shelterService.update(shelterDto);
        return ResponseEntity.ok("Shelter updated");
    }

    @DeleteMapping("{shelterId}")
    public ResponseEntity<String> deleteShelter(@PathVariable int shelterId) {
        shelterService.delete(shelterId);
        return ResponseEntity.ok("Shelter deleted");
    }
}
