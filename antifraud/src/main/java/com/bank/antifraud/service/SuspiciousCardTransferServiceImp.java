package com.bank.antifraud.service;

import com.bank.antifraud.dto.SuspiciousCardTransferDto;
import com.bank.antifraud.entity.SuspiciousCardTransferEntity;
import com.bank.antifraud.mappers.SuspiciousCardTransferMapper;
import com.bank.antifraud.repository.SuspiciousCardTransferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Реализация {@link SuspiciousCardTransferService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SuspiciousCardTransferServiceImp implements SuspiciousCardTransferService {
    // TODO удали и оставь пустую строку.
    private final SuspiciousCardTransferRepository repository;
    private final SuspiciousCardTransferMapper mapper;

    /**
     * @param cardTransfer {@link SuspiciousCardTransferDto}
     * @return {@link SuspiciousCardTransferDto}
     */
    @Override
    @Transactional
    public SuspiciousCardTransferDto save(SuspiciousCardTransferDto cardTransfer) {
        final SuspiciousCardTransferEntity suspiciousTransfer = repository.save(
                mapper.toEntity(cardTransfer)
        );
        return mapper.toDto(suspiciousTransfer);
    }

    /**
     * @param id технический идентификатор {@link SuspiciousCardTransferEntity}
     * @return {@link SuspiciousCardTransferDto}
     */
    @Override
    public SuspiciousCardTransferDto findById(Long id) {
        // TODO привести к виду
        //  return mapper.toDto(repository.findById(id)
        //                .orElseThrow(this::getEntityNotFoundException)
        //  );
        return mapper.toDto(repository.findById(id).orElseThrow(this::getEntityNotFoundException));
    }

    /**
     * @param cardTransfer {@link SuspiciousCardTransferDto}
     * @param id технический идентификатор {@link SuspiciousCardTransferEntity}
     * @return {@link SuspiciousCardTransferDto}
     */
    @Override
    @Transactional
    public SuspiciousCardTransferDto update(Long id, SuspiciousCardTransferDto cardTransfer) {
        // TODO удали пустую строку.
        final SuspiciousCardTransferEntity suspiciousTransfer = repository.findById(id)
                .orElseThrow(this::getEntityNotFoundException);
        // TODO удали и оставь пустую строку. И локальную переменную transfer напиши в одну строку.
        final SuspiciousCardTransferEntity transfer = mapper.mergeToEntity(
                cardTransfer, suspiciousTransfer
        );
        // TODO удали и оставь пустую строку.
        return mapper.toDto(transfer);
    }

    /**
     * @param ids список технических идентификаторов {@link SuspiciousCardTransferEntity}
     * @return лист {@link SuspiciousCardTransferDto}
     */
    @Override
    public List<SuspiciousCardTransferDto> findAllById(List<Long> ids) {
        final List<SuspiciousCardTransferEntity> suspiciousCardTransfers = ids.stream()
                .map(id -> repository.findById(id)
                        .orElseThrow(this::getEntityNotFoundException))
                .toList();
        // TODO удали и оставь пустую строку.
        return mapper.toListDto(suspiciousCardTransfers);
    }

    // TODO это функционал дублируется, в разных имплементациях, вынеси в отдельный класс-компонент
    private RuntimeException getEntityNotFoundException() {
        final RuntimeException ex = new EntityNotFoundException("Данного id не существует.");
        log.error(ex.getMessage(), ex);
        return ex;
    }
}
