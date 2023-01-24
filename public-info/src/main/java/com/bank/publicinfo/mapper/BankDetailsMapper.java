package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.BankDetailsDto;
import com.bank.publicinfo.entity.BankDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * TODO Маппер для {@link BankDetailsEntity} и {@link BankDetailsDto}.
 * Маппер {@link BankDetailsEntity} в {@link BankDetailsDto} и обратно
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
     * TODO detalis переименуй в bankDetailsList.
     * @param detalis лист с {@link BankDetailsEntity}
     * @return лист с {@link BankDetailsDto}
     */
    List<BankDetailsDto> toDtoList(List<BankDetailsEntity> detalis);

    /**
     * TODO dto переименуй в bankDetailsDto.
     * @param dto {@link BankDetailsDto}
     * TODO entity переименуй в bankDetails.
     * @param entity {@link BankDetailsEntity}
     * @return {@link BankDetailsEntity}
     */
    // TODO тут удали " source = "id".
    @Mapping(target = "id", source = "id", ignore = true)
    //TODO entity переименуй в bankDetails.
    BankDetailsEntity mergeToEntity(BankDetailsDto dto, @MappingTarget BankDetailsEntity entity);
}
