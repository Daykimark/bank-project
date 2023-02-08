package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.BankDetailsDto;
import com.bank.publicinfo.dto.CertificateDto;
import com.bank.publicinfo.entity.BankDetailsEntity;
import com.bank.publicinfo.entity.CertificateEntity;
import com.bank.publicinfo.supplier.MapperSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CertificateMapperTest {

    private CertificateMapper mapper;
    @InjectMocks
    private MapperSupplier supplier;
    private CertificateEntity certificate;
    private CertificateEntity secondCertificate;
    private CertificateDto certificateDto;
    private CertificateDto secondCertificateDto;

    @BeforeEach
    void prepare() {
        mapper = new CertificateMapperImpl();
        supplier = new MapperSupplier();
        certificate = supplier.supplyCertificate(1L, new Byte[]{1, 2, 3, 5},
                new BankDetailsEntity(1L, 1894784L, 31731293L, 732173L,
                        483742, "kursk", "test", "test"));
        secondCertificate = supplier.supplyCertificate(2L, new Byte[]{1, 2, 3, 5},
                new BankDetailsEntity(1L, 894784L, 1731293L, 32173L,
                        483742, "kursk", "test", "test"));
        certificateDto = supplier.supplyCertificateDto(1L, new Byte[]{1, 2, 3, 5},
                new BankDetailsDto(1L, 1894784L, 31731293L, 732173L,
                        483742, "kursk", "test", "test"));
        secondCertificateDto = supplier.supplyCertificateDto(2L, new Byte[]{1, 2, 3, 5},
                new BankDetailsDto(1L, 894784L, 1731293L, 32173L,
                        483742, "kursk", "test", "test"));
    }

    @Test
    @DisplayName("entity to dto")
    public void entityToDtoTest() {
        CertificateDto result = mapper.toDto(certificate);

        assertEquals(result, certificateDto);
    }

    @Test
    @DisplayName("dto to entity")
    public void dtoToEntityTest() {
        CertificateEntity result = mapper.toEntity(certificateDto);

        assertEquals(result, certificate);
    }

    @Test
    @DisplayName("entity list to dto list")
    public void entityListToDtoListTest() {
        List<CertificateEntity> certificateEntityList = List.of(certificate,secondCertificate);
        List<CertificateDto> certificateDtoList = List.of(certificateDto, secondCertificateDto);
        List<CertificateDto> result = mapper.toDtoList(certificateEntityList);

        assertAll(
                () -> {
                    assertNotNull(result);
                    assertIterableEquals(certificateDtoList, result);
                }
        );
    }

    @Test
    @DisplayName("merge to entity")
    public void mergeToEntityTest() {
        CertificateEntity result = mapper.mergeToEntity(certificateDto, certificate);

        assertEquals(result, certificate);
    }
}
