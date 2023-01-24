package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.LicenseDto;
import com.bank.publicinfo.entity.LicenseEntity;

import java.util.List;

/**
 * Сервис для {@link LicenseEntity} и {@link LicenseDto}
 */
public interface LicenseService {

    /**
     * TODO @param ids технические идентификаторы и ссылку на entity.
     * @param ids технический идентификатор
     * @return лист {@link LicenseDto}
     */
    List<LicenseDto> findAllById(List<Long> ids);

    /**
     * @param license {@link LicenseDto}
     * @return {@link LicenseDto}
     */
    LicenseDto create(LicenseDto license);

    /**
     * TODO @param id технический идентификатор и ссылку на entity.
     * @param id технический идентификатор
     * @param license {@link LicenseDto}
     * @return {@link LicenseDto}
     */
    LicenseDto update(Long id, LicenseDto license);

    /**
     * TODO @param id технический идентификатор и ссылку на entity.
     * @param id технический идентификатор
     * @return {@link LicenseDto}
     */
    LicenseDto findById(Long id);
}
