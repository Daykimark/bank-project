package com.bank.mapper;

import com.bank.dto.ActualRegistrationDto;
import com.bank.entity.ActualRegistrationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Mapper для {@link ActualRegistrationEntity} и {@link ActualRegistrationDto}
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
     * @param actualRegistration {@link ActualRegistrationEntity}
     * @param actualRegistrationDto {@link ActualRegistrationDto}
     * @return {@link ActualRegistrationEntity}
     */
    @Mapping(target = "id", ignore = true)
    ActualRegistrationEntity mergeToEntity(@MappingTarget ActualRegistrationEntity actualRegistration,
                                        ActualRegistrationDto actualRegistrationDto);
}
