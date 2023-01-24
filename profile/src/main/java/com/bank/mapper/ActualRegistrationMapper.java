package com.bank.mapper;

import com.bank.dto.ActualRegistrationDto;
import com.bank.model.ActualRegistrationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * TODO Маппер переименуй в Mapper.
 * Маппер для {@link ActualRegistrationEntity} и {@link ActualRegistrationDto}
 */
@Mapper(componentModel = "spring")
public interface ActualRegistrationMapper {

    /**
     * @param actualRegistration {@link ActualRegistrationDto}
     * @return {@link ActualRegistrationEntity}
     */
    ActualRegistrationEntity toEntity(ActualRegistrationDto actualRegistration);

    /**
     * @param actualRegistration {@link ActualRegistrationEntity}
     * @return {@link ActualRegistrationDto}
     */
    ActualRegistrationDto toDto(ActualRegistrationEntity actualRegistration);

    /**
     * @param actualRegistrations {@link List<ActualRegistrationEntity>}
     * @return {@link List<ActualRegistrationDto>}
     */
    List<ActualRegistrationDto> toDtoList(List<ActualRegistrationEntity> actualRegistrations);

    /**
     * TODO после исправления последнего todo исправь javadoc.
     * @param actualRegistrationEntity {@link ActualRegistrationEntity}
     * @param actualRegistrationDto {@link ActualRegistrationDto}
     * @return {@link ActualRegistrationEntity}
     */
    // TODO source удалить
    @Mapping(target = "id", source = "id", ignore = true)
    // TODO updateEntity переименуй в mergeToEntity. actualRegistrationEntity переименовать в actualRegistration
    ActualRegistrationEntity updateEntity(@MappingTarget ActualRegistrationEntity actualRegistrationEntity,
                                        ActualRegistrationDto actualRegistrationDto);
}
