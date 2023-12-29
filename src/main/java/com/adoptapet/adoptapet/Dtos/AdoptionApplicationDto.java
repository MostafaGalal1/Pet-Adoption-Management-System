package com.adoptapet.adoptapet.Dtos;

import com.adoptapet.adoptapet.Entities.AdoptionApplication.Status;
import com.adoptapet.adoptapet.Entities.Pet.Pet;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplication}
 */
@Value
@Builder
public class AdoptionApplicationDto implements Serializable {
    int petId;
    int adopterId;
    Status status;
    Pet pet;
    AdopterDto adopter;
}