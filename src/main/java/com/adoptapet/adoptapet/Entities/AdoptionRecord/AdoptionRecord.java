package com.adoptapet.adoptapet.Entities.AdoptionRecord;

import com.adoptapet.adoptapet.Entities.Adopter;
import com.adoptapet.adoptapet.Entities.Pet.Pet;
import com.adoptapet.adoptapet.Entities.Staff.Staff;
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
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "petId")
    private Pet pet;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "adopterId")
    private Adopter adopter;

    @Id
    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staff;
}