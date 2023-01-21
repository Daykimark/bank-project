package com.bank.repository;

import com.bank.model.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для {@link RegistrationEntity}
 */
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long> {
}
