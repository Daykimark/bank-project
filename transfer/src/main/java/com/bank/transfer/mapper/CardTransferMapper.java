package com.bank.transfer.mapper;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Mapper для {@link CardTransferEntity} и {@link CardTransferDto}
 */
@Mapper(componentModel = "spring")
public interface CardTransferMapper {

    /**
     * @param cardTransfer {@link CardTransferDto}
     * @return {@link CardTransferEntity}
     */
    @Mapping(target = "id", ignore = true)
    CardTransferEntity toEntity(CardTransferDto cardTransfer);

    /**
     * @param cardTransfer {@link CardTransferEntity}
     * @return {@link CardTransferDto}
     */
    CardTransferDto toDto(CardTransferEntity cardTransfer);

    /**
     * @param cardTransfers список {@link CardTransferEntity}
     * @return список {@link CardTransferDto}
     */
    List<CardTransferDto> toListDto(List<CardTransferEntity> cardTransfers);

    /**
     * @param cardTransferDto {@link CardTransferDto}
     * @param cardTransfer {@link CardTransferEntity}
     * @return {@link CardTransferEntity}
     */
    @Mapping(target = "id", ignore = true)
    CardTransferEntity mergeToEntity(CardTransferDto cardTransferDto,
                                     @MappingTarget CardTransferEntity cardTransfer);
}
