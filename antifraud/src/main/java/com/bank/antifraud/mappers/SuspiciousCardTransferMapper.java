package com.bank.antifraud.mappers;

import com.bank.antifraud.dto.SuspiciousCardTransferDto;
import com.bank.antifraud.entity.SuspiciousCardTransferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * TODO mapper для {@link SuspiciousCardTransferEntity} и {@link SuspiciousCardTransferDto}.
 * Нужен для маппинга {@link SuspiciousCardTransferEntity} в {@link SuspiciousCardTransferDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface SuspiciousCardTransferMapper {
    // TODO удали и оставь пустую строку.
    /**
     * @param suspiciousTransfer {@link SuspiciousCardTransferEntity}
     * @return {@link SuspiciousCardTransferDto}
     */
    SuspiciousCardTransferDto toDto(SuspiciousCardTransferEntity suspiciousTransfer);

    /**
     * @param suspiciousTransfer {@link SuspiciousCardTransferDto}
     * @return {@link SuspiciousCardTransferEntity}
     */
    @Mapping(target = "id", ignore = true)
    SuspiciousCardTransferEntity toEntity(SuspiciousCardTransferDto suspiciousTransfer);

    /**
     * @param suspiciousTransfers список {@link SuspiciousCardTransferEntity}
     * @return список {@link SuspiciousCardTransferDto}
     */
    List<SuspiciousCardTransferDto> toListDto(List<SuspiciousCardTransferEntity> suspiciousTransfers);

    /**
     * @param cardTransfer {@link SuspiciousCardTransferDto}
     * @param suspiciousTransfer {@link SuspiciousCardTransferEntity}
     * @return {@link SuspiciousCardTransferEntity}
     */
    @Mapping(target = "id", ignore = true)
    SuspiciousCardTransferEntity mergeToEntity(/*TODO SuspiciousCardTransferDto cardTransfer перенеси сюда*/
            SuspiciousCardTransferDto cardTransfer,
            @MappingTarget SuspiciousCardTransferEntity suspiciousTransfer
    );
}
