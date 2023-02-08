package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.BankDetailsDto;
import com.bank.publicinfo.dto.CertificateDto;
import com.bank.publicinfo.entity.BankDetailsEntity;
import com.bank.publicinfo.entity.CertificateEntity;
import com.bank.publicinfo.mapper.CertificateMapperImpl;
import com.bank.publicinfo.repository.CertificateRepository;
import com.bank.publicinfo.service.impl.CertificateServiceImpl;
import com.bank.publicinfo.supplier.ServiceSupplier;
import com.bank.publicinfo.util.EntityNotFoundSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CertificateServiceTest {

    @Mock
    private CertificateRepository repository;
    @InjectMocks
    private CertificateServiceImpl service;
    @Spy
    private CertificateMapperImpl mapper;
    @Spy
    private EntityNotFoundSupplier supplierNotFound;
    @InjectMocks
    private ServiceSupplier supplier;
    private CertificateEntity certificate;
    private CertificateEntity secondCertificate;
    private CertificateDto certificateDto;

    @BeforeEach
    void prepare() {
        certificate = supplier.supplyCertificate(1L, new Byte[]{1, 2, 3, 5},
                new BankDetailsEntity(1L, 1894784L, 31731293L, 732173L,
                        483742, "kursk", "test", "test"));
        secondCertificate = supplier.supplyCertificate(2L, new Byte[]{1, 2, 3, 5},
                new BankDetailsEntity(1L, 894784L, 1731293L, 32173L,
                        483742, "kursk", "test", "test"));
        certificateDto = supplier.supplyCertificateDto(1L, new Byte[]{1, 2, 3, 5},
                new BankDetailsDto(1L, 1894784L, 31731293L, 732173L,
                        483742, "kursk", "test", "test"));
    }

    @Test
    @DisplayName("create")
    public void createTest() {
        doReturn(certificate).when(repository).save(any(CertificateEntity.class));

        CertificateDto result = service.create(certificateDto);

        assertEquals(result, certificateDto);
    }

    @Test
    @DisplayName("update")
    public void updateTest() {
        certificate.setPhotoCertificate(new Byte[]{1, 1, 1});
        service.create(mapper.toDto(certificate));

        doReturn(Optional.of(certificate)).when(repository).findById(any(Long.class));

        CertificateDto result = service.update(1L, mapper.toDto(certificate));

        assertEquals(result, mapper.toDto(certificate));
    }

    @Test
    @DisplayName("read by id")
    public void readByIdTest() {
        doReturn(Optional.of(certificate)).when(repository).findById(any(Long.class));

        CertificateDto result = service.findById(certificate.getId());

        assertEquals(1L, result.getId());
    }

    @Test
    @DisplayName("read all by id")
    public void readAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<CertificateDto> certificates = List.of(mapper.toDto(certificate), mapper.toDto(secondCertificate));

        when(repository.findAllById(any())).thenReturn(List.of(certificate, secondCertificate));

        assertThat(service.findAllById(ids)).isEqualTo(certificates);
    }
}
