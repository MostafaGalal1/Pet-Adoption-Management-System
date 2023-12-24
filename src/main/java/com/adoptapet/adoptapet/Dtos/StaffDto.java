package com.adoptapet.adoptapet.Dtos;

import com.adoptapet.adoptapet.Entities.Staff.JobTitle;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.Staff.Staff}
 */
@Value
public class StaffDto implements Serializable {
    int id;
    String name;
    String contact;
    JobTitle jobTitle;
    int shelterId;
    AccountDto account;
    ShelterDto shelter;
}