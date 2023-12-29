package com.adoptapet.adoptapet.Entities;

import com.adoptapet.adoptapet.Entities.Pet.Pet;
import com.adoptapet.adoptapet.Entities.Staff.Staff;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Shelter")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shelter {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @Column(name = "location")
    private String location;

    @OneToOne
    @JoinColumn(name = "managerId")
    private Staff manager;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Staff> staff;
//
//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Pet> pets;
}