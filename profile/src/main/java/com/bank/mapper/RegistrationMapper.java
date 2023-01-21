package com.bank.mapper;

import com.bank.dto.RegistrationDto;
import com.bank.model.RegistrationEntity;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * Маппер для {@link RegistrationEntity} в {@link RegistrationDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface RegistrationMapper {

    /**
     * @param auditDto {@link RegistrationDto}
     * @return {@link RegistrationEntity}
     */
    RegistrationEntity toEntity(RegistrationDto auditDto);

    /**
     * @param auditEntity {@link RegistrationEntity}
     * @return {@link RegistrationDto}
     */
    RegistrationDto toDto(RegistrationEntity auditEntity);

    /**
     * @param entities {@link List<RegistrationEntity>}
     * @return {@link List<RegistrationDto>}
     */
    List<RegistrationDto> toDtoList(List<RegistrationEntity> entities);

    /**
     * @param dto {@link List<RegistrationDto>}
     * @return {@link List<RegistrationEntity>}
     */
    List<RegistrationEntity> toEntityList(List<RegistrationDto> dto);

}