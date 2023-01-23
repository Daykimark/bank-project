package com.bank.history.service;

import com.bank.history.dto.HistoryDto;
import com.bank.history.entity.HistoryEntity;

import java.util.List;

/**
 * Сервис для {@link HistoryEntity} и {@link HistoryDto}.
 */

public interface HistoryService {

    /**
     * @param history {@link HistoryDto}.
     * @return {@link HistoryDto}.
     */
    HistoryDto create(HistoryDto history);

    /**
     * @param id технический идентификатор {@link HistoryEntity}.
     * @return {@link HistoryDto}.
     */
    HistoryDto findById(Long id);

    /**
     * @param id технический идентификатор {@link HistoryEntity}.
     * @param history {@link HistoryDto}.
     * @return {@link HistoryDto}.
     */
    HistoryDto update(Long id, HistoryDto history);

    /**
     * @param ids лист технических идентификаторов {@link HistoryEntity}.
     * @return лист {@link HistoryDto}.
     */
    List<HistoryDto> findAllById(List<Long> ids);
}
