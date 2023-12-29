package com.adoptapet.adoptapet.Dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.AdoptionRecord.AdoptionRecord}
 */
@Value
@Getter
@Builder
public class AdoptionRecordDto implements Serializable {
    PetDto pet;
    AdopterDto adopter;
    StaffDto staff;
}