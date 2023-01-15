package com.bank.dao;

import com.bank.model.PassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportDao extends JpaRepository<PassportEntity, Long> {

}