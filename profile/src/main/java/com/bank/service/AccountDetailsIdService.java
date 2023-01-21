package com.bank.service;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.model.AccountDetailsIdEntity;

import java.util.List;

/**
 * Сервис {@link AccountDetailsIdEntity} {@link AccountDetailsIdDto}
 */

public interface AccountDetailsIdService {

    /**
     * @param id технический идентификатор {@link AccountDetailsIdEntity}
     * @return {@link AccountDetailsIdDto}
     */
    AccountDetailsIdDto findById(Long id);

    /**
     * @param ids лист технических идентификаторов
     * @return {@link List<AccountDetailsIdDto>}
     */
    List<AccountDetailsIdDto> findAllById(List<Long> ids);

    /**
     * @param dto {@link AccountDetailsIdDto}
     * @return {@link AccountDetailsIdDto}
     */
    AccountDetailsIdDto save(AccountDetailsIdDto dto);
}
