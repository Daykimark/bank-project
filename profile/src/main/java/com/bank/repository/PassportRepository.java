package com.bank.repository;

import com.bank.entity.PassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для {@link PassportEntity}
 */
public interface PassportRepository extends JpaRepository<PassportEntity, Long> {
}
