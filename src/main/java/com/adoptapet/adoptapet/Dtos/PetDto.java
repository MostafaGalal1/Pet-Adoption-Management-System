package com.adoptapet.adoptapet.Dtos;

import com.adoptapet.adoptapet.Entities.Gender;
import com.adoptapet.adoptapet.Entities.Pet.Behaviour;
import com.adoptapet.adoptapet.Entities.Pet.HealthStatus;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.Pet.Pet}
 */
@Value
public class PetDto implements Serializable {
    int id;
    String name;
    String species;
    String breed;
    int age;
    Gender gender;
    HealthStatus healthStatus;
    Behaviour behaviour;
    String description;
    boolean adopted;
    boolean vacinated;
    boolean castrated;
    boolean homeTrained;
    int shelterId;
    ShelterDto shelter;
}