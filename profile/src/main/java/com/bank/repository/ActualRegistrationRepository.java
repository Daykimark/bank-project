package com.bank.repository;

import com.bank.model.ActualRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для {@link ActualRegistrationEntity}
 */
public interface ActualRegistrationRepository extends JpaRepository<ActualRegistrationEntity, Long> {
}
