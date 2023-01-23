package com.bank.mapper;

import com.bank.dto.PassportDto;
import com.bank.model.PassportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Маппер для {@link PassportEntity} и {@link PassportDto}
 */
@Mapper(componentModel = "spring")
public interface PassportMapper {

    /**
     * @param passport {@link PassportDto}
     * @return {@link PassportEntity}
     */
    PassportEntity toEntity(PassportDto passport);

    /**
     * @param passport {@link PassportEntity}
     * @return {@link PassportDto}
     */
    PassportDto toDto(PassportEntity passport);

    /**
     * @param passports {@link List<PassportEntity>}
     * @return {@link List<PassportDto>}
     */
    List<PassportDto> toDtoList(List<PassportEntity> passports);

    /**
     * @param passportEntity {@link PassportEntity}
     * @param passportDto {@link PassportDto}
     * @return {@link PassportEntity}
     */
    @Mappings({
            @Mapping(target = "id", source = "id", ignore = true),
            @Mapping(target = "registration.id", source = "registration.id", ignore = true)
    })
    PassportEntity updateEntity(@MappingTarget PassportEntity passportEntity,
                                        PassportDto passportDto);
}
