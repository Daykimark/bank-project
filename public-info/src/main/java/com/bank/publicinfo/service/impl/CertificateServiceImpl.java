package com.bank.publicinfo.service.impl;

import com.bank.publicinfo.dto.CertificateDto;
import com.bank.publicinfo.entity.CertificateEntity;
import com.bank.publicinfo.mapper.CertificateMapper;
import com.bank.publicinfo.repository.CertificateRepository;
import com.bank.publicinfo.service.CertificateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация {@link CertificateService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository repository;
    private final CertificateMapper mapper;

    /**
     * @param ids список технических идентификаторов {@link CertificateEntity}
     * @return лист {@link CertificateDto}
     */
    @Override
    public List<CertificateDto> findAllById(List<Long> ids) {
        final List<CertificateEntity> certificates = repository.findAllById(ids);

        if (certificates.size() < ids.size()) {
            final var entityNotFound = new EntityNotFoundException("Сертификатов с id= " + ids + "не существует");
            log.error(entityNotFound.getMessage(), entityNotFound);
            throw entityNotFound;
        }

        return mapper.toDtoList(certificates);
    }

    /**
     * @param certificateDto {@link CertificateDto}
     * @return {@link CertificateDto}
     */
    @Override
    @Transactional
    public CertificateDto create(CertificateDto certificateDto) {
        final CertificateEntity certificate = repository.save(mapper.toEntity(certificateDto));
        return mapper.toDto(certificate);
    }

    /**
     * @param certificate {@link CertificateDto}
     * TODO удали "измененный ".
     * @return измененный {@link CertificateDto}
     */
    @Override
    @Transactional
    public CertificateDto update(Long id, CertificateDto certificate) {
        final CertificateEntity entity = repository.findById(id)
                .orElseThrow(() -> {
                    log.error("Переданный id не найден!");
                    return new EntityNotFoundException("Данного id не существует!");
                });
        // TODO удали и оставь пустую строку.
        final CertificateEntity updatedCertificate = mapper.mergeToEntity(certificate, entity);
        return mapper.toDto(updatedCertificate);
    }

    /**
     * TODO удали "сертификата" и добавь ссылку на entity.
     * @param id технический идентификатор сертификата
     * @return {@link CertificateDto}
     */
    @Override
    public CertificateDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Сертификат с id = " + id + " не найден")));
    }
}
