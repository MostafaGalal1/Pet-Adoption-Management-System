package com.adoptapet.adoptapet.Dtos;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.Adopter}
 */
@Value
@Builder
public class AdopterDto implements Serializable {
    int id;
    String name;
    String contact;
    AccountDto account;
}