package com.adoptapet.adoptapet.Dtos;


import com.adoptapet.adoptapet.Entities.Account.Role;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SignUpDto {
    String email;
    String password;
    Role role;
}
