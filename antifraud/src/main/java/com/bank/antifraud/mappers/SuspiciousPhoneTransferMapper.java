package com.bank.antifraud.mappers;

import com.bank.antifraud.dto.SuspiciousPhoneTransferDto;
import com.bank.antifraud.entity.SuspiciousPhoneTransferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * TODO mapper для {@link SuspiciousPhoneTransferEntity} и {@link SuspiciousPhoneTransferDto}.
 * Нужен для маппинга {@link SuspiciousPhoneTransferEntity} в {@link SuspiciousPhoneTransferDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface SuspiciousPhoneTransferMapper {
    // TODO удали и оставь пустую строку.
    /**
     * @param suspiciousTransfer {@link SuspiciousPhoneTransferEntity}
     * @return {@link SuspiciousPhoneTransferDto}
     */
    SuspiciousPhoneTransferDto toDto(SuspiciousPhoneTransferEntity suspiciousTransfer);

    /**
     * @param suspiciousTransfer {@link SuspiciousPhoneTransferDto}
     * @return {@link SuspiciousPhoneTransferEntity}
     */
    @Mapping(target = "id", ignore = true)
    SuspiciousPhoneTransferEntity toEntity(SuspiciousPhoneTransferDto suspiciousTransfer);

    /**
     * @param suspiciousTransfers список {@link SuspiciousPhoneTransferEntity}
     * @return список {@link SuspiciousPhoneTransferDto}
     */
    List<SuspiciousPhoneTransferDto> toListDto(List<SuspiciousPhoneTransferEntity> suspiciousTransfers);

    /**
     * @param phoneTransfer {@link SuspiciousPhoneTransferDto}
     * @param suspiciousTransfer {@link SuspiciousPhoneTransferEntity}
     * @return {@link SuspiciousPhoneTransferEntity}
     */
    @Mapping(target = "id", ignore = true)
    SuspiciousPhoneTransferEntity mergeToEntity(/*TODO SuspiciousPhoneTransferDto phoneTransfer перенеси сюда*/
            SuspiciousPhoneTransferDto phoneTransfer,
            @MappingTarget SuspiciousPhoneTransferEntity suspiciousTransfer
    );
}
