package com.adoptapet.adoptapet.Mappers;

import com.adoptapet.adoptapet.Dtos.ImageDto;
import com.adoptapet.adoptapet.Entities.Image.Image;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ImageMapper {
    Image toEntity(ImageDto imageDto);

    ImageDto toDto(Image image);

    List<ImageDto> toDtoList(List<Image> images);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Image partialUpdate(ImageDto imageDto, @MappingTarget Image image);
}