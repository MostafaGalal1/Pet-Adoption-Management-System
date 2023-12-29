package com.adoptapet.adoptapet.Entities.AdoptionRecord;

import java.io.Serializable;

import com.adoptapet.adoptapet.Entities.Adopter;
import com.adoptapet.adoptapet.Entities.Pet.Pet;
import com.adoptapet.adoptapet.Entities.Staff.Staff;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdoptionRecordId implements Serializable {
    private Pet pet;
    private Adopter adopter;
    private Staff staff;
}
