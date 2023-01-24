package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.BankDetailsDto;
import com.bank.publicinfo.entity.BankDetailsEntity;

import java.util.List;

/**
 * Сервис для {@link BankDetailsEntity} и {@link BankDetailsDto}
 */
public interface BankDetailsService {

    /**
     * TODO @param ids технические идентификаторы и ссылку на entity.
     * @param ids технический идентификатор
     * @return лист {@link BankDetailsDto}
     */
    List<BankDetailsDto> findAllById(List<Long> ids);

    /**
     * @param bankDetails {@link BankDetailsDto}
     * @return {@link BankDetailsDto}
     */
    BankDetailsDto create(BankDetailsDto bankDetails);

    /**
     * TODO @param id технический идентификатор и ссылку на entity.
     * @param id технический идентификатор
     * @param bankDetails {@link BankDetailsDto}
     * @return {@link BankDetailsDto}
     */
    BankDetailsDto update(Long id, BankDetailsDto bankDetails);

    /**
     * TODO @param id технический идентификатор и ссылку на entity.
     * @param id технический идентификатор
     * @return {@link BankDetailsDto}
     */
    BankDetailsDto findById(Long id);
}
