package com.bank.mapper;

import com.bank.dto.PassportDto;
import com.bank.model.PassportEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PassportMapper {
    PassportEntity toEntity(PassportDto passportDto);

    PassportDto toDto(PassportEntity passportEntity);

    List<PassportDto> toDtoList(List<PassportEntity> entities);

    List<PassportEntity> toEntityList(List<PassportDto> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PassportEntity partialUpdate(PassportDto passportDto, @MappingTarget PassportEntity passportEntity);
}