package com.bank.mapper;

import com.bank.dto.ProfileDto;
import com.bank.model.ProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Интерфейс позволяет конвертировать сущности
 * типа {@link ProfileEntity} в ДТО типа{@link ProfileDto}*/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProfileMapper {

    /**
     * Конвертирует одну ДТО {@link ProfileDto} в одну сущность {@link ProfileEntity}*/
    ProfileEntity toEntity(ProfileDto profileDto);

    /**
     * Конвертирует одну сущность {@link ProfileEntity} в одну ДТО {@link ProfileDto}*/
    ProfileDto toDto(ProfileEntity profileEntity);

    /**
     * Конвертирует список сущностей {@link ProfileEntity} в список ДТО {@link ProfileDto}*/
    List<ProfileDto> toDtoList(List<ProfileEntity> entities);

    /**
     * Конвертирует список ДТО {@link ProfileDto} в список сущностей {@link ProfileEntity}*/
    List<ProfileEntity> toEntityList(List<ProfileDto> entities);

}
