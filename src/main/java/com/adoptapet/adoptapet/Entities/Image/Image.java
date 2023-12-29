package com.adoptapet.adoptapet.Entities.Image;

import com.adoptapet.adoptapet.Entities.Pet.Pet;
import jakarta.persistence.*;
import lombok.*;

@Entity
@IdClass(ImageId.class)
@Table(name = "Image")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {
    @Id
    @Column(name = "petId")
    private int petId;

    @Id
    @Column(name = "imageId")
    private int imageId;

    @Column(name = "link")
    private String link;

    @ManyToOne
    @JoinColumn(name = "petId")
    private Pet pet;
}