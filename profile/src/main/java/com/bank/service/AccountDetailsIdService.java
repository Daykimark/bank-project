package com.bank.service;

import com.bank.dto.AccountDetailsIdDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountDetailsIdService {

    AccountDetailsIdDto findById(Long id);

    List<AccountDetailsIdDto> findAllById(List<Long> ids);

    List<AccountDetailsIdDto> findAll();

    AccountDetailsIdDto save(AccountDetailsIdDto accountDetailsIdDto);
}
