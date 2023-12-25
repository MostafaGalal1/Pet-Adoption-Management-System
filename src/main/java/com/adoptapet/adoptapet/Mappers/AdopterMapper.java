package com.adoptapet.adoptapet.Mappers;

import com.adoptapet.adoptapet.Dtos.AdopterDto;
import com.adoptapet.adoptapet.Entities.Adopter;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AdopterMapper {
    Adopter toEntity(AdopterDto adopterDto);

    AdopterDto toDto(Adopter adopter);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Adopter partialUpdate(AdopterDto adopterDto, @MappingTarget Adopter adopter);
}