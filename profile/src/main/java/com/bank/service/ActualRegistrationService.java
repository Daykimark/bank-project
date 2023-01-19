package com.bank.service;

import com.bank.dto.ActualRegistrationDto;

import java.util.List;

/**
 * Интерфейс-прослойка между сервисным слоем и слоем DAO для сущности {@link com.bank.model.ActualRegistrationEntity}*/
public interface ActualRegistrationService {

    /**
     * Метод ищет одного пользователя по его айди и возвращает его
     * @param id*/
    ActualRegistrationDto findById(Long id);

    /**
     * Метод ищет пользователей у которых айди равен айди из параметра метода
     * @param ids - айди пользователей, которых надо найти*/
    List<ActualRegistrationDto> findAllById(List<Long> ids);

    /**
     * Метод ищет и возвращает всех пользователей*/
    List<ActualRegistrationDto> findAll();

    /**
     * Метод сохраняет сушность, которая подается на вход в виде ДТО, а потом конвертируется
     * {@link com.bank.mapper.ActualRegistrationMapper} в сущность*/
    ActualRegistrationDto save(ActualRegistrationDto actualRegistrationDto);
}
