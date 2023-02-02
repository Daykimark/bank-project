package com.bank.transfer.service.Impl;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransferEntity;
import com.bank.transfer.mapper.CardTransferMapper;
import com.bank.transfer.repository.CardTransferRepository;
import com.bank.transfer.service.CardTransferService;
import com.bank.transfer.service.common.EntityNotFoundReturner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация {@link CardTransferService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CardTransferServiceImpl implements CardTransferService {

    private final static String MESSAGE = "Не найден перевод по номеру карты с ID ";

    private final CardTransferRepository repository;
    private final CardTransferMapper mapper;
    private final EntityNotFoundReturner notFoundReturner;

    /**
     * @param ids список технических идентификаторов {@link CardTransferEntity}
     * @return лист {@link CardTransferDto}
     */
    @Override
    public List<CardTransferDto> findAllById(List<Long> ids) {

        final List<CardTransferEntity> cardTransfers = ids.stream()
                .map(id -> repository.findById(id)
                        .orElseThrow(() -> notFoundReturner.loggingAndGet(id, MESSAGE)))
                .toList();

        return mapper.toListDto(cardTransfers);
    }

    /**
     * @param id технический идентификатор {@link CardTransferEntity}
     * @return {@link CardTransferDto}
     */
    @Override
    public CardTransferDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> notFoundReturner.loggingAndGet(id, MESSAGE))
        );
    }

    /**
     * @param cardTransfer {@link CardTransferDto}
     * @return {@link CardTransferDto}
     */
    @Override
    @Transactional
    public CardTransferDto save(CardTransferDto cardTransfer) {

        final CardTransferEntity transfer = repository.save(mapper.toEntity(cardTransfer));

        return mapper.toDto(transfer);
    }

    /**
     * @param cardTransferDto {@link CardTransferDto}
     * @param id технический идентификатор {@link CardTransferEntity}
     * @return {@link CardTransferDto}
     */
    @Override
    @Transactional
    public CardTransferDto update(Long id, CardTransferDto cardTransferDto) {

        final CardTransferEntity transfer = repository.findById(id)
                 .orElseThrow(() -> notFoundReturner.loggingAndGet(id, MESSAGE)
                );

        final CardTransferEntity cardTransfer = (mapper.mergeToEntity(cardTransferDto, transfer));

        return mapper.toDto(repository.save(cardTransfer));
    }
}
