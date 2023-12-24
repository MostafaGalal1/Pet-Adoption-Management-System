package com.adoptapet.adoptapet.Dtos;

import com.adoptapet.adoptapet.Entities.Pet.Pet;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.AdoptionRecord.AdoptionRecord}
 */
@Value
public class AdoptionRecordDto implements Serializable {
    int petId;
    int adopterId;
    Pet pet;
    AdopterDto adopter;
}