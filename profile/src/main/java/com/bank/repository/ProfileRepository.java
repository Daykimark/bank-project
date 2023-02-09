package com.bank.repository;

import com.bank.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для {@link ProfileEntity}
 */
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
}
