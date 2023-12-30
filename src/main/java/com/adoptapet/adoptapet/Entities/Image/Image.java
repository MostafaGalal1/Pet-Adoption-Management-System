package com.adoptapet.adoptapet.Entities.Image;

import com.adoptapet.adoptapet.Entities.Pet.Pet;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "imageId")
    private int imageId;

    @Column(name = "link")
    private String link;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "petId")
    @JsonManagedReference
    private Pet pet;
}