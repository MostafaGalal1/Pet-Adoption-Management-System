package com.adoptapet.adoptapet.Entities.AdoptionRecord;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdoptionRecordId implements Serializable {
    private int petId;
    private int adopterId;
}
