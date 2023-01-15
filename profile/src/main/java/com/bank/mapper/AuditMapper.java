package com.bank.mapper;

import com.bank.dto.AuditDto;
import com.bank.model.AuditEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AuditMapper {
    AuditEntity toEntity(AuditDto auditDto);

    AuditDto toDto(AuditEntity auditEntity);

    List<AuditDto> toDtoList(List<AuditEntity> entities);

    List<AuditEntity> toEntityList(List<AuditDto> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AuditEntity partialUpdate(AuditDto auditDto, @MappingTarget AuditEntity auditEntity);
}