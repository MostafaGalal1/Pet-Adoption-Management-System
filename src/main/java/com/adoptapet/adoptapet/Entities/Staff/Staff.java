package com.adoptapet.adoptapet.Entities.Staff;

import com.adoptapet.adoptapet.Dtos.StaffDto;
import com.adoptapet.adoptapet.Entities.Account.Account;
import com.adoptapet.adoptapet.Entities.Shelter;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

@Entity
@Table(name = "staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @Column(name = "jobTitle")
    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "shelterId")
    private Shelter shelter;

    private static ModelMapper modelMapper = new ModelMapper();

    public static Staff convert(StaffDto staffDto) {
        return modelMapper.map(staffDto, Staff.class);
    }
}