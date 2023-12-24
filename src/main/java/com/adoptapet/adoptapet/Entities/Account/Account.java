package com.adoptapet.adoptapet.Entities.Account;

import com.adoptapet.adoptapet.Dtos.AccountDto;
import com.adoptapet.adoptapet.Dtos.SignUpDto;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    private static ModelMapper modelMapper = new ModelMapper();

    public static Account convert(AccountDto accountDto) {
        return modelMapper.map(accountDto, Account.class);
    }

    public static Account convert(SignUpDto signUpDto) {
        return modelMapper.map(signUpDto, Account.class);
    }
}