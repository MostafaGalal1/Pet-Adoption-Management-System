package com.adoptapet.adoptapet.Entities.AdoptionApplication;

import com.adoptapet.adoptapet.Entities.Adopter;
import com.adoptapet.adoptapet.Entities.Pet.Pet;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AdoptionApplicationId implements Serializable {
    private Pet pet;
    private Adopter adopter;
}
