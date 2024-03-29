package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.CertificateDto;
import com.bank.publicinfo.entity.CertificateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Mapper {@link CertificateEntity} и {@link CertificateDto}
 */
@Mapper(componentModel = "spring")
public interface CertificateMapper {

    /**
     * @param certificate {@link CertificateEntity}
     * @return {@link CertificateDto}
     */
    CertificateDto toDto(CertificateEntity certificate);

    /**
     * @param certificate {@link CertificateDto}
     * @return {@link CertificateEntity}
     */

    CertificateEntity toEntity(CertificateDto certificate);

    /**
     * @param certificates лист с {@link CertificateEntity}
     * @return лист с {@link CertificateDto}
     */
    List<CertificateDto> toDtoList(List<CertificateEntity> certificates);

    /**
     * @param certificateDto {@link CertificateDto}
     * @param certificate {@link CertificateEntity}
     * @return {@link CertificateEntity}
     */
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "bankDetails.id", ignore = true)
    })
    CertificateEntity mergeToEntity(CertificateDto certificateDto, @MappingTarget CertificateEntity certificate);
}
