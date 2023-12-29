package com.adoptapet.adoptapet.Dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.Document.Document}
 */
@Value
@Getter
@Builder
public class DocumentDto implements Serializable {
    int documentId;
    String type;
    String link;
    PetDto pet;
}