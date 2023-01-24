package com.bank.publicinfo.service.impl;

import com.bank.publicinfo.dto.LicenseDto;
import com.bank.publicinfo.entity.LicenseEntity;
import com.bank.publicinfo.mapper.LicenseMapper;
import com.bank.publicinfo.repository.LicenseRepository;
import com.bank.publicinfo.service.LicenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация {@link LicenseService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository repository;
    private final LicenseMapper mapper;

    /**
     * @param ids технический идентификатор {@link LicenseEntity}
     * @return лист {@link LicenseDto}
     */
    @Override
    public List<LicenseDto> findAllById(List<Long> ids) {
        final List<LicenseEntity> licenses = repository.findAllById(ids);

        if (licenses.size() < ids.size()) {
            final var entityNotFound = new EntityNotFoundException("Лицензий с id= " + ids + "не существует");
            log.error(entityNotFound.getMessage(), entityNotFound);
            throw entityNotFound;
        }

        return mapper.mergeToEntity(licenses);
    }

    /**
     * @param licenseDto {@link LicenseDto}
     * @return {@link LicenseDto}
     */
    @Override
    @Transactional
    public LicenseDto create(LicenseDto licenseDto) {
        final LicenseEntity license = repository.save(mapper.toEntity(licenseDto));
        return mapper.toDto(license);
    }

    /**
     * @param license  {@link LicenseDto}
     * TODO удали "измененный ".
     * @return измененный {@link LicenseDto}
     */
    @Override
    @Transactional
    public LicenseDto update(Long id, LicenseDto license) {
        final LicenseEntity entity = repository.findById(id)
                .orElseThrow(() -> {
                    log.error("Переданный id не найден!");
                    return new EntityNotFoundException("Данного id не существует!");
                });
        // TODO удали оставь пустую строку.
        final LicenseEntity updatedLicense = mapper.updateLicense(license, entity);
        return mapper.toDto(updatedLicense);
    }

    /**
     * TODO удали "лицензии" и добавь ссылку на entity.
     * @param id технический идентификатор лицензии
     * @return {@link LicenseDto}
     */
    @Override
    public LicenseDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Лицензия с id = " + id + " не найдена")));
    }
}
