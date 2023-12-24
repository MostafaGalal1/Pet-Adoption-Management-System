package com.adoptapet.adoptapet.Entities;

import com.adoptapet.adoptapet.Dtos.AdopterDto;
import com.adoptapet.adoptapet.Entities.Account.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Entity
@Table(name = "Adopter")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Adopter {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Account account;

    private static ModelMapper modelMapper = new ModelMapper();

    public static Adopter convert(AdopterDto adopterDto) {
        return modelMapper.map(adopterDto, Adopter.class);
    }
}