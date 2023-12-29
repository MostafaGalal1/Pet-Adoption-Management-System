package com.adoptapet.adoptapet.Dtos;

import com.adoptapet.adoptapet.Entities.Account.Account;
import com.adoptapet.adoptapet.Entities.Account.Role;
import com.adoptapet.adoptapet.Entities.Staff.JobTitle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class SignUpDto {
    String email;
    Role role;
    String password;
    String name;
    String contact;
    JobTitle jobTitle;
    Account account;
}
