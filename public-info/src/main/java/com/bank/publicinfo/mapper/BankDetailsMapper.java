package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.BankDetailsDto;
import com.bank.publicinfo.entity.BankDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Mapper {@link BankDetailsEntity} и {@link BankDetailsDto}
 */
@Mapper(componentModel = "spring")
public interface BankDetailsMapper {

    /**
     * @param bankDetails {@link BankDetailsEntity}
     * @return {@link BankDetailsDto}
     */
    BankDetailsDto toDto(BankDetailsEntity bankDetails);

    /**
     * @param bankDetails {@link BankDetailsDto}
     * @return {@link BankDetailsEntity}
     */
    BankDetailsEntity toEntity(BankDetailsDto bankDetails);

    /**
     * @param bankDetailsList лист с {@link BankDetailsEntity}
     * @return лист с {@link BankDetailsDto}
     */
    List<BankDetailsDto> toDtoList(List<BankDetailsEntity> bankDetailsList);

    /**
     * @param bankDetailsDto {@link BankDetailsDto}
     * @param bankDetails {@link BankDetailsEntity}
     * @return {@link BankDetailsEntity}
     */
    @Mapping(target = "id", ignore = true)
    BankDetailsEntity mergeToEntity(BankDetailsDto bankDetailsDto, @MappingTarget BankDetailsEntity bankDetails);
}
