package com.bank.dao;

import com.bank.model.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс который наследуется от JpaRepository для работы с БД для сущности {@link ProfileEntity}*/

public interface ProfileDao extends JpaRepository<ProfileEntity, Long> {

}
