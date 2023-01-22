package com.bank.mapper;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.dto.ActualRegistrationDto;
import com.bank.model.AccountDetailsIdEntity;
import com.bank.model.ActualRegistrationEntity;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * TODO Маппер для {@link AccountDetailsIdEntity} и {@link AccountDetailsIdDto}
 * Маппер для {@link ActualRegistrationEntity} в {@link ActualRegistrationDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface ActualRegistrationMapper {

    /**
     * @param auditDto {@link ActualRegistrationDto}
     * @return {@link ActualRegistrationEntity}
     */
    // TODO переименуй "auditEntity" в "actualRegistration".
    ActualRegistrationEntity toEntity(ActualRegistrationDto auditDto);

    /**
     * @param auditEntity {@link ActualRegistrationEntity}
     * @return {@link ActualRegistrationDto}
     */
    // TODO переименуй "auditEntity" в "actualRegistration".
    ActualRegistrationDto toDto(ActualRegistrationEntity auditEntity);

    /**
     * TODO entities не информативно, переименуй в actualRegistrations
     * @param entities {@link List<ActualRegistrationEntity>}
     * @return {@link List<ActualRegistrationDto>}
     */
    //TODO entities не информативно, переименуй в actualRegistrations
    List<ActualRegistrationDto> toDtoList(List<ActualRegistrationEntity> entities);

    // TODO удали метод toEntityList, так как он не используется.
    /**
     * @param dto {@link List<ActualRegistrationDto>}
     * @return {@link List<ActualRegistrationEntity>}
     */
    List<ActualRegistrationEntity> toEntityList(List<ActualRegistrationDto> dto);

}