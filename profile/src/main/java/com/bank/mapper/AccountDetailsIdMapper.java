package com.bank.mapper;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.model.AccountDetailsIdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

/**
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
     * @param accountDetailsIdEntity {@link AccountDetailsIdEntity}
     * @param accountDetailsIdDto {@link AccountDetailsIdDto}
     * @return {@link AccountDetailsIdEntity}
     */
    @Mappings({
            @Mapping(target = "id", source = "id", ignore = true),
            @Mapping(target = "profile.id", source = "profile.id", ignore = true)
    })
    AccountDetailsIdEntity updateEntity(@MappingTarget AccountDetailsIdEntity accountDetailsIdEntity,
                                  AccountDetailsIdDto accountDetailsIdDto);
}
