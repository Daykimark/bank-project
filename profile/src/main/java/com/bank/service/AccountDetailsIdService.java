package com.bank.service;

import com.bank.dto.AccountDetailsIdDto;

import java.util.List;

/**
 * Интерфейс-прослойка между сервисным слоем и слоем DAO для сущности {@link com.bank.model.AccountDetailsIdEntity}*/

public interface AccountDetailsIdService {

    /**
     * Метод ищет одного пользователя по его айди и возвращает его
     * @param id*/
    AccountDetailsIdDto findById(Long id);

    /**
     * Метод ищет пользователей у которых айди равен айди из параметра метода
     * @param ids - айди пользователей, которых надо найти*/
    List<AccountDetailsIdDto> findAllById(List<Long> ids);

    /**
     * Метод ищет и возвращает всех пользователей*/
    List<AccountDetailsIdDto> findAll();

    /**
     * Метод сохраняет сушность, которая подается на вход в виде ДТО, а потом конвертируется
     * {@link com.bank.mapper.AccountDetailsIdMapper} в сущность*/
    AccountDetailsIdDto save(AccountDetailsIdDto accountDetailsIdDto);
}
