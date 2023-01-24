package com.bank.publicinfo.service.impl;

import com.bank.publicinfo.dto.BankDetailsDto;
import com.bank.publicinfo.entity.BankDetailsEntity;
import com.bank.publicinfo.mapper.BankDetailsMapper;
import com.bank.publicinfo.repository.BankDetailsRepository;
import com.bank.publicinfo.service.BankDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация {@link BankDetailsService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BankDetailsServiceImpl implements BankDetailsService {

    private final BankDetailsRepository repository;
    private final BankDetailsMapper mapper;

    /**
     * @param ids список техничских идентификаторов {@link BankDetailsEntity}
     * @return лист {@link BankDetailsDto}
     */
    @Override
    public List<BankDetailsDto> findAllById(List<Long> ids) {
        final List<BankDetailsEntity> bankDetails = repository.findAllById(ids);

        if (bankDetails.size() < ids.size()) {
            final var entityNotFound = new EntityNotFoundException("Информации о банке с id= " + ids + "не существует");
            log.error(entityNotFound.getMessage(), entityNotFound);
            throw entityNotFound;
        }

        return mapper.toDtoList(bankDetails);
    }

    /**
     * @param bankDetailsDto {@link BankDetailsDto} общедоступной информации
     * @return {@link BankDetailsDto}
     */
    @Override
    @Transactional
    public BankDetailsDto create(BankDetailsDto bankDetailsDto) {
        final BankDetailsEntity bankDetails = repository.save(mapper.toEntity(bankDetailsDto));
        return mapper.toDto(bankDetails);
    }

    /**
     * @param bankDetails {@link BankDetailsDto}
     * TODO удали "измененный ".
     * @return измененный {@link BankDetailsDto}
     */
    @Override
    @Transactional
    public BankDetailsDto update(Long id, BankDetailsDto bankDetails) {
        final BankDetailsEntity entity = repository.findById(id)
                .orElseThrow(() -> {
                    log.error("Переданный id не найден!");
                    return new EntityNotFoundException("Данного id не существует!");
                });
        final BankDetailsEntity updatedDetails = mapper.mergeToEntity(bankDetails, entity);
        return mapper.toDto(updatedDetails);
    }

    /**
     * TODO удали "информации о банке" и просто добавь ссылку на entity.
     * @param id технический идентификатор информации о банке
     * @return {@link BankDetailsDto}
     */
    @Override
    public BankDetailsDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Информация о банке с id = " + id + " не найдена")));
    }
}
