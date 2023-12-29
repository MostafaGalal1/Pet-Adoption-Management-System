package com.adoptapet.adoptapet.Mappers;

import com.adoptapet.adoptapet.Dtos.AccountDto;
import com.adoptapet.adoptapet.Entities.Account.Account;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {
    Account toEntity(AccountDto accountDto);

    AccountDto toDto(Account account);
    List<AccountDto> toDtoList(List<Account> accounts);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Account partialUpdate(AccountDto accountDto, @MappingTarget Account account);
}