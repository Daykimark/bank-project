package com.bank.dao;

import com.bank.model.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс который наследуется от JpaRepository для работы с БД для сущности {@link RegistrationEntity}*/

public interface RegistrationDao extends JpaRepository<RegistrationEntity, Long> {

}
