package com.adoptapet.adoptapet.Mappers;

import com.adoptapet.adoptapet.Dtos.DocumentDto;
import com.adoptapet.adoptapet.Entities.Document.Document;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DocumentMapper {
    Document toEntity(DocumentDto documentDto);

    DocumentDto toDto(Document document);

    List<DocumentDto> toDtoList(List<Document> documents);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Document partialUpdate(DocumentDto documentDto, @MappingTarget Document document);
}