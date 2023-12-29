package com.adoptapet.adoptapet.Entities;

import com.adoptapet.adoptapet.Entities.Account.Account;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {
    @Id
    @Column(name = "id")
    private int id;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Account account;
}