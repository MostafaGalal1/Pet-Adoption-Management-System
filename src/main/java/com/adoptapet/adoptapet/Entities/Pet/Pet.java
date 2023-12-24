package com.adoptapet.adoptapet.Entities.Pet;

import com.adoptapet.adoptapet.Entities.Gender;
import com.adoptapet.adoptapet.Entities.Shelter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pet")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "breed")
    private String breed;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "healthStatus")
    @Enumerated(EnumType.STRING)
    private String healthStatus;

    @Column(name = "behaviour")
    @Enumerated(EnumType.STRING)
    private String behaviour;

    @Column(name = "description")
    private String description;

    @Column(name = "vacinated")
    private boolean vacinated;

    @Column(name = "castrated")
    private boolean castrated;

    @Column(name = "homeTrained")
    private boolean homeTrained;

    @Column(name = "shelterId")
    private int shelterId;

    @ManyToOne
    @JoinColumn(name = "shelterId")
    private Shelter shelter;
}