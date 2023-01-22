package com.bank.mapper;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.model.AccountDetailsIdEntity;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * TODO Маппер для {@link AccountDetailsIdEntity} и {@link AccountDetailsIdDto}.
 * Маппер для {@link AccountDetailsIdEntity} в {@link AccountDetailsIdDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface AccountDetailsIdMapper {

    /**
     * TODO переименуй "auditDto" в "accountDetailsId".
     * @param auditDto {@link AccountDetailsIdDto}
     * @return {@link AccountDetailsIdEntity}
     */
    // TODO переименуй "auditDto" в "accountDetailsId".
    AccountDetailsIdEntity toEntity(AccountDetailsIdDto auditDto);

    /**
     * TODO переименуй "auditDto" в "accountDetailsId".
     * @param auditEntity {@link AccountDetailsIdEntity}
     * @return {@link AccountDetailsIdDto}
     */
    // TODO переименуй "auditEntity" в "accountDetailsId".
    AccountDetailsIdDto toDto(AccountDetailsIdEntity auditEntity);

    /**
     * TODO переименуй "entities" в " accountDetailsIds".
     * @param entities {@link List<AccountDetailsIdEntity>}
     * @return {@link List<AccountDetailsIdDto>}
     */
    // TODO переименуй "entities" в " accountDetailsIds".
    List<AccountDetailsIdDto> toDtoList(List<AccountDetailsIdEntity> entities);

    // TODO удали метод toEntityList, так как он не используется.
    /**
     * @param dto {@link List<AccountDetailsIdDto>}
     * @return {@link List<AccountDetailsIdEntity>}
     */
    List<AccountDetailsIdEntity> toEntityList(List<AccountDetailsIdDto> dto);
    // TODO удали пустую строку.
}