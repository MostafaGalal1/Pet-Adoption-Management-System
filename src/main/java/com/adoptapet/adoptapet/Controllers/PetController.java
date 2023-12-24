package com.adoptapet.adoptapet.Controllers;

import com.adoptapet.adoptapet.Services.PetService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class PetController {
    private PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/pet")
    public void addPet() {
    }
}
