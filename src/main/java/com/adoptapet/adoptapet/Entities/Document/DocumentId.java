package com.adoptapet.adoptapet.Entities.Document;


import java.io.Serializable;

import com.adoptapet.adoptapet.Entities.Pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentId implements Serializable {
    private Pet pet;
    private int documentId;
}
