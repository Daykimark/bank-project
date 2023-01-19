package com.bank.mapper;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.model.AccountDetailsIdEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Интерфейс позволяет конвертировать сущности
 * типа {@link AccountDetailsIdEntity} в ДТО типа{@link AccountDetailsIdDto}*/

@Mapper(componentModel = "spring")
public interface AccountDetailsIdMapper {

    /**
     * Конвертирует одну ДТО {@link AccountDetailsIdDto} в одну сущность {@link AccountDetailsIdEntity}*/
    AccountDetailsIdEntity toEntity(AccountDetailsIdDto accountDetailsIdDto);

    /**
     * Конвертирует одну сущность {@link AccountDetailsIdEntity} в одну ДТО {@link AccountDetailsIdDto}*/
    AccountDetailsIdDto toDto(AccountDetailsIdEntity accountDetailsIdEntity);

    /**
     * Конвертирует список сущностей {@link AccountDetailsIdEntity} в список ДТО {@link AccountDetailsIdDto}*/
    List<AccountDetailsIdDto> toDtoList(List<AccountDetailsIdEntity> entities);

    /**
     * Конвертирует список ДТО {@link AccountDetailsIdDto} в список сущностей {@link AccountDetailsIdEntity}*/
    List<AccountDetailsIdEntity> toEntityList(List<AccountDetailsIdDto> entities);

}
