package com.bank.antifraud.service;
// TODO сделай пакет impl и туда перенеси все реализации
import com.bank.antifraud.dto.SuspiciousAccountTransferDto;
import com.bank.antifraud.entity.SuspiciousAccountTransferEntity;
import com.bank.antifraud.mappers.SuspiciousAccountTransferMapper;
import com.bank.antifraud.repository.SuspiciousAccountTransferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Реализация {@link SuspiciousAccountTransferService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SuspiciousAccountTransferServiceImp implements SuspiciousAccountTransferService {
    // TODO удали и оставь пустую строку.
    private final SuspiciousAccountTransferRepository repository;
    private final SuspiciousAccountTransferMapper mapper;

    /**
     * @param accountTransfer {@link SuspiciousAccountTransferDto}
     * @return {@link SuspiciousAccountTransferDto}
     */
    @Override
    @Transactional
    public SuspiciousAccountTransferDto save(SuspiciousAccountTransferDto accountTransfer) {
        final SuspiciousAccountTransferEntity suspiciousTransfer = repository.save(
                mapper.toEntity(accountTransfer)
        );
        return mapper.toDto(suspiciousTransfer);
    }

    /**
     * @param id технический идентификатор {@link SuspiciousAccountTransferEntity}
     * @return {@link SuspiciousAccountTransferDto}
     */
    @Override
    public SuspiciousAccountTransferDto findById(Long id) {
        // TODO привести к виду
        //  return mapper.toDto(repository.findById(id)
        //                .orElseThrow(this::getEntityNotFoundException)
        //  );
        return mapper.toDto(repository.findById(id).orElseThrow(this::getEntityNotFoundException));
    }

    /**
     * @param accountTransfer {@link SuspiciousAccountTransferDto}
     * @param id технический идентификатор {@link SuspiciousAccountTransferEntity}
     * @return {@link SuspiciousAccountTransferDto}
     */
    @Override
    @Transactional
    public SuspiciousAccountTransferDto update(Long id, SuspiciousAccountTransferDto accountTransfer) {
        // TODO удали пустую строку.
        final SuspiciousAccountTransferEntity suspiciousTransfer = repository.findById(id)
                .orElseThrow(this::getEntityNotFoundException);
        // TODO удали и оставь пустую строку. И локальную переменную transfer напиши в одну строку.
        final SuspiciousAccountTransferEntity transfer = mapper.mergeToEntity(
                accountTransfer, suspiciousTransfer
        );
        // TODO удали и оставь пустую строку.
        return mapper.toDto(transfer);
    }

    /**
     * @param ids список технических идентификаторов {@link SuspiciousAccountTransferEntity}
     * @return лист {@link SuspiciousAccountTransferDto}
     */
    @Override
    public List<SuspiciousAccountTransferDto> findAllById(List<Long> ids) {
        // TODO удали и оставь пустую строку.
        final List<SuspiciousAccountTransferEntity> suspiciousAccountTransfers = ids.stream()
                .map(id -> repository.findById(id)
                        .orElseThrow(this::getEntityNotFoundException))
                .toList();
        // TODO удали и оставь пустую строку.
        return mapper.toListDto(suspiciousAccountTransfers);
    }

    private RuntimeException getEntityNotFoundException() {
        // TODO в такие методы принимай название сущности, а то в логах должно быть сразу понятно.
        final RuntimeException ex = new EntityNotFoundException("Данного id не существует.");
        log.error(ex.getMessage(), ex);
        return ex;
    }
}
