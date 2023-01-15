package com.bank.mapper;

import com.bank.dto.PassportDto;
import com.bank.model.PassportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Интерфейс позволяет конвертировать сущности
 * типа {@link PassportEntity} в ДТО типа{@link PassportDto}*/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PassportMapper {

    /**
     * Конвертирует одну ДТО {@link PassportDto} в одну сущность {@link PassportEntity}*/
    PassportEntity toEntity(PassportDto passportDto);

    /**
     * Конвертирует одну сущность {@link PassportEntity} в одну ДТО {@link PassportDto}*/
    PassportDto toDto(PassportEntity passportEntity);

    /**
     * Конвертирует список сущностей {@link PassportEntity} в список ДТО {@link PassportDto}*/
    List<PassportDto> toDtoList(List<PassportEntity> entities);

    /**
     * Конвертирует список ДТО {@link PassportDto} в список сущностей {@link PassportEntity}*/
    List<PassportEntity> toEntityList(List<PassportDto> entities);
    
}
