package com.bank.mapper;

import com.bank.dto.AuditDto;
import com.bank.model.AuditEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Интерфейс позволяет конвертировать сущности
 * типа {@link AuditEntity} в ДТО типа{@link AuditDto}*/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AuditMapper {

    /**
     * Конвертирует одну ДТО {@link AuditDto} в одну сущность {@link AuditEntity}*/
    AuditEntity toEntity(AuditDto auditDto);

    /**
     * Конвертирует одну сущность {@link AuditEntity} в одну ДТО {@link AuditDto}*/
    AuditDto toDto(AuditEntity auditEntity);

    /**
     * Конвертирует список сущностей {@link AuditEntity} в список ДТО {@link AuditDto}*/
    List<AuditDto> toDtoList(List<AuditEntity> entities);

    /**
     * Конвертирует список ДТО {@link AuditDto} в список сущностей {@link AuditEntity}*/
    List<AuditEntity> toEntityList(List<AuditDto> entities);
    
}
