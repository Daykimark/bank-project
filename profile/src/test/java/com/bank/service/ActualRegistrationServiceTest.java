package com.bank.service;

import com.bank.AbstractTest;
import com.bank.dto.ActualRegistrationDto;
import com.bank.entity.ActualRegistrationEntity;
import com.bank.mapper.ActualRegistrationMapperImpl;
import com.bank.repository.ActualRegistrationRepository;
import com.bank.service.impl.ActualRegistrationServiceImpl;
import com.bank.supplier.EntitySupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

public class ActualRegistrationServiceTest extends AbstractTest {

    @Mock
    private ActualRegistrationRepository repository;

    @Spy
    private ActualRegistrationMapperImpl mapper;

    @InjectMocks
    private ActualRegistrationServiceImpl service;

    private static ActualRegistrationEntity actualRegistration1;

    private static ActualRegistrationEntity actualRegistration2;

    @BeforeAll
    static void setUp() {
        EntitySupplier supplier = new EntitySupplier();

        actualRegistration1 = supplier.getActualRegistration(1L, "Russia", "Mos", "Moscow",
                "Hjs", "Sone", "Some", "Some", "322", "22", 2L);

        actualRegistration2 = supplier.getActualRegistration(2L, "Russia", "Mos", "Moscow",
                "Hjs", "Sone", "Some", "Some", "322", "22", 2L);
    }

    @Test
    @DisplayName("Создание объекта")
    void saveTest() {
        doReturn(actualRegistration2).when(repository).save(any(ActualRegistrationEntity.class));

        ActualRegistrationDto actualRegistrationDto = mapper.toDto(actualRegistration2);

        assertEquals(service.save(actualRegistrationDto), actualRegistrationDto);
    }

    @Test
    @DisplayName("Поиск по списку айди")
    void findAllByIdTest() {
        doReturn(List.of(actualRegistration1, actualRegistration2)).when(repository).findAllById(any());

        List<Long> ids = List.of(1L, 2L);
        List<ActualRegistrationDto> actualRegistrations = List.of(mapper.toDto(actualRegistration1),
                mapper.toDto(actualRegistration2));

        assertEquals(service.findAllById(ids), actualRegistrations);
    }

    @Test
    @DisplayName("Поиск по списку айди должен кинуть исключение если один из пользователей не найден")
    void findAllByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        doReturn(List.of(actualRegistration1, actualRegistration2)).when(repository).findAllById(any());

        List<Long> ids = List.of(1L, 2L, 3L);

        assertThrows(EntityNotFoundException.class, () -> service.findAllById(ids));
    }

    @Test
    @DisplayName("Поиск по одному айди")
    void findByIdTest() {
        doReturn(Optional.of(actualRegistration2)).when(repository).findById(2L);

        assertEquals(service.findById(2L), mapper.toDto(actualRegistration2));
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

        assertThrows(EntityNotFoundException.class, () -> service.update(3L, mapper.toDto(actualRegistration1)));
    }
}

