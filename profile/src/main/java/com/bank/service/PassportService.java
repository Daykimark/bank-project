package com.bank.service;

import com.bank.dto.PassportDto;

import java.util.List;

public interface PassportService {
    PassportDto findById(Long id);

    List<PassportDto> findAllById(Iterable<Long> id);

    List<PassportDto> findAll();

    PassportDto save(PassportDto passportDto);
}
