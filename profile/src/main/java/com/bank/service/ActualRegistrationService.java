package com.bank.service;

import com.bank.dto.ActualRegistrationDto;
import com.bank.model.ActualRegistrationEntity;

import java.util.List;

/**
 * Сервис {@link ActualRegistrationEntity} {@link ActualRegistrationDto}
 */
// TODO удали пустую строку.
public interface ActualRegistrationService {

    /**
     * @param id технический идентификатор {@link ActualRegistrationEntity}
     * @return {@link ActualRegistrationDto}
     */
    ActualRegistrationDto findById(Long id);

    /**
     * TODO в описание ids добавь ссылку на ActualRegistrationEntity.
     * @param ids лист технических идентификаторов
     * @return {@link List<ActualRegistrationDto>}
     */
    List<ActualRegistrationDto> findAllById(List<Long> ids);

    /**
     * @param dto {@link ActualRegistrationDto}
     * @return {@link ActualRegistrationDto}
     */
    // TODO dto переименуй в actualRegistration.
    ActualRegistrationDto save(ActualRegistrationDto dto);

    // TODO все таки save и update должны быть разными методами, можно логику переиспользовать но в сервисах метод update добавь.
}
