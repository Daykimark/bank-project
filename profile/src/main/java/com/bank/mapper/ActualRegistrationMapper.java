package com.bank.mapper;

import com.bank.dto.ActualRegistrationDto;
import com.bank.model.ActualRegistrationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Интерфейс позволяет конвертировать сущности
 * типа {@link ActualRegistrationEntity} в ДТО типа{@link ActualRegistrationDto}*/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ActualRegistrationMapper {

    /**
     * Конвертирует одну ДТО {@link ActualRegistrationDto} в одну сущность {@link ActualRegistrationEntity}*/
    ActualRegistrationEntity toEntity(ActualRegistrationDto actualRegistrationDto);

    /**
     * Конвертирует одну сущность {@link ActualRegistrationEntity} в одну ДТО {@link ActualRegistrationDto}*/
    ActualRegistrationDto toDto(ActualRegistrationEntity actualRegistrationEntity);

    /**
     * Конвертирует список сущностей {@link ActualRegistrationEntity} в список ДТО {@link ActualRegistrationDto}*/
    List<ActualRegistrationDto> toDtoList(List<ActualRegistrationEntity> entities);

    /**
     * Конвертирует список ДТО {@link ActualRegistrationDto} в список сущностей {@link ActualRegistrationEntity}*/
    List<ActualRegistrationEntity> toEntityList(List<ActualRegistrationDto> entities);
    
}
