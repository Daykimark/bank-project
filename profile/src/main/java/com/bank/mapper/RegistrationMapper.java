package com.bank.mapper;

import com.bank.dto.RegistrationDto;
import com.bank.entity.RegistrationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Mapper для {@link RegistrationEntity} и {@link RegistrationDto}
 */
@Mapper(componentModel = "spring")
public interface RegistrationMapper {

    /**
     * @param registration {@link RegistrationDto}
     * @return {@link RegistrationEntity}
     */
    RegistrationEntity toEntity(RegistrationDto registration);

    /**
     * @param registration {@link RegistrationEntity}
     * @return {@link RegistrationDto}
     */
    RegistrationDto toDto(RegistrationEntity registration);

    /**
     * @param registrations {@link List<RegistrationEntity>}
     * @return {@link List<RegistrationDto>}
     */
    List<RegistrationDto> toDtoList(List<RegistrationEntity> registrations);

    /**
     * @param registration {@link RegistrationEntity}
     * @param registrationDto {@link RegistrationDto}
     * @return {@link RegistrationEntity}
     */
    @Mapping(target = "id", ignore = true)
    RegistrationEntity mergeToEntity(@MappingTarget RegistrationEntity registration,
                                    RegistrationDto registrationDto);
}
