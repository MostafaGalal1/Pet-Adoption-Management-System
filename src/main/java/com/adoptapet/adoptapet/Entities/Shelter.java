package com.adoptapet.adoptapet.Entities;

import com.adoptapet.adoptapet.Entities.Pet.Pet;
import com.adoptapet.adoptapet.Entities.Staff.Staff;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shelter")
    @ToString.Exclude
    private List<Staff> staff;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shelter")
    @ToString.Exclude
    private List<Pet> pets;

    public void addStaff(Staff staff) {
        if (this.staff == null) {
            this.staff = new ArrayList<>();
        }
        this.staff.add(staff);
        staff.setShelter(this);
    }

    public void addPet(Pet pet) {
        if (pets == null) {
            pets = new ArrayList<>();
        }
        pets.add(pet);
        pet.setShelter(this);
    }

    public void removeStaff(Staff staff) {
        if (this.staff != null) {
            this.staff.remove(staff);
            staff.setShelter(null);
        }
    }

    public void removePet(Pet pet) {
        if (pets != null) {
            pets.remove(pet);
            pet.setShelter(null);
        }
    }
}