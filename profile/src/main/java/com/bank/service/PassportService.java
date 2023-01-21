package com.bank.service;

import com.bank.dto.PassportDto;
import com.bank.model.PassportEntity;

import java.util.List;

/**
 * Сервис {@link PassportEntity} {@link PassportDto}
 */

public interface PassportService {

    /**
     * @param id технический идентификатор {@link PassportEntity}
     * @return {@link PassportDto}
     */
    PassportDto findById(Long id);

    /**
     * @param ids лист технических идентификаторов
     * @return {@link List<PassportDto>}
     */
    List<PassportDto> findAllById(List<Long> ids);

    /**
     * @param dto {@link PassportDto}
     * @return {@link PassportDto}
     */
    PassportDto save(PassportDto dto);
}
