package com.bank.mapper;

import com.bank.dto.PassportDto;
import com.bank.model.PassportEntity;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * TODO Маппер для {@link PassportEntity} и {@link PassportEntity}.
 * Маппер для {@link PassportEntity} в {@link PassportDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface PassportMapper {

    /**
     * TODO переименуй "auditDto" в "passport".
     * @param auditDto {@link PassportDto}
     * @return {@link PassportEntity}
     */
    // TODO переименуй "auditDto" в "passport".
    PassportEntity toEntity(PassportDto auditDto);

    /**
     * TODO переименуй "auditDto" в "passport".
     * @param auditEntity {@link PassportEntity}
     * @return {@link PassportDto}
     */
    // TODO переименуй "auditEntity" в "passport".
    PassportDto toDto(PassportEntity auditEntity);

    /**
     * TODO переименуй "entities" в "passports".
     * @param entities {@link List<PassportEntity>}
     * @return {@link List<PassportDto>}
     */
    //TODO переименуй "entities" в "passports".
    List<PassportDto> toDtoList(List<PassportEntity> entities);

    // TODO удали метод toEntityList.
    /**
     * @param dto {@link List<PassportDto>}
     * @return {@link List<PassportEntity>}
     */
    List<PassportEntity> toEntityList(List<PassportDto> dto);

}