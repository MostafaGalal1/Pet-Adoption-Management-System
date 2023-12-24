package com.adoptapet.adoptapet.Entities.Document;


import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentId implements Serializable {
    private int petId;
    private int documentId;
}
