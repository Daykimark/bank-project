package com.bank.dao;

import com.bank.model.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuditDao extends JpaRepository<AuditEntity, Long> {

}
