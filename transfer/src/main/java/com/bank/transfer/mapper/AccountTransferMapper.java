package com.bank.transfer.mapper;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Mapper для {@link AccountTransferEntity} и {@link AccountTransferDto}
 */
@Mapper(componentModel = "spring")
public interface AccountTransferMapper {

    /**
     * @param accountTransfer {@link AccountTransferEntity} TODO тут ссылка на AccountTransferDto должна быть.
     * @return {@link AccountTransferDto}
     */
    @Mapping(target = "id", ignore = true)
    AccountTransferEntity toEntity(AccountTransferDto accountTransfer);

    /**
     * @param accountTransfer {@link AccountTransferEntity}
     * @return {@link AccountTransferDto}
     */
    AccountTransferDto toDto(AccountTransferEntity accountTransfer);

    /**
     * @param accountTransfers список {@link AccountTransferEntity}
     * @return список {@link AccountTransferDto}
     */
    List<AccountTransferDto> toListDto(List<AccountTransferEntity> accountTransfers);

    /**
     * @param accountTransferDto {@link AccountTransferDto}
     * @param accountTransfer {@link AccountTransferEntity}
     * @return {@link AccountTransferEntity}
     */
    @Mapping(target = "id", ignore = true)
    AccountTransferEntity mergeToEntity(AccountTransferDto accountTransferDto,
                                        @MappingTarget AccountTransferEntity accountTransfer);
}
