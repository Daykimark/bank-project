package com.bank.service;

import com.bank.dto.RegistrationDto;

import java.util.List;

public interface RegistrationService {
    RegistrationDto findById(Long id);

    List<RegistrationDto> findAllById(Iterable<Long> id);

    List<RegistrationDto> findAll();

    RegistrationDto save(RegistrationDto registrationDto);
}
