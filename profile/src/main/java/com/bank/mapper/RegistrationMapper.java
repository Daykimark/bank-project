package com.bank.mapper;

import com.bank.dto.RegistrationDto;
import com.bank.model.RegistrationEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RegistrationMapper {
    RegistrationEntity toEntity(RegistrationDto registrationDto);

    RegistrationDto toDto(RegistrationEntity registrationEntity);

    List<RegistrationDto> toDtoList(List<RegistrationEntity> entities);

    List<RegistrationEntity> toEntityList(List<RegistrationDto> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RegistrationEntity partialUpdate(RegistrationDto registrationDto, @MappingTarget RegistrationEntity registrationEntity);
}