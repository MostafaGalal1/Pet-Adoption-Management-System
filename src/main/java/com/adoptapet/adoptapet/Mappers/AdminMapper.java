package com.adoptapet.adoptapet.Mappers;

import com.adoptapet.adoptapet.Dtos.AdminDto;
import com.adoptapet.adoptapet.Entities.Admin;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AdminMapper {
    Admin toEntity(AdminDto adminDto);

    AdminDto toDto(Admin admin);

    List<AdminDto> toDtoList(List<Admin> adminList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Admin partialUpdate(AdminDto adminDto, @MappingTarget Admin admin);
}