package com.adoptapet.adoptapet.Entities.Image;

import com.adoptapet.adoptapet.Entities.Pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageId implements Serializable{
    private Pet pet;
    private int imageId;
}
