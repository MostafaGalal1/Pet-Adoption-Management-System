package com.adoptapet.adoptapet.Mappers;

import com.adoptapet.adoptapet.Dtos.ShelterDto;
import com.adoptapet.adoptapet.Entities.Shelter;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShelterMapper {
    Shelter toEntity(ShelterDto shelterDto);

    ShelterDto toDto(Shelter shelter);

    List<ShelterDto> toDtoList(List<Shelter> shelterList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Shelter partialUpdate(ShelterDto shelterDto, @MappingTarget Shelter shelter);
}