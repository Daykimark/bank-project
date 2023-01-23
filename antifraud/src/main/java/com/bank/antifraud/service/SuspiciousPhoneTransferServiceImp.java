package com.bank.antifraud.service;

import com.bank.antifraud.dto.SuspiciousPhoneTransferDto;
import com.bank.antifraud.entity.SuspiciousPhoneTransferEntity;
import com.bank.antifraud.mappers.SuspiciousPhoneTransferMapper;
import com.bank.antifraud.repository.SuspiciousPhoneTransferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Реализация {@link SuspiciousPhoneTransferService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SuspiciousPhoneTransferServiceImp implements SuspiciousPhoneTransferService {
    // TODO удали и оставь пустую строку.
    private final SuspiciousPhoneTransferRepository repository;
    private final SuspiciousPhoneTransferMapper mapper;

    /**
     * @param phoneTransfer {@link SuspiciousPhoneTransferDto}
     * @return {@link SuspiciousPhoneTransferDto}
     */
    @Override
    @Transactional
    public SuspiciousPhoneTransferDto save(SuspiciousPhoneTransferDto phoneTransfer) {
        final SuspiciousPhoneTransferEntity suspiciousTransfer = repository.save(
                mapper.toEntity(phoneTransfer)
        );
        return mapper.toDto(suspiciousTransfer);
    }

    /**
     * @param id технический идентификатор {@link SuspiciousPhoneTransferEntity}
     * @return {@link SuspiciousPhoneTransferDto}
     */
    @Override
    public SuspiciousPhoneTransferDto findById(Long id) {
        // TODO привести к виду
        //  return mapper.toDto(repository.findById(id)
        //                .orElseThrow(this::getEntityNotFoundException)
        //  );
        return mapper.toDto(repository.findById(id).orElseThrow(this::getEntityNotFoundException));
    }

    /**
     * @param phoneTransfer {@link SuspiciousPhoneTransferDto}
     * @param id технический идентификатор {@link SuspiciousPhoneTransferEntity}
     * @return {@link SuspiciousPhoneTransferDto}
     */
    @Override
    @Transactional
    public SuspiciousPhoneTransferDto update(Long id, SuspiciousPhoneTransferDto phoneTransfer) {
        // TODO удали пустую строку.
        final SuspiciousPhoneTransferEntity suspiciousTransfer = repository.findById(id)
                .orElseThrow(this::getEntityNotFoundException);
        // TODO удали и оставь пустую строку. И локальную переменную transfer напиши в одну строку.
        final SuspiciousPhoneTransferEntity transfer = mapper.mergeToEntity(
                phoneTransfer, suspiciousTransfer
        );
        // TODO удали и оставь пустую строку.
        return mapper.toDto(transfer);
    }

    /**
     * @param ids список технический идентификаторов {@link SuspiciousPhoneTransferEntity}
     * @return лист {@link SuspiciousPhoneTransferDto}
     */
    @Override
    public List<SuspiciousPhoneTransferDto> findAllById(List<Long> ids) {
        // TODO удали и оставь пустую строку.
        final List<SuspiciousPhoneTransferEntity> suspiciousPhoneTransfers = ids.stream()
                .map(id -> repository.findById(id)
                        .orElseThrow(this::getEntityNotFoundException))
                .toList();
        // TODO удали и оставь пустую строку.
        return mapper.toListDto(suspiciousPhoneTransfers);
    }

    private RuntimeException getEntityNotFoundException() {
        final RuntimeException ex = new EntityNotFoundException("Данного id не существует.");
        log.error(ex.getMessage(), ex);
        return ex;
    }
}
