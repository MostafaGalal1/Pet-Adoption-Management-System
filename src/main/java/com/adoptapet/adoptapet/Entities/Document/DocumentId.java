package com.adoptapet.adoptapet.Entities.Document;


import java.io.Serializable;

import com.adoptapet.adoptapet.Entities.Pet.Pet;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentId implements Serializable {
    private Pet pet;
    private int documentId;
}
