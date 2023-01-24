package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.CertificateDto;
import com.bank.publicinfo.dto.LicenseDto;
import com.bank.publicinfo.entity.LicenseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * TODO Маппер для {@link LicenseEntity} и {@link LicenseDto}.
 * Маппер {@link LicenseEntity} в {@link LicenseDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface LicenseMapper {

    /**
     * @param license {@link LicenseEntity}
     * @return {@link LicenseDto}
     */
    LicenseDto toDto(LicenseEntity license);

    /**
     * TODO licenseDto переименуй в license и ссылку на {@link CertificateDto}, удали "DTO".
     * @param licenseDto DTO {@link CertificateDto}
     * @return {@link LicenseEntity}
     */
    LicenseEntity toEntity(LicenseDto licenseDto);

    /**
     * @param licenses лист c {@link LicenseEntity}
     * @return лист с {@link LicenseDto}
     */
    List<LicenseDto> mergeToEntity(List<LicenseEntity> licenses);

    /**
     * TODO dto в licenseDto.
     * @param dto {@link LicenseDto}
     * TODO entity в license.
     * @param entity {@link LicenseEntity}
     * @return {@link LicenseEntity}
     */
    @Mappings({
            // TODO source в 47 и 48 строках удалить.
            @Mapping(target = "id", source = "id", ignore = true),
            @Mapping(target = "bankDetails.id", source = "bankDetails.id", ignore = true)
    })
    // TODO updateLicense переименуй в mergeToEntity, dto в licenseDto, entity в license.
    LicenseEntity updateLicense(LicenseDto dto, @MappingTarget LicenseEntity entity);
}
