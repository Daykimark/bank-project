package com.bank.service;

import com.bank.dto.AuditDto;
import com.bank.model.AuditEntity;

import java.util.List;

/**
 * Сервис {@link AuditEntity} {@link AuditDto}
 */

public interface AuditService {

    /**
     * @param id технический идентификатор {@link AuditEntity}
     * @return {@link AuditDto}
     */
    AuditDto findById(Long id);

    /**
     * @param ids лист технических идентификаторов
     * @return {@link List<AuditDto>}
     */
    List<AuditDto> findAllById(List<Long> ids);

    /**
     * @param dto {@link AuditDto}
     * @return {@link AuditDto}
     */
    AuditDto save(AuditDto dto);
}
