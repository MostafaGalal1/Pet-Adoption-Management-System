package com.adoptapet.adoptapet.Mappers;

import com.adoptapet.adoptapet.Dtos.PetDto;
import com.adoptapet.adoptapet.Entities.Pet.Pet;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PetMapper {
    Pet toEntity(PetDto petDto);

    PetDto toDto(Pet pet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Pet partialUpdate(PetDto petDto, @MappingTarget Pet pet);
}