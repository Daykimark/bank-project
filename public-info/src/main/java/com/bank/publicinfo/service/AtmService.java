package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.AtmDto;
import com.bank.publicinfo.entity.AtmEntity;

import java.util.List;

/**
 * Сервис для {@link AtmEntity} и {@link AtmDto}
 */
public interface AtmService {

    /**
     * TODO @param ids технические идентификаторы и ссылку на entity.
     * @param ids технический идентификатор
     * @return лист {@link AtmDto}
     */
    List<AtmDto> findAllById(List<Long> ids);

    /**
     * @param atm {@link AtmDto}
     * @return {@link AtmDto}
     */
    AtmDto create(AtmDto atm);

    /**
     * TODO @param id технический идентификатор и ссылку на entity.
     * @param id технический идентификатор
     * @param atm {@link AtmDto}
     * @return {@link AtmDto}
     */
    AtmDto update(Long id, AtmDto atm);

    /**
     * TODO @param id технический идентификатор и ссылку на entity.
     * @param id технический идентификатор
     * @return {@link AtmDto}
     */
    AtmDto findById(Long id);
}
