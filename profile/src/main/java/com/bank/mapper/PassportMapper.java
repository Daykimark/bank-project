package com.bank.mapper;

import com.bank.dto.PassportDto;
import com.bank.model.PassportEntity;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * Маппер для {@link PassportEntity} в {@link PassportDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface PassportMapper {

    /**
     * @param auditDto {@link PassportDto}
     * @return {@link PassportEntity}
     */
    PassportEntity toEntity(PassportDto auditDto);

    /**
     * @param auditEntity {@link PassportEntity}
     * @return {@link PassportDto}
     */
    PassportDto toDto(PassportEntity auditEntity);

    /**
     * @param entities {@link List<PassportEntity>}
     * @return {@link List<PassportDto>}
     */
    List<PassportDto> toDtoList(List<PassportEntity> entities);

    /**
     * @param dto {@link List<PassportDto>}
     * @return {@link List<PassportEntity>}
     */
    List<PassportEntity> toEntityList(List<PassportDto> dto);

}