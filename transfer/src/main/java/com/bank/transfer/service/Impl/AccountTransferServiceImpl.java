package com.bank.transfer.service.Impl;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransferEntity;
import com.bank.transfer.mapper.AccountTransferMapper;
import com.bank.transfer.repository.AccountTransferRepository;
import com.bank.transfer.service.AccountTransferService;
import com.bank.transfer.service.common.EntityNotFoundReturner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация {@link AccountTransferService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccountTransferServiceImpl implements AccountTransferService {
    // TODO удалить и оставить пустую строку.
    private final static String MESSAGE = "Не найден перевод по номеру счета с ID ";
    // TODO удалить и оставить пустую строку.
    private final AccountTransferRepository repository;
    private final AccountTransferMapper mapper;
    // TODO entityNotFoundReturner переименуй в notFoundReturner.
    private final EntityNotFoundReturner entityNotFoundReturner;

    // TODO удалить пустую строку.
    /**
     * @param ids список технических идентификаторов {@link AccountTransferEntity}
     * @return лист {@link AccountTransferDto}
     */
    @Override
    public List<AccountTransferDto> findAllById(List<Long> ids) {

        final List<AccountTransferEntity> accountTransfers = ids.stream()
                .map(id -> repository.findById(id)
                        .orElseThrow(() -> entityNotFoundReturner.loggingAndGet(id, MESSAGE)))
                .toList();

        return mapper.toListDto(accountTransfers);
    }

    /**
     * @param id технический идентификатор {@link AccountTransferEntity}
     * @return {@link AccountTransferDto}
     */
    @Override
    public AccountTransferDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                       .orElseThrow(() -> entityNotFoundReturner.loggingAndGet(id, MESSAGE))
        );
    }

    /**
     * @param accountTransfer {@link AccountTransferDto}
     * @return {@link AccountTransferDto}
     */
    @Override
    @Transactional
    public AccountTransferDto save(AccountTransferDto accountTransfer) {

        final AccountTransferEntity transfer = repository.save(mapper.toEntity(accountTransfer));

        return mapper.toDto(transfer);
    }

    /**
     * @param accountTransferDto {@link AccountTransferDto}
     * @param id технический идентификатор {@link AccountTransferEntity}
     * @return {@link AccountTransferDto}
     */
    @Override
    @Transactional
    public AccountTransferDto update(Long id, AccountTransferDto accountTransferDto) {

        final AccountTransferEntity transfer = repository.findById(id)
                .orElseThrow(() -> entityNotFoundReturner.loggingAndGet(id, MESSAGE)
                );

        final AccountTransferEntity accountTransfer = mapper.mergeToEntity(accountTransferDto, transfer);

        return mapper.toDto(repository.save(accountTransfer));
    }
}
