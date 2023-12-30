package com.adoptapet.adoptapet.Controllers;

import com.adoptapet.adoptapet.Dtos.PetDto;
import com.adoptapet.adoptapet.Services.EntityServices.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping()
    public ResponseEntity<List<PetDto>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{petId}")
    public ResponseEntity<PetDto> getPet(@PathVariable int petId) {
        return ResponseEntity.ok(petService.getPet(petId));
    }

    @PostMapping
    public ResponseEntity<Integer> addPet(@RequestBody PetDto petDto) {
        return ResponseEntity.ok(petService.addPet(petDto));
    }
    @GetMapping("/shelter/{shelterId}")
    public ResponseEntity<List<PetDto>> getPetsInShelter(@PathVariable int shelterId) {
        return ResponseEntity.ok(petService.getAllPets(shelterId));
    }

    @PutMapping
    public ResponseEntity<String> updatePet(@RequestBody PetDto petDto) {
        petService.updatePet(petDto);
        return ResponseEntity.ok("Pet updated successfully");
    }

    @DeleteMapping("/{petId}")
    public ResponseEntity<String> deletePet(@PathVariable int petId) {
        petService.deletePet(petId);
        return ResponseEntity.ok("Pet deleted successfully");
    }
}
