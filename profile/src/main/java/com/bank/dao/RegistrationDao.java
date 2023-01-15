package com.bank.dao;

import com.bank.model.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationDao extends JpaRepository<RegistrationEntity, Long> {

}