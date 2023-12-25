package com.adoptapet.adoptapet.Mappers;

import com.adoptapet.adoptapet.Dtos.AdoptionRecordDto;
import com.adoptapet.adoptapet.Entities.AdoptionRecord.AdoptionRecord;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AdoptionRecordMapper {
    AdoptionRecord toEntity(AdoptionRecordDto adoptionRecordDto);

    AdoptionRecordDto toDto(AdoptionRecord adoptionRecord);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AdoptionRecord partialUpdate(AdoptionRecordDto adoptionRecordDto, @MappingTarget AdoptionRecord adoptionRecord);
}