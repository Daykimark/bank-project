package com.bank.service;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.model.AccountDetailsIdEntity;

import java.util.List;

/**
 * Сервис {@link AccountDetailsIdEntity} {@link AccountDetailsIdDto}
 */
// TODO удали пустую строку.
public interface AccountDetailsIdService {

    /**
     * @param id технический идентификатор {@link AccountDetailsIdEntity}
     * @return {@link AccountDetailsIdDto}
     */
    AccountDetailsIdDto findById(Long id);

    /**
     * TODO в описание ids добавить ссылку на AccountDetailsIdDto.
     * @param ids лист технических идентификаторов
     * @return {@link List<AccountDetailsIdDto>}
     */
    List<AccountDetailsIdDto> findAllById(List<Long> ids);

    /**
     * @param dto {@link AccountDetailsIdDto}
     * @return {@link AccountDetailsIdDto}
     */
    // TODO dto переименуй в accountDetailsId.
    AccountDetailsIdDto save(AccountDetailsIdDto dto);
}
