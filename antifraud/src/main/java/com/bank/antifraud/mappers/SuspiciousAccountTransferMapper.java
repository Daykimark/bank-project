package com.bank.antifraud.mappers;

import com.bank.antifraud.dto.SuspiciousAccountTransferDto;
import com.bank.antifraud.entity.SuspiciousAccountTransferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * TODO mapper для {@link SuspiciousAccountTransferEntity} и {@link SuspiciousAccountTransferDto}.
 * Нужен для маппинга {@link SuspiciousAccountTransferEntity} в {@link SuspiciousAccountTransferDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface SuspiciousAccountTransferMapper {
    // TODO удали и оставь пустую строку.
    /**
     * @param suspiciousTransfer {@link SuspiciousAccountTransferEntity}
     * @return {@link SuspiciousAccountTransferDto}
     */
    SuspiciousAccountTransferDto toDto(SuspiciousAccountTransferEntity suspiciousTransfer);

    /**
     * @param suspiciousTransfer {@link SuspiciousAccountTransferEntity}
     * @return {@link SuspiciousAccountTransferDto}
     */
    @Mapping(target = "id", ignore = true)
    SuspiciousAccountTransferEntity toEntity(SuspiciousAccountTransferDto suspiciousTransfer);

    /**
     * @param suspiciousTransfers список {@link SuspiciousAccountTransferEntity}
     * @return список {@link SuspiciousAccountTransferDto}
     */
    List<SuspiciousAccountTransferDto> toListDto(List<SuspiciousAccountTransferEntity> suspiciousTransfers);

    /**
     * @param accountTransfer {@link SuspiciousAccountTransferDto}
     * @param suspiciousTransfer {@link SuspiciousAccountTransferEntity}
     * @return {@link SuspiciousAccountTransferEntity}
     */
    @Mapping(target = "id", ignore = true)
    SuspiciousAccountTransferEntity mergeToEntity(/*TODO SuspiciousAccountTransferDto accountTransfer перенеси сюда*/
            SuspiciousAccountTransferDto accountTransfer,
            @MappingTarget SuspiciousAccountTransferEntity suspiciousTransfer
    );
}
