package com.adoptapet.adoptapet.Entities.AdoptionRecord;

import com.adoptapet.adoptapet.Entities.Adopter;
import com.adoptapet.adoptapet.Entities.Pet.Pet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(AdoptionRecordId.class)
@Table(name = "AdoptionRecord")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdoptionRecord {
    @Id
    @Column(name = "petId")
    private int petId;

    @Id
    @Column(name = "adopterId")
    private int adopterId;

    @ManyToOne
    @JoinColumn(name = "petId")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "adopterId")
    private Adopter adopter;
}