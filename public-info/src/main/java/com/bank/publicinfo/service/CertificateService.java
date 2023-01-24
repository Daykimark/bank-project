package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.CertificateDto;
import com.bank.publicinfo.entity.CertificateEntity;

import java.util.List;

/**
 * Сервис для {@link CertificateEntity} и {@link CertificateDto}
 */
public interface CertificateService {

    /**
     * TODO @param ids технические идентификаторы и ссылку на entity.
     * @param ids технический идентификатор
     * @return лист {@link CertificateDto}
     */
    List<CertificateDto> findAllById(List<Long> ids);

    /**
     * @param certificate {@link CertificateDto}
     * @return {@link CertificateDto}
     */
    CertificateDto create(CertificateDto certificate);

    /**
     * TODO @param id технический идентификатор и ссылку на entity.
     * @param id технический идентификатор
     * @param certificate {@link CertificateDto}
     * @return {@link CertificateDto}
     */
    CertificateDto update(Long id, CertificateDto certificate);

    /**
     * TODO @param id технический идентификатор и ссылку на entity.
     * @param id технический идентификатор
     * @return {@link CertificateDto}
     */
    CertificateDto findById(Long id);
}
