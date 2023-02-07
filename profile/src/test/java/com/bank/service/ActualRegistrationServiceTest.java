package com.bank.service;

import com.bank.AbstractTest;
import com.bank.dto.ActualRegistrationDto;
import com.bank.entity.ActualRegistrationEntity;
import com.bank.mapper.ActualRegistrationMapperImpl;
import com.bank.repository.ActualRegistrationRepository;
import com.bank.service.impl.ActualRegistrationServiceImpl;
import com.bank.supplier.ServiceTestSupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

public class ActualRegistrationServiceTest extends AbstractTest {

    @Mock
    private ActualRegistrationRepository rep;

    @Spy
    private ActualRegistrationMapperImpl mapper;

    @InjectMocks
    private ActualRegistrationServiceImpl service;

    private static ActualRegistrationEntity actualRegistration1;

    private static ActualRegistrationEntity actualRegistration2;

    @BeforeAll
    static void setUp() {
        actualRegistration1 = new ActualRegistrationEntity();
        actualRegistration2 = new ActualRegistrationEntity();

        ServiceTestSupplier supplier = new ServiceTestSupplier();

        supplier.setUpActualRegistrationService(actualRegistration1, actualRegistration2);
    }

    @Test
    @DisplayName("Создание объекта")
    void saveTest() {
        ActualRegistrationDto actualRegistrationDto = mapper.toDto(actualRegistration2);
        when(rep.save(any(ActualRegistrationEntity.class))).thenReturn(actualRegistration2);
        assertThat(service.save(actualRegistrationDto)).isEqualTo(actualRegistrationDto);
    }

    @Test
    @DisplayName("Поиск по списку айди")
    void findAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<ActualRegistrationDto> listOfDto = List.of(mapper.toDto(actualRegistration1), mapper.toDto(actualRegistration2));
        when(rep.findAllById(any())).thenReturn(List.of(actualRegistration1, actualRegistration2));
        assertThat(service.findAllById(ids)).isEqualTo(listOfDto);
    }

    @Test
    @DisplayName("Поиск по списку айди должен кинуть исключение если один из пользователей не найден")
    void findAllByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        when(rep.findAllById(any())).thenReturn(List.of(actualRegistration1, actualRegistration2));
        assertThrows(EntityNotFoundException.class, () -> service.findAllById(ids));
    }

    @Test
    @DisplayName("Поиск по одному айди")
    void findById() {
        when(rep.findById(2L)).thenReturn(Optional.of(actualRegistration2));
        assertThat(service.findById(2L)).isEqualTo(mapper.toDto(actualRegistration2));
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
        assertThrows(EntityNotFoundException.class,
                () -> service.update(3L, mapper.toDto(actualRegistration1)));
    }
}

