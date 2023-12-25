package com.adoptapet.adoptapet.Mappers;

import com.adoptapet.adoptapet.Dtos.AdopterDto;
import com.adoptapet.adoptapet.Entities.Adopter;
import org.mapstruct.*;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AdopterMapper {
    Adopter toEntity(AdopterDto adopterDto);

    AdopterDto toDto(Adopter adopter);

    List<AdopterDto> toDtoList(List<Adopter> adopterList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Adopter partialUpdate(AdopterDto adopterDto, @MappingTarget Adopter adopter);
}