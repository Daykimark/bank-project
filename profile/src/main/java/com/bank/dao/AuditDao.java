package com.bank.dao;

import com.bank.model.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс который наследуется от JpaRepository для работы с БД для сущности {@link AuditEntity}*/

public interface AuditDao extends JpaRepository<AuditEntity, Long> {

}
