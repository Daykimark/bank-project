package com.bank.service;

import com.bank.dto.AuditDto;

import java.util.List;

/**
 * Интерфейс-прослойка между сервисным слоем и слоем DAO для сущности {@link com.bank.model.AuditEntity}*/
public interface AuditService {

    /**
     * Метод ищет одного пользователя по его айди и возвращает его
     * @param id*/
    AuditDto findById(Long id);

    /**
     * Метод ищет пользователей у которых айди равен айди из параметра метода
     * @param ids - айди пользователей, которых надо найти*/
    List<AuditDto> findAllById(Iterable<Long> ids);

    /**
     * Метод ищет и возвращает всех пользователей*/
    List<AuditDto> findAll();

    /**
     * Метод сохраняет сушность, которая подается на вход в виде ДТО, а потом конвертируется
     * {@link com.bank.mapper.AuditMapper} в сущность*/
    AuditDto save(AuditDto auditDto);
}
