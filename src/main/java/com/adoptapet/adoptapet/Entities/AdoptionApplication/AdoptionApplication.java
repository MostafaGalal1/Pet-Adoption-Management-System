package com.adoptapet.adoptapet.Entities.AdoptionApplication;

import com.adoptapet.adoptapet.Entities.Adopter;
import com.adoptapet.adoptapet.Entities.Pet.Pet;
import jakarta.persistence.*;
import lombok.*;

@Entity
@IdClass(AdoptionApplicationId.class)
@Table(name = "AdoptionApplication")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdoptionApplication {
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "petId")
    private Pet pet;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "adopterId")
    private Adopter adopter;
}