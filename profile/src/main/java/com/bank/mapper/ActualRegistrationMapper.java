package com.bank.mapper;

import com.bank.dto.ActualRegistrationDto;
import com.bank.model.ActualRegistrationEntity;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * Маппер для {@link ActualRegistrationEntity} в {@link ActualRegistrationDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface ActualRegistrationMapper {

    /**
     * @param auditDto {@link ActualRegistrationDto}
     * @return {@link ActualRegistrationEntity}
     */
    ActualRegistrationEntity toEntity(ActualRegistrationDto auditDto);

    /**
     * @param auditEntity {@link ActualRegistrationEntity}
     * @return {@link ActualRegistrationDto}
     */
    ActualRegistrationDto toDto(ActualRegistrationEntity auditEntity);

    /**
     * @param entities {@link List<ActualRegistrationEntity>}
     * @return {@link List<ActualRegistrationDto>}
     */
    List<ActualRegistrationDto> toDtoList(List<ActualRegistrationEntity> entities);

    /**
     * @param dto {@link List<ActualRegistrationDto>}
     * @return {@link List<ActualRegistrationEntity>}
     */
    List<ActualRegistrationEntity> toEntityList(List<ActualRegistrationDto> dto);

}