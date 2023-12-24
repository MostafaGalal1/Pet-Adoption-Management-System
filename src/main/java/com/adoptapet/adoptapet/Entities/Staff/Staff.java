package com.adoptapet.adoptapet.Entities.Staff;

import com.adoptapet.adoptapet.Entities.Account.Account;
import com.adoptapet.adoptapet.Entities.Shelter;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "shelterId")
    private int shelterId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "shelterId")
    private Shelter shelter;
}