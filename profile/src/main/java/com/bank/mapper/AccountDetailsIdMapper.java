package com.bank.mapper;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.model.AccountDetailsIdEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountDetailsIdMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "accountId", source = "accountId")
    @Mapping(target = "profile", source = "profile")
    AccountDetailsIdEntity toEntity(AccountDetailsIdDto accountDetailsIdDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "accountId", source = "accountId")
    @Mapping(target = "profile", source = "profile")
    AccountDetailsIdDto toDto(AccountDetailsIdEntity accountDetailsIdEntity);

    List<AccountDetailsIdDto> toDtoList(List<AccountDetailsIdEntity> entities);

    List<AccountDetailsIdEntity> toEntityList(List<AccountDetailsIdDto> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AccountDetailsIdEntity partialUpdate(AccountDetailsIdDto accountDetailsIdDto, @MappingTarget AccountDetailsIdEntity accountDetailsIdEntity);
}