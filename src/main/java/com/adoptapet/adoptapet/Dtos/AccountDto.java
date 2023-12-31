package com.adoptapet.adoptapet.Dtos;

import com.adoptapet.adoptapet.Entities.Account.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.Account.Account}
 */
@Value
@Getter
@Builder
public class AccountDto implements Serializable {
    int id;
    String email;
    String password;
    Role role;
}