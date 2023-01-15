package com.bank.service;

import com.bank.dto.ActualRegistrationDto;

import java.util.List;

public interface ActualRegistrationService {
    ActualRegistrationDto findById(Long id);

    List<ActualRegistrationDto> findAllById(Iterable<Long> id);

    List<ActualRegistrationDto> findAll();

    ActualRegistrationDto save(ActualRegistrationDto actualRegistrationDto);
}
