package com.bank.mapper;

import com.bank.dto.RegistrationDto;
import com.bank.model.RegistrationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Интерфейс позволяет конвертировать сущности
 * типа {@link RegistrationEntity} в ДТО типа{@link RegistrationDto}*/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RegistrationMapper {

    /**
     * Конвертирует одну ДТО {@link RegistrationDto} в одну сущность {@link RegistrationEntity}*/
    RegistrationEntity toEntity(RegistrationDto registrationDto);

    /**
     * Конвертирует одну сущность {@link RegistrationEntity} в одну ДТО {@link RegistrationDto}*/
    RegistrationDto toDto(RegistrationEntity registrationEntity);

    /**
     * Конвертирует список сущностей {@link RegistrationEntity} в список ДТО {@link RegistrationDto}*/
    List<RegistrationDto> toDtoList(List<RegistrationEntity> entities);

    /**
     * Конвертирует список ДТО {@link RegistrationDto} в список сущностей {@link RegistrationEntity}*/
    List<RegistrationEntity> toEntityList(List<RegistrationDto> entities);
    
}
