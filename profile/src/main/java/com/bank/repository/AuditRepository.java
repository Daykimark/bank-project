package com.bank.repository;

import com.bank.model.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO удали, так как AuditRepository не используется.
/**
 * Репозиторий для {@link AuditEntity}
 */
public interface AuditRepository extends JpaRepository<AuditEntity, Long> {
}
