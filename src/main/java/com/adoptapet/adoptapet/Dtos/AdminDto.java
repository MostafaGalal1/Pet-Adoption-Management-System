package com.adoptapet.adoptapet.Dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.Admin}
 */
@Value
@Getter
@Builder
public class AdminDto implements Serializable {
    int id;
    AccountDto account;
}