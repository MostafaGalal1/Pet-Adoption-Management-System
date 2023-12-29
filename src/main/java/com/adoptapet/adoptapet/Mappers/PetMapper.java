package com.adoptapet.adoptapet.Mappers;

import com.adoptapet.adoptapet.Dtos.PetDto;
import com.adoptapet.adoptapet.Entities.Pet.Pet;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PetMapper {
    Pet toEntity(PetDto petDto);

    PetDto toDto(Pet pet);

    List<PetDto> toDtoList(List<Pet> petList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Pet partialUpdate(PetDto petDto, @MappingTarget Pet pet);
}