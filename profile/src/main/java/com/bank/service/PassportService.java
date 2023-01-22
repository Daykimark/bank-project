package com.bank.service;

import com.bank.dto.PassportDto;
import com.bank.model.PassportEntity;

import java.util.List;

/**
 * Сервис {@link PassportEntity} {@link PassportDto}
 */
// TODO удали пустую строку.
public interface PassportService {

    /**
     * @param id технический идентификатор {@link PassportEntity}
     * @return {@link PassportDto}
     */
    PassportDto findById(Long id);

    /**
     * TODO в описание ids добавить ссылку PassportEntity.
     * @param ids лист технических идентификаторов
     * @return {@link List<PassportDto>}
     */
    List<PassportDto> findAllById(List<Long> ids);

    /**
     * TODO переименуй dto в passport.
     * @param dto {@link PassportDto}
     * @return {@link PassportDto}
     */
    // TODO переименуй dto в passport.
    PassportDto save(PassportDto dto);

    // TODO а где Update?
}
