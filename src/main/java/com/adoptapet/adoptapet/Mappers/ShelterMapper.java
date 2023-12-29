package com.adoptapet.adoptapet.Mappers;

import com.adoptapet.adoptapet.Dtos.ShelterDto;
import com.adoptapet.adoptapet.Entities.Shelter;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShelterMapper {
    Shelter toEntity(ShelterDto shelterDto);

    @Mapping(target = "manager", ignore = true)
    ShelterDto toDto(Shelter shelter);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Shelter partialUpdate(ShelterDto shelterDto, @MappingTarget Shelter shelter);
}