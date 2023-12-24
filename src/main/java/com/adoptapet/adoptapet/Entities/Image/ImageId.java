package com.adoptapet.adoptapet.Entities.Image;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ImageId implements Serializable{
    private int petId;
    private int imageId;
}
