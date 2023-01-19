package com.bank.dao;

import com.bank.model.PassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс который наследуется от JpaRepository для работы с БД для сущности {@link PassportEntity}*/

public interface PassportDao extends JpaRepository<PassportEntity, Long> {

}
