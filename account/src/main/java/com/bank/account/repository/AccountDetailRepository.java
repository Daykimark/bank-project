package com.bank.account.repository;

import com.bank.account.entity.AccountDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для {@link AccountDetailsEntity}
 */
// TODO AccountDetailRepository переименуй в AccountDetailsRepository
public interface AccountDetailRepository extends JpaRepository<AccountDetailsEntity, Long> {
}
