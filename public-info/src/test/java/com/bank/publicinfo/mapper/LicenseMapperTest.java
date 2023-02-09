package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.BankDetailsDto;
import com.bank.publicinfo.dto.LicenseDto;
import com.bank.publicinfo.entity.BankDetailsEntity;
import com.bank.publicinfo.entity.LicenseEntity;
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

public class LicenseMapperTest {

    private LicenseMapper mapper;
    @InjectMocks
    private MapperSupplier supplier;
    private LicenseEntity license;
    private LicenseEntity secondLicense;
    private LicenseDto licenseDto;
    private LicenseDto secondLicenseDto;

    @BeforeEach
    void prepare() {
        mapper = new LicenseMapperImpl();
        supplier = new MapperSupplier();
        license = supplier.supplyLicense(1L, new Byte[]{1, 2, 3, 5},
                new BankDetailsEntity(1L, 1894784L, 31731293L, 732173L,
                        483742, "kursk", "test", "test"));
        secondLicense = supplier.supplyLicense(2L, new Byte[]{1, 2, 3, 5},
                new BankDetailsEntity(2L, 894784L, 1731293L, 32173L,
                        483742, "kursk", "test", "test"));
        licenseDto = supplier.supplyLicenseDto(1L, new Byte[]{1, 2, 3, 5},
                new BankDetailsDto(1L, 1894784L, 31731293L, 732173L,
                        483742, "kursk", "test", "test"));
        secondLicenseDto = supplier.supplyLicenseDto(2L, new Byte[]{1, 2, 3, 5},
                new BankDetailsDto(2L, 894784L, 1731293L, 32173L,
                        483742, "kursk", "test", "test"));
    }

    @Test
    @DisplayName("entity to dto")
    public void entityToDtoTest() {
        LicenseDto result = mapper.toDto(license);

        assertEquals(result, licenseDto);
    }

    @Test
    @DisplayName("dto to entity")
    public void dtoToEntityTest() {
        LicenseEntity result = mapper.toEntity(licenseDto);

        assertEquals(result, license);
    }

    @Test
    @DisplayName("entity list to dto list")
    public void entityListToDtoListTest() {
        List<LicenseEntity> licenseEntityList = List.of(license, secondLicense);
        List<LicenseDto> licenseDtoList = List.of(licenseDto, secondLicenseDto);
        List<LicenseDto> result = mapper.toDtoList(licenseEntityList);

        assertAll(
                () -> {
                    assertNotNull(result);
                    assertIterableEquals(licenseDtoList, result);
                }
        );
    }

    @Test
    @DisplayName("merge to entity")
    public void mergeToEntityTest() {
        LicenseEntity result = mapper.mergeToEntity(licenseDto, license);

        assertEquals(result, license);
    }
}
