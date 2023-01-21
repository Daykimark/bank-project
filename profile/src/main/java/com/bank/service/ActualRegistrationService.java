package com.bank.service;

import com.bank.dto.ActualRegistrationDto;
import com.bank.model.ActualRegistrationEntity;

import java.util.List;

/**
 * Сервис {@link ActualRegistrationEntity} {@link ActualRegistrationDto}
 */

public interface ActualRegistrationService {

    /**
     * @param id технический идентификатор {@link ActualRegistrationEntity}
     * @return {@link ActualRegistrationDto}
     */
    ActualRegistrationDto findById(Long id);

    /**
     * @param ids лист технических идентификаторов
     * @return {@link List<ActualRegistrationDto>}
     */
    List<ActualRegistrationDto> findAllById(List<Long> ids);

    /**
     * @param dto {@link ActualRegistrationDto}
     * @return {@link ActualRegistrationDto}
     */
    ActualRegistrationDto save(ActualRegistrationDto dto);
}
