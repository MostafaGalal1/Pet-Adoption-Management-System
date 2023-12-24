package com.adoptapet.adoptapet.Entities.AdoptionApplication;

import com.adoptapet.adoptapet.Entities.Adopter;
import com.adoptapet.adoptapet.Entities.Pet.Pet;
import jakarta.persistence.*;
import lombok.*;

@Entity
@IdClass(AdoptionApplicationId.class)
@Table(name = "adoption_application")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdoptionApplication {
    @Id
    @Column(name = "petId")
    private int petId;

    @Id
    @Column(name = "adopterId")
    private int adopterId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "petId")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "adopterId")
    private Adopter adopter;
}