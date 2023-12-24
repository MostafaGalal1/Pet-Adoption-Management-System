package com.adoptapet.adoptapet.Dtos;

import com.adoptapet.adoptapet.Entities.Account.Role;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.Account.Account}
 */
@Value
@Builder
public class AccountDto implements Serializable {
    String email;
    Role role;
}