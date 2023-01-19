package com.bank.dao;

import com.bank.model.AccountDetailsIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс который наследуется от JpaRepository для работы с БД для сущности {@link AccountDetailsIdEntity}*/

public interface AccountDetailsIdDao extends JpaRepository<AccountDetailsIdEntity, Long> {

}
