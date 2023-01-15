package com.bank.dao;

import com.bank.model.ActualRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс который наследуется от JpaRepository для работы с БД для сущности {@link ActualRegistrationEntity}*/

public interface ActualRegistrationDao extends JpaRepository<ActualRegistrationEntity, Long> {

}
