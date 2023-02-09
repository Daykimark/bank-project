package com.bank.mapper;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.entity.AccountDetailsIdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Mapper для {@link AccountDetailsIdEntity} и {@link AccountDetailsIdDto}
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
     * @param accountDetailsId {@link AccountDetailsIdEntity}
     * @param accountDetailsIdDto {@link AccountDetailsIdDto}
     * @return {@link AccountDetailsIdEntity}
     */
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "profile.id", ignore = true)
    })
    AccountDetailsIdEntity mergeToEntity(@MappingTarget AccountDetailsIdEntity accountDetailsId,
                                  AccountDetailsIdDto accountDetailsIdDto);
}
