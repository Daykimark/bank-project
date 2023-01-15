package com.bank.service;

import com.bank.dto.AuditDto;

import java.util.List;

public interface AuditService {
    AuditDto findById(Long id);

    List<AuditDto> findAllById(Iterable<Long> id);

    List<AuditDto> findAll();

    AuditDto save(AuditDto auditDto);
}
