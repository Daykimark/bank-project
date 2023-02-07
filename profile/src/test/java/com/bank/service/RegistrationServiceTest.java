package com.bank.service;

import com.bank.AbstractTest;
import com.bank.dto.RegistrationDto;
import com.bank.entity.RegistrationEntity;
import com.bank.mapper.RegistrationMapperImpl;
import com.bank.repository.RegistrationRepository;
import com.bank.service.impl.RegistrationServiceImpl;
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

public class RegistrationServiceTest extends AbstractTest {

    @Mock
    private RegistrationRepository rep;

    @Spy
    private RegistrationMapperImpl mapper;

    @InjectMocks
    private RegistrationServiceImpl service;

    private static RegistrationEntity registration1;

    private static RegistrationEntity registration2;

    @BeforeAll
    static void setUp() {
        ServiceTestSupplier supplier = new ServiceTestSupplier();

        registration1 = new RegistrationEntity();
        registration2 = new RegistrationEntity();

        supplier.setUpRegistrationService(registration1, registration2);
    }

    @Test
    @DisplayName("Создание объекта")
    void saveTest() {
        RegistrationDto registrationDto = mapper.toDto(registration2);
        when(rep.save(any(RegistrationEntity.class))).thenReturn(registration2);
        assertThat(service.save(registrationDto)).isEqualTo(registrationDto);
    }

    @Test
    @DisplayName("Поиск по списку айди")
    void findAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<RegistrationDto> listOfDto = List.of(mapper.toDto(registration1), mapper.toDto(registration2));
        when(rep.findAllById(any())).thenReturn(List.of(registration1, registration2));
        assertThat(service.findAllById(ids)).isEqualTo(listOfDto);
    }

    @Test
    @DisplayName("Поиск по списку айди должен кинуть исключение если один из пользователей не найден")
    void findAllByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        when(rep.findAllById(any())).thenReturn(List.of(registration1, registration2));
        assertThrows(EntityNotFoundException.class, () -> service.findAllById(ids));
    }

    @Test
    @DisplayName("Поиск по одному айди")
    void findById() {
        when(rep.findById(2L)).thenReturn(Optional.of(registration2));
        assertThat(service.findById(2L)).isEqualTo(mapper.toDto(registration2));
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
        assertThrows(EntityNotFoundException.class, () -> service.update(3L, mapper.toDto(registration1)));
    }
}
