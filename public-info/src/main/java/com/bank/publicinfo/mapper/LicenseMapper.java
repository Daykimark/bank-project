package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.LicenseDto;
import com.bank.publicinfo.entity.LicenseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Mapper {@link LicenseEntity} и {@link LicenseDto}
 */
@Mapper(componentModel = "spring")
public interface LicenseMapper {

    /**
     * @param license {@link LicenseEntity}
     * @return {@link LicenseDto}
     */
    LicenseDto toDto(LicenseEntity license);

    /**
     * @param license {@link LicenseDto}
     * @return {@link LicenseEntity}
     */
    LicenseEntity toEntity(LicenseDto license);

    /**
     * @param licenses лист c {@link LicenseEntity}
     * @return лист с {@link LicenseDto}
     */
    List<LicenseDto> toDtoList(List<LicenseEntity> licenses);

    /**
     * @param licenseDto {@link LicenseDto}
     * @param license {@link LicenseEntity}
     * @return {@link LicenseEntity}
     */
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "bankDetails.id", ignore = true)
    })
    LicenseEntity mergeToEntity(LicenseDto licenseDto, @MappingTarget LicenseEntity license);
}
