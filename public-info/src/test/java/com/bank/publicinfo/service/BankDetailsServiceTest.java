package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.BankDetailsDto;
import com.bank.publicinfo.entity.BankDetailsEntity;
import com.bank.publicinfo.mapper.BankDetailsMapperImpl;
import com.bank.publicinfo.repository.BankDetailsRepository;
import com.bank.publicinfo.service.impl.BankDetailsServiceImpl;
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
public class BankDetailsServiceTest {

    @Mock
    private BankDetailsRepository repository;
    @InjectMocks
    private BankDetailsServiceImpl service;
    @Spy
    private BankDetailsMapperImpl mapper;
    @Spy
    private EntityNotFoundSupplier supplierNotFound;
    @InjectMocks
    private ServiceSupplier supplier;
    private BankDetailsEntity bankDetails;
    private BankDetailsEntity secondDetails;
    private BankDetailsDto bankDetailsDto;

    @BeforeEach
    void prepare() {
        bankDetails = supplier.supplyBankDetails(1L, 13691237L,
                1371280312L, 18203718L, 182371283, "test", "test", "test");
        secondDetails = supplier.supplyBankDetails(2L, 1391237L,
                137128312L, 1823718L, 18271283, "test", "test", "test");
        bankDetailsDto = supplier.supplyBankDetailsDto(1L, 13691237L, 1371280312L,
                18203718L, 182371283, "test", "test", "test");
    }

    @Test
    @DisplayName("create")
    public void createTest() {
        doReturn(bankDetails).when(repository).save(any(BankDetailsEntity.class));

        BankDetailsDto result = service.create(bankDetailsDto);

        assertEquals(result, bankDetailsDto);
    }

    @Test
    @DisplayName("update")
    public void updateTest() {
        bankDetails.setCity("city");
        service.create(mapper.toDto(bankDetails));

        doReturn(Optional.of(bankDetails)).when(repository).findById(any(Long.class));

        BankDetailsDto result = service.update(1L, mapper.toDto(bankDetails));

        assertEquals(result, mapper.toDto(bankDetails));
    }

    @Test
    @DisplayName("read by id")
    public void readByIdTest() {
        doReturn(Optional.of(bankDetails)).when(repository).findById(any(Long.class));

        BankDetailsDto result = service.findById(bankDetails.getId());

        assertEquals(1L, result.getId());
    }

    @Test
    @DisplayName("read all by id")
    public void readAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<BankDetailsDto> details = List.of(mapper.toDto(bankDetails), mapper.toDto(secondDetails));

        when(repository.findAllById(any())).thenReturn(List.of(bankDetails, secondDetails));

        assertThat(service.findAllById(ids)).isEqualTo(details);
    }
}
