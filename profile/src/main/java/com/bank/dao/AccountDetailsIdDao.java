package com.bank.dao;

import com.bank.model.AccountDetailsIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDetailsIdDao extends JpaRepository<AccountDetailsIdEntity, Long> {

}
