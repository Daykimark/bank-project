package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.AtmDto;
import com.bank.publicinfo.dto.BranchDto;
import com.bank.publicinfo.entity.AtmEntity;
import com.bank.publicinfo.entity.BranchEntity;
import com.bank.publicinfo.mapper.AtmMapperImpl;
import com.bank.publicinfo.repository.AtmRepository;
import com.bank.publicinfo.service.impl.AtmServiceImpl;
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

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AtmServiceTest {

    @Mock
    private AtmRepository repository;
    @InjectMocks
    private AtmServiceImpl service;
    @Spy
    private AtmMapperImpl mapper;
    @Spy
    private EntityNotFoundSupplier supplierNotFound;
    @InjectMocks
    private ServiceSupplier supplier;
    private AtmEntity atm;
    private AtmEntity secondAtm;
    private AtmDto atmDto;

    @BeforeEach
    void prepare() {
        atm = supplier.supplyAtm(1L, "test", LocalTime.of(12, 0, 0),
                LocalTime.of(14, 0, 0), true, new BranchEntity(
                        1L, "address", 8909445113L, "city",
                        LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0)));
        secondAtm = supplier.supplyAtm(2L, "test", LocalTime.of(12, 0, 0),
                LocalTime.of(14, 0, 0), true, new BranchEntity(
                        2L, "address", 909445113L, "city",
                        LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0)));
        atmDto = supplier.supplyAtmDto(1L, "test", LocalTime.of(12, 0, 0),
                LocalTime.of(14, 0, 0), true, new BranchDto(
                        1L, "address", 8909445113L, "city",
                        LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0)));
    }

    @Test
    @DisplayName("create")
    public void createTest() {
        doReturn(atm).when(repository).save(any(AtmEntity.class));

        AtmDto result = service.create(atmDto);

        assertEquals(result, atmDto);
    }

    @Test
    @DisplayName("update")
    public void updateTest() {
        atm.setAddress("new");
        service.create(mapper.toDto(atm));

        doReturn(Optional.of(atm)).when(repository).findById(any(Long.class));

        AtmDto result = service.update(1L, mapper.toDto(atm));

        assertEquals(result, mapper.toDto(atm));
    }

    @Test
    @DisplayName("read by id")
    public void readByIdTest() {
        doReturn(Optional.of(atm)).when(repository).findById(any(Long.class));

        AtmDto result = service.findById(atm.getId());

        assertEquals(1L, result.getId());
    }

    @Test
    @DisplayName("read all by id")
    public void readAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<AtmDto> atms = List.of(mapper.toDto(atm), mapper.toDto(secondAtm));

        when(repository.findAllById(any())).thenReturn(List.of(atm, secondAtm));

        assertThat(service.findAllById(ids)).isEqualTo(atms);
    }
}

