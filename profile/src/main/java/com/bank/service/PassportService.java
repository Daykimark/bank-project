package com.bank.service;

import com.bank.dto.PassportDto;

import java.util.List;

/**
 * Интерфейс-прослойка между сервисным слоем и слоем DAO для сущности {@link com.bank.model.PassportEntity}*/
public interface PassportService {

    /**
     * Метод ищет одного пользователя по его айди и возвращает его
     * @param id*/
    PassportDto findById(Long id);

    /**
     * Метод ищет пользователей у которых айди равен айди из параметра метода
     * @param ids - айди пользователей, которых надо найти*/
    List<PassportDto> findAllById(List<Long> ids);

    /**
     * Метод ищет и возвращает всех пользователей*/
    List<PassportDto> findAll();

    /**
     * Метод сохраняет сушность, которая подается на вход в виде ДТО, а потом конвертируется
     * {@link com.bank.mapper.PassportMapper} в сущность*/
    PassportDto save(PassportDto passportDto);
}
