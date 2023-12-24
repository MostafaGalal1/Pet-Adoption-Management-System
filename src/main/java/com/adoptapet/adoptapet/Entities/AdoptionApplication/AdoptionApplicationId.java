package com.adoptapet.adoptapet.Entities.AdoptionApplication;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AdoptionApplicationId implements Serializable {
    private int petId;
    private int adopterId;
}
