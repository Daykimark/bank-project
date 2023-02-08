package com.bank.transfer.service.Impl;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.PhoneTransferEntity;
import com.bank.transfer.mapper.PhoneTransferMapper;
import com.bank.transfer.repository.PhoneTransferRepository;
import com.bank.transfer.service.PhoneTransferService;
import com.bank.transfer.service.common.EntityNotFoundReturner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация {@link PhoneTransferService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PhoneTransferServiceImpl implements PhoneTransferService {

    private final static String MESSAGE = "Не найден перевод по номеру телефона с ID ";

    private final PhoneTransferRepository repository;
    private final PhoneTransferMapper mapper;
    private final EntityNotFoundReturner notFoundReturner;

    /**
     * @param ids список технических идентификаторов {@link PhoneTransferEntity}
     * @return лист {@link PhoneTransferDto}
     */
    @Override
    public List<PhoneTransferDto> findAllById(List<Long> ids) {

        final List<PhoneTransferEntity> phoneTransfers = ids.stream()
                .map(id -> repository.findById(id)
                        .orElseThrow(() -> notFoundReturner.loggingAndGet(id, MESSAGE)))
                .toList();

        return mapper.toListDto(phoneTransfers);
    }

    /**
     * @param id технический идентификатор {@link PhoneTransferEntity}
     * @return {@link PhoneTransferDto}
     */
    @Override
    public PhoneTransferDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> notFoundReturner.loggingAndGet(id, MESSAGE))
        );
    }

    /**
     * @param phoneTransfer {@link PhoneTransferDto}
     * @return {@link PhoneTransferDto}
     */
    @Override
    @Transactional
    public PhoneTransferDto save(PhoneTransferDto phoneTransfer) {

        final PhoneTransferEntity transfer = repository.save(mapper.toEntity(phoneTransfer));

        return mapper.toDto(transfer);
    }

    /**
     * @param phoneTransferDto {@link PhoneTransferDto}
     * @param id технический идентификатор {@link PhoneTransferEntity}
     * @return {@link PhoneTransferDto}
     */
    @Override
    @Transactional
    public PhoneTransferDto update(Long id, PhoneTransferDto phoneTransferDto) {

        final PhoneTransferEntity transfer = repository.findById(id)
                .orElseThrow(() -> notFoundReturner.loggingAndGet(id, MESSAGE));

        final PhoneTransferEntity phoneTransfer = mapper.mergeToEntity(phoneTransferDto, transfer);

        return mapper.toDto(repository.save(phoneTransfer));
    }
}
