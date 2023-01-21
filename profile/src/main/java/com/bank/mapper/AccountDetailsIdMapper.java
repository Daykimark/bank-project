package com.bank.mapper;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.model.AccountDetailsIdEntity;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * Маппер для {@link AccountDetailsIdEntity} в {@link AccountDetailsIdDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface AccountDetailsIdMapper {

    /**
     * @param auditDto {@link AccountDetailsIdDto}
     * @return {@link AccountDetailsIdEntity}
     */
    AccountDetailsIdEntity toEntity(AccountDetailsIdDto auditDto);

    /**
     * @param auditEntity {@link AccountDetailsIdEntity}
     * @return {@link AccountDetailsIdDto}
     */
    AccountDetailsIdDto toDto(AccountDetailsIdEntity auditEntity);

    /**
     * @param entities {@link List<AccountDetailsIdEntity>}
     * @return {@link List<AccountDetailsIdDto>}
     */
    List<AccountDetailsIdDto> toDtoList(List<AccountDetailsIdEntity> entities);

    /**
     * @param dto {@link List<AccountDetailsIdDto>}
     * @return {@link List<AccountDetailsIdEntity>}
     */
    List<AccountDetailsIdEntity> toEntityList(List<AccountDetailsIdDto> dto);

}