package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.BankDetailsDto;
import com.bank.publicinfo.dto.LicenseDto;
import com.bank.publicinfo.entity.BankDetailsEntity;
import com.bank.publicinfo.entity.LicenseEntity;
import com.bank.publicinfo.mapper.LicenseMapperImpl;
import com.bank.publicinfo.repository.LicenseRepository;
import com.bank.publicinfo.service.impl.LicenseServiceImpl;
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
public class LicenseServiceTest {

    @Mock
    private LicenseRepository repository;
    @InjectMocks
    private LicenseServiceImpl service;
    @Spy
    private LicenseMapperImpl mapper;
    @Spy
    private EntityNotFoundSupplier supplierNotFound;
    @InjectMocks
    private ServiceSupplier supplier;
    private LicenseEntity license;
    private LicenseEntity secondLicense;
    private LicenseDto licenseDto;

    @BeforeEach
    void prepare() {
        license = supplier.supplyLicense(1L, new Byte[]{1, 2, 3, 5},
                new BankDetailsEntity(1L, 1894784L, 31731293L, 732173L,
                        483742, "kursk", "test", "test"));
        secondLicense = supplier.supplyLicense(2L, new Byte[]{1, 2, 3, 5},
                new BankDetailsEntity(2L, 894784L, 1731293L, 32173L,
                        483742, "kursk", "test", "test"));
        licenseDto = supplier.supplyLicenseDto(1L, new Byte[]{1, 2, 3, 5},
                new BankDetailsDto(1L, 1894784L, 31731293L, 732173L,
                        483742, "kursk", "test", "test"));
    }

    @Test
    @DisplayName("create")
    public void createTest() {
        doReturn(license).when(repository).save(any(LicenseEntity.class));

        LicenseDto result = service.create(licenseDto);

        assertEquals(result, licenseDto);
    }

    @Test
    @DisplayName("update")
    public void updateTest() {
        license.setPhotoLicense(new Byte[]{1,1,1});
        service.create(mapper.toDto(license));

        doReturn(Optional.of(license)).when(repository).findById(any(Long.class));

        LicenseDto result = service.update(1L, mapper.toDto(license));

        assertEquals(result, mapper.toDto(license));
    }

    @Test
    @DisplayName("read by id")
    public void readByIdTest() {
        doReturn(Optional.of(license)).when(repository).findById(any(Long.class));

        LicenseDto result = service.findById(license.getId());

        assertEquals(1L, result.getId());
    }

    @Test
    @DisplayName("read all by id")
    public void readAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<LicenseDto> licenses = List.of(mapper.toDto(license), mapper.toDto(secondLicense));

        when(repository.findAllById(any())).thenReturn(List.of(license, secondLicense));

        assertThat(service.findAllById(ids)).isEqualTo(licenses);
    }
}
