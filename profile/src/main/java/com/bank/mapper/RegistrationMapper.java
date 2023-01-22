package com.bank.mapper;

import com.bank.dto.RegistrationDto;
import com.bank.model.RegistrationEntity;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * TODO Маппер для {@link RegistrationEntity} и {@link RegistrationDto}.
 * Маппер для {@link RegistrationEntity} в {@link RegistrationDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface RegistrationMapper {

    /**
     * TODO переименуй "auditDto" в "registration".
     * @param auditDto {@link RegistrationDto}
     * @return {@link RegistrationEntity}
     */
    // TODO переименуй "auditDto" в "registration".
    RegistrationEntity toEntity(RegistrationDto auditDto);

    /**
     * TODO переименуй "auditEntity" в "registration".
     * @param auditEntity {@link RegistrationEntity}
     * @return {@link RegistrationDto}
     */
    // TODO переименуй "auditEntity" в "registration".
    RegistrationDto toDto(RegistrationEntity auditEntity);

    /**
     * TODO переименуй "entities" в "registrations".
     * @param entities {@link List<RegistrationEntity>}
     * @return {@link List<RegistrationDto>}
     */
    // TODO переименуй "entities" в "registrations".
    List<RegistrationDto> toDtoList(List<RegistrationEntity> entities);

    // TODO удали метод toEntityList, так как он не используется.
    /**
     * @param dto {@link List<RegistrationDto>}
     * @return {@link List<RegistrationEntity>}
     */
    List<RegistrationEntity> toEntityList(List<RegistrationDto> dto);
    // TODO удали пустую строку.
}