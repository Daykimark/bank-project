package com.bank.service;

import com.bank.dto.RegistrationDto;
import com.bank.model.RegistrationEntity;

import java.util.List;

/**
 * Сервис {@link RegistrationEntity} {@link RegistrationDto}
 */

public interface RegistrationService {

    /**
     * @param id технический идентификатор {@link RegistrationEntity}
     * @return {@link RegistrationDto}
     */
    RegistrationDto findById(Long id);

    /**
     * @param ids лист технических идентификаторов
     * @return {@link List<RegistrationDto>}
     */
    List<RegistrationDto> findAllById(List<Long> ids);

    /**
     * @param dto {@link RegistrationDto}
     * @return {@link RegistrationDto}
     */
    RegistrationDto save(RegistrationDto dto);
}
