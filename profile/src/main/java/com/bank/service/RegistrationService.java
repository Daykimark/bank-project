package com.bank.service;

import com.bank.dto.RegistrationDto;

import java.util.List;


/**
 * Интерфейс-прослойка между сервисным слоем и слоем DAO для сущности {@link com.bank.model.RegistrationEntity}*/
public interface RegistrationService {

    /**
     * Метод ищет одного пользователя по его айди и возвращает его
     * @param id*/
    RegistrationDto findById(Long id);

    /**
     * Метод ищет пользователей у которых айди равен айди из параметра метода
     * @param ids - айди пользователей, которых надо найти*/
    List<RegistrationDto> findAllById(List<Long> ids);

    /**
     * Метод ищет и возвращает всех пользователей*/
    List<RegistrationDto> findAll();

    /**
     * Метод сохраняет сушность, которая подается на вход в виде ДТО, а потом конвертируется
     * {@link com.bank.mapper.RegistrationMapper} в сущность*/
    RegistrationDto save(RegistrationDto registrationDto);
}
