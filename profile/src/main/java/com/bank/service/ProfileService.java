package com.bank.service;

import com.bank.dto.ProfileDto;

import java.util.List;

/**
 * Интерфейс-прослойка между сервисным слоем и слоем DAO для сущности {@link com.bank.model.ProfileEntity}*/
public interface ProfileService {

    /**
     * Метод ищет одного пользователя по его айди и возвращает его
     * @param id*/
    ProfileDto findById(Long id);

    /**
     * Метод ищет пользователей у которых айди равен айди из параметра метода
     * @param ids - айди пользователей, которых надо найти*/
    List<ProfileDto> findAllById(List<Long> ids);

    /**
     * Метод ищет и возвращает всех пользователей*/
    List<ProfileDto> findAll();

    /**
     * Метод сохраняет сушность, которая подается на вход в виде ДТО, а потом конвертируется
     * {@link com.bank.mapper.ProfileMapper} в сущность*/
    ProfileDto save(ProfileDto profileDto);
}
