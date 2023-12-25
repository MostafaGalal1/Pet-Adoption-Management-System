package com.adoptapet.adoptapet.Mappers;

import com.adoptapet.adoptapet.Dtos.ImageDto;
import com.adoptapet.adoptapet.Entities.Image.Image;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ImageMapper {
    Image toEntity(ImageDto imageDto);

    ImageDto toDto(Image image);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Image partialUpdate(ImageDto imageDto, @MappingTarget Image image);
}