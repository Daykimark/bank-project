package com.bank.service;

import com.bank.AbstractTest;
import com.bank.dto.RegistrationDto;
import com.bank.entity.RegistrationEntity;
import com.bank.mapper.RegistrationMapperImpl;
import com.bank.repository.RegistrationRepository;
import com.bank.service.impl.RegistrationServiceImpl;
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

public class RegistrationServiceTest extends AbstractTest {

    @Mock
    private RegistrationRepository repository;

    @Spy
    private RegistrationMapperImpl mapper;

    @InjectMocks
    private RegistrationServiceImpl service;

    private static RegistrationEntity registration1;

    private static RegistrationEntity registration2;

    @BeforeAll
    static void setUp() {
        EntitySupplier supplier = new EntitySupplier();

        registration1 = supplier.getRegistration(1L,
                "Russia", "Mos", "Moso", "Some", "Soe",
                "OOO", "28838", "dhh", "2888", 28L);

        registration2 = supplier.getRegistration(2L,
                "Russia", "Mos", "Moso", "Some", "Soe",
                "OOO", "28838", "dhh", "2888", 28L);
    }

    @Test
    @DisplayName("Создание объекта")
    void saveTest() {
        doReturn(registration2).when(repository).save(any(RegistrationEntity.class));

        RegistrationDto registrationDto = mapper.toDto(registration2);

        assertEquals(service.save(registrationDto), registrationDto);
    }

    @Test
    @DisplayName("Поиск по списку айди")
    void findAllByIdTest() {
        doReturn(List.of(registration1, registration2)).when(repository).findAllById(any());

        List<Long> ids = List.of(1L, 2L);
        List<RegistrationDto> registrations = List.of(mapper.toDto(registration1), mapper.toDto(registration2));

        assertEquals(service.findAllById(ids), registrations);
    }

    @Test
    @DisplayName("Поиск по списку айди должен кинуть исключение если один из пользователей не найден")
    void findAllByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        doReturn(List.of(registration1, registration2)).when(repository).findAllById(any());

        List<Long> ids = List.of(1L, 2L, 3L);

        assertThrows(EntityNotFoundException.class, () -> service.findAllById(ids));
    }

    @Test
    @DisplayName("Поиск по одному айди")
    void findByIdTest() {
        doReturn(Optional.of(registration2)).when(repository).findById(2L);

        assertEquals(service.findById(2L), mapper.toDto(registration2));
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

        assertThrows(EntityNotFoundException.class, () -> service.update(3L, mapper.toDto(registration1)));
    }
}
