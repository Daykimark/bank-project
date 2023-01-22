package com.bank.mapper;

import com.bank.dto.AuditDto;
import com.bank.model.AuditEntity;
import org.mapstruct.Mapper;
import java.util.List;

//TODO удали маппер, так как он не используется.
/**
 * Маппер для {@link AuditEntity} в {@link AuditDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface AuditMapper {

    /**
     * @param auditDto {@link AuditDto}
     * @return {@link AuditEntity}
     */
    AuditEntity toEntity(AuditDto auditDto);

    /**
     * @param auditEntity {@link AuditEntity}
     * @return {@link AuditDto}
     */
    AuditDto toDto(AuditEntity auditEntity);

    /**
     * @param entities {@link List<AuditEntity>}
     * @return {@link List<AuditDto>}
     */
    List<AuditDto> toDtoList(List<AuditEntity> entities);

    /**
     * @param dto {@link List<AuditDto>}
     * @return {@link List<AuditEntity>}
     */
    List<AuditEntity> toEntityList(List<AuditDto> dto);
    
}
