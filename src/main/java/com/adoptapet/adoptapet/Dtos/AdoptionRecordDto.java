package com.adoptapet.adoptapet.Dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.AdoptionRecord.AdoptionRecord}
 */
@Value
public class AdoptionRecordDto implements Serializable {
    PetDto pet;
    AdopterDto adopter;
    StaffDto staff;
}