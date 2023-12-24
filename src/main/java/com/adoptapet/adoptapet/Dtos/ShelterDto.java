package com.adoptapet.adoptapet.Dtos;

import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.adoptapet.adoptapet.Entities.Shelter}
 */
@Value
public class ShelterDto implements Serializable {
    int id;
    String name;
    String contact;
    String location;
    int managerId;
    StaffDto manager;
    List<StaffDto> staff;
    List<PetDto> pets;
}