package com.adoptapet.adoptapet.Controllers;

import com.adoptapet.adoptapet.Dtos.AdopterDto;
import com.adoptapet.adoptapet.Services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping()
    public void getAllPets() {
    }

    @GetMapping("/{petId}")
    public void getPet(@PathVariable int petId) {
    }

    @PostMapping
    public void addPet(@RequestBody AdopterDto AdopterDto) {
    }

    @PutMapping
    public void updatePet(@RequestBody AdopterDto AdopterDto) {
    }

    @DeleteMapping("/{petId}")
    public void deletePet(@PathVariable int petId) {
    }
}
