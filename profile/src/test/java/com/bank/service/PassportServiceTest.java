package com.bank.service;

import com.bank.AbstractTest;
import com.bank.dto.PassportDto;
import com.bank.entity.PassportEntity;
import com.bank.mapper.PassportMapperImpl;
import com.bank.repository.PassportRepository;
import com.bank.service.impl.PassportServiceImpl;
import com.bank.supplier.ServiceTestSupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PassportServiceTest extends AbstractTest {

    @Mock
    private PassportRepository rep;

    @Spy
    private PassportMapperImpl mapper;

    @InjectMocks
    private PassportServiceImpl service;

    private static PassportEntity passport1;

    private static PassportEntity passport2;

    @BeforeAll
    static void setUp() {
        passport1 = new PassportEntity();
        passport2 = new PassportEntity();
        ServiceTestSupplier supplier = new ServiceTestSupplier();

        supplier.setUpPassportService(passport1, passport2);
    }

    @Test
    @DisplayName("Создание объекта")
    void saveTest() {
        PassportDto passportDto = mapper.toDto(passport2);
        when(rep.save(any(PassportEntity.class))).thenReturn(passport2);
        assertThat(service.save(passportDto)).isEqualTo(passportDto);
    }

    @Test
    @DisplayName("Поиск по списку айди")
    void findAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<PassportDto> listOfDto = List.of(mapper.toDto(passport1), mapper.toDto(passport2));
        when(rep.findAllById(any())).thenReturn(List.of(passport1, passport2));
        assertThat(service.findAllById(ids)).isEqualTo(listOfDto);
    }

    @Test
    @DisplayName("Поиск по списку айди должен кинуть исключение если один из пользователей не найден")
    void findAllByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        when(rep.findAllById(any())).thenReturn(List.of(passport1, passport2));
        assertThrows(EntityNotFoundException.class, () -> service.findAllById(ids));
    }

    @Test
    @DisplayName("Поиск по одному айди")
    void findById() {
        when(rep.findById(2L)).thenReturn(Optional.of(passport2));
        assertThat(service.findById(2L)).isEqualTo(mapper.toDto(passport2));
    }

    @Test
    @DisplayName("Поиск по одному айди должен кинуть исключение если айди не найден")
    void getByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        when(rep.findById(3L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> service.findById(3L));
    }

    @Test
    @DisplayName("Обновление должно кинуть исключение если обновляемой сущности не существует")
    void updateShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        when(rep.findById(3L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> service.update(3L, mapper.toDto(passport1)));
    }
}
