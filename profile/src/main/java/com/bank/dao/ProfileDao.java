package com.bank.dao;

import com.bank.model.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDao extends JpaRepository<ProfileEntity, Long> {

}