package com.bank.repository;

import com.bank.model.AccountDetailsIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для {@link AccountDetailsIdEntity}
 */
public interface AccountDetailsIdRepository extends JpaRepository<AccountDetailsIdEntity, Long> {
}
