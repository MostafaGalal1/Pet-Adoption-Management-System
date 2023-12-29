package com.adoptapet.adoptapet.Dtos;

import com.adoptapet.adoptapet.Entities.Gender;
import com.adoptapet.adoptapet.Entities.Pet.Behaviour;
import com.adoptapet.adoptapet.Entities.Pet.HealthStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.Pet.Pet}
 */
@Value
@Getter
@Builder
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
    boolean vaccinated;
    boolean castrated;
    boolean houseTrained;
    ShelterDto shelter;
}