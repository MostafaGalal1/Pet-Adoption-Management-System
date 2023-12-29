package com.adoptapet.adoptapet.Dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.Image.Image}
 */
@Value
public class ImageDto implements Serializable {
    int imageId;
    String link;
    PetDto pet;
}