package com.bank.mapper;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.model.AccountDetailsIdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * TODO Маппер переименуй в Mapper.
 * Маппер для {@link AccountDetailsIdEntity} и {@link AccountDetailsIdDto}
 */
@Mapper(componentModel = "spring")
public interface AccountDetailsIdMapper {

    /**
     * @param accountDetailsId {@link AccountDetailsIdDto}
     * @return {@link AccountDetailsIdEntity}
     */
    AccountDetailsIdEntity toEntity(AccountDetailsIdDto accountDetailsId);

    /**
     * @param accountDetailsId {@link AccountDetailsIdEntity}
     * @return {@link AccountDetailsIdDto}
     */
    AccountDetailsIdDto toDto(AccountDetailsIdEntity accountDetailsId);

    /**
     * @param accountDetailsIds {@link List<AccountDetailsIdEntity>}
     * @return {@link List<AccountDetailsIdDto>}
     */
    List<AccountDetailsIdDto> toDtoList(List<AccountDetailsIdEntity> accountDetailsIds);

    /**
     * TODO после исправления последнего todo исправь javadoc.
     * @param accountDetailsIdEntity {@link AccountDetailsIdEntity}
     * @param accountDetailsIdDto {@link AccountDetailsIdDto}
     * @return {@link AccountDetailsIdEntity}
     */
    @Mappings({
            // TODO source удалить
            @Mapping(target = "id", source = "id", ignore = true),
            // TODO source удалить
            @Mapping(target = "profile.id", source = "profile.id", ignore = true)
    })
    // TODO updateEntity переименуй в mergeToEntity. accountDetailsIdEntity переименовать в accountDetailsId
    AccountDetailsIdEntity updateEntity(@MappingTarget AccountDetailsIdEntity accountDetailsIdEntity,
                                  AccountDetailsIdDto accountDetailsIdDto);
}
