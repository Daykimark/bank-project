package com.bank.service;

import com.bank.AbstractTest;
import com.bank.dto.PassportDto;
import com.bank.entity.PassportEntity;
import com.bank.mapper.PassportMapperImpl;
import com.bank.repository.PassportRepository;
import com.bank.service.impl.PassportServiceImpl;
import com.bank.supplier.EntitySupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

public class PassportServiceTest extends AbstractTest {

    @Mock
    private PassportRepository repository;

    @Spy
    private PassportMapperImpl mapper;

    @InjectMocks
    private PassportServiceImpl service;

    private static PassportEntity passport1;

    private static PassportEntity passport2;

    @BeforeAll
    static void setUp() {
        EntitySupplier supplier = new EntitySupplier();

        passport1 = supplier.getPassport(1L, 12, 37882L, "lol", "john",
                "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                LocalDate.MIN, 72, LocalDate.MIN, supplier.getRegistration(1L,
                        "Russia", "Mos", "Moso", "Some", "Soe",
                        "OOO", "28838", "dhh", "2888", 28L));

        passport2 = supplier.getPassport(2L, 12, 37882L, "lol", "john",
                "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                LocalDate.MIN, 72, LocalDate.MIN, supplier.getRegistration(2L,
                        "Russia", "Mos", "Moso", "Some", "Soe",
                        "OOO", "28838", "dhh", "2888", 28L));
    }

    @Test
    @DisplayName("Создание объекта")
    void saveTest() {
        doReturn(passport2).when(repository).save(any(PassportEntity.class));

        PassportDto passportDto = mapper.toDto(passport2);

        assertEquals(service.save(passportDto), passportDto);
    }

    @Test
    @DisplayName("Поиск по списку айди")
    void findAllByIdTest() {
        doReturn(List.of(passport1, passport2)).when(repository).findAllById(any());

        List<Long> ids = List.of(1L, 2L);
        List<PassportDto> passports = List.of(mapper.toDto(passport1),
                mapper.toDto(passport2));

        assertEquals(service.findAllById(ids), passports);
    }

    @Test
    @DisplayName("Поиск по списку айди должен кинуть исключение если один из пользователей не найден")
    void findAllByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        doReturn(List.of(passport1, passport2)).when(repository).findAllById(any());

        List<Long> ids = List.of(1L, 2L, 3L);

        assertThrows(EntityNotFoundException.class, () -> service.findAllById(ids));
    }

    @Test
    @DisplayName("Поиск по одному айди")
    void findByIdTest() {
        doReturn(Optional.of(passport2)).when(repository).findById(2L);

        assertEquals(service.findById(2L), mapper.toDto(passport2));
    }

    @Test
    @DisplayName("Поиск по одному айди должен кинуть исключение если айди не найден")
    void getByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        doReturn(Optional.empty()).when(repository).findById(3L);

        assertThrows(EntityNotFoundException.class, () -> service.findById(3L));
    }

    @Test
    @DisplayName("Обновление должно кинуть исключение если обновляемой сущности не существует")
    void updateShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        doReturn(Optional.empty()).when(repository).findById(3L);

        assertThrows(EntityNotFoundException.class, () -> service.update(3L, mapper.toDto(passport1)));
    }
}
