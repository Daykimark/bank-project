package com.bank.service;

import com.bank.dto.RegistrationDto;
import com.bank.model.RegistrationEntity;

import java.util.List;

/**
 * Сервис {@link RegistrationEntity} {@link RegistrationDto}
 */
// TODO удали пустую строку.
public interface RegistrationService {

    /**
     * @param id технический идентификатор {@link RegistrationEntity}
     * @return {@link RegistrationDto}
     */
    RegistrationDto findById(Long id);

    /**
     * TODO в описание ids добавить ссылку ProfileEntity.
     * @param ids лист технических идентификаторов
     * @return {@link List<RegistrationDto>}
     */
    List<RegistrationDto> findAllById(List<Long> ids);

    /**
     * TODO переименуй dto в registration.
     * @param dto {@link RegistrationDto}
     * @return {@link RegistrationDto}
     */
    // TODO переименуй dto в registration.
    RegistrationDto save(RegistrationDto dto);

    // TODO а где Update?
}
