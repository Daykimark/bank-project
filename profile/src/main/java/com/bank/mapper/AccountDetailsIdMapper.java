package com.bank.mapper;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.model.AccountDetailsIdEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountDetailsIdMapper {

    AccountDetailsIdEntity toEntity(AccountDetailsIdDto accountDetailsIdDto);

    AccountDetailsIdDto toDto(AccountDetailsIdEntity accountDetailsIdEntity);

    List<AccountDetailsIdDto> toDtoList(List<AccountDetailsIdEntity> entities);

    List<AccountDetailsIdEntity> toEntityList(List<AccountDetailsIdDto> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AccountDetailsIdEntity partialUpdate(AccountDetailsIdDto accountDetailsIdDto,
                                         @MappingTarget AccountDetailsIdEntity accountDetailsIdEntity);
}