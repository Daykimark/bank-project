package com.bank.mapper;

import com.bank.dto.ActualRegistrationDto;
import com.bank.model.ActualRegistrationEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ActualRegistrationMapper {
    ActualRegistrationEntity toEntity(ActualRegistrationDto actualRegistrationDto);

    ActualRegistrationDto toDto(ActualRegistrationEntity actualRegistrationEntity);

    List<ActualRegistrationDto> toDtoList(List<ActualRegistrationEntity> entities);

    List<ActualRegistrationEntity> toEntityList(List<ActualRegistrationDto> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ActualRegistrationEntity partialUpdate(ActualRegistrationDto actualRegistrationDto, @MappingTarget ActualRegistrationEntity actualRegistrationEntity);
}