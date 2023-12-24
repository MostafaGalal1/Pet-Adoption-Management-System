package com.adoptapet.adoptapet.Dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.Document.Document}
 */
@Value
public class DocumentDto implements Serializable {
    int petId;
    int documentId;
    String name;
    String type;
    String link;
    PetDto pet;
}