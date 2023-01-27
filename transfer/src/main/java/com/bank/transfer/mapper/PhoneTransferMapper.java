package com.bank.transfer.mapper;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.PhoneTransferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Mapper для {@link PhoneTransferEntity} и {@link PhoneTransferDto}
 */
@Mapper(componentModel = "spring")
public interface PhoneTransferMapper {

    /**
     * @param phoneTransfer {@link PhoneTransferEntity} TODO тут ссылка на PhoneTransferDto должна быть.
     * @return {@link PhoneTransferDto}
     */
    @Mapping(target = "id", ignore = true)
    PhoneTransferEntity toEntity(PhoneTransferDto phoneTransfer);

    /**
     * @param phoneTransfer {@link PhoneTransferEntity}
     * @return {@link PhoneTransferDto}
     */
    PhoneTransferDto toDto(PhoneTransferEntity phoneTransfer);

    /**
     * @param phoneTransfers список {@link PhoneTransferEntity}
     * @return список {@link PhoneTransferDto}
     */
    List<PhoneTransferDto> toListDto(List<PhoneTransferEntity> phoneTransfers);

    /**
     * @param phoneTransferDto {@link PhoneTransferDto}
     * @param phoneTransfer {@link PhoneTransferEntity}
     * @return {@link PhoneTransferEntity}
     */
    @Mapping(target = "id", ignore = true)
    PhoneTransferEntity mergeToEntity(PhoneTransferDto phoneTransferDto,
                                      @MappingTarget PhoneTransferEntity phoneTransfer);
}
