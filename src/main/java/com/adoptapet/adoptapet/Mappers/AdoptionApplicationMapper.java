package com.adoptapet.adoptapet.Mappers;

import com.adoptapet.adoptapet.Dtos.AdoptionApplicationDto;
import com.adoptapet.adoptapet.Entities.AdoptionApplication.AdoptionApplication;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AdoptionApplicationMapper {
    AdoptionApplication toEntity(AdoptionApplicationDto adoptionApplicationDto);

    AdoptionApplicationDto toDto(AdoptionApplication adoptionApplication);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AdoptionApplication partialUpdate(AdoptionApplicationDto adoptionApplicationDto, @MappingTarget AdoptionApplication adoptionApplication);
}