package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.BankDetailsDto;
import com.bank.publicinfo.entity.BankDetailsEntity;
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

public class BankDetailsMapperTest {

    private BankDetailsMapper mapper;
    @InjectMocks
    private MapperSupplier supplier;
    private BankDetailsEntity bankDetails;
    private BankDetailsEntity secondBankDetails;
    private BankDetailsDto bankDetailsDto;
    private BankDetailsDto secondBankDetailsDto;


    @BeforeEach
    void prepare() {
        mapper = new BankDetailsMapperImpl();
        supplier = new MapperSupplier();
        bankDetails = supplier.supplyBankDetails(1L, 13691237L,
                1371280312L, 18203718L, 182371283, "test", "test", "test");
        secondBankDetails = supplier.supplyBankDetails(2L, 1391237L,
                137128312L, 1823718L, 18271283, "test", "test", "test");
        bankDetailsDto = supplier.supplyBankDetailsDto(1L, 13691237L, 1371280312L,
                18203718L, 182371283, "test", "test", "test");
        secondBankDetailsDto = supplier.supplyBankDetailsDto(2L, 1391237L,
                137128312L, 1823718L, 18271283, "test", "test", "test");
    }

    @Test
    @DisplayName("entity to dto")
    public void entityToDtoTest() {
        BankDetailsDto result = mapper.toDto(bankDetails);

        assertEquals(result, bankDetailsDto);
    }

    @Test
    @DisplayName("dto to entity")
    public void dtoToEntityTest() {
        BankDetailsEntity result = mapper.toEntity(bankDetailsDto);

        assertEquals(result, bankDetails);
    }

    @Test
    @DisplayName("entity list to dto list")
    public void entityListToDtoListTest() {
        List<BankDetailsEntity> bankDetailsEntityList = List.of(bankDetails, secondBankDetails);
        List<BankDetailsDto> dto = List.of(bankDetailsDto, secondBankDetailsDto);
        List<BankDetailsDto> result = mapper.toDtoList(bankDetailsEntityList);

        assertAll(
                () -> {
                    assertNotNull(result);
                    assertIterableEquals(dto, result);
                }
        );
    }

    @Test
    @DisplayName("merge to entity")
    public void mergeToEntityTest() {
        BankDetailsEntity result = mapper.mergeToEntity(bankDetailsDto, bankDetails);

        assertEquals(result, bankDetails);
    }
}
