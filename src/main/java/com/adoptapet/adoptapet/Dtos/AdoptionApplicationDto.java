package com.adoptapet.adoptapet.Dtos;

import com.adoptapet.adoptapet.Entities.AdoptionApplication.Status;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplication}
 */
@Value
public class AdoptionApplicationDto implements Serializable {
    Status status;
    PetDto pet;
    AdopterDto adopter;
}