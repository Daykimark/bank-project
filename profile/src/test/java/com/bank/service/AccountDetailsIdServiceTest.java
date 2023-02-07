package com.bank.service;

import com.bank.AbstractTest;
import com.bank.dto.AccountDetailsIdDto;
import com.bank.entity.AccountDetailsIdEntity;
import com.bank.mapper.AccountDetailsIdMapperImpl;
import com.bank.repository.AccountDetailsIdRepository;
import com.bank.service.impl.AccountDetailsIdServiceImpl;
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

public class AccountDetailsIdServiceTest  extends AbstractTest {

    @Mock
    private AccountDetailsIdRepository rep;

    @Spy
    private AccountDetailsIdMapperImpl mapper;

    @InjectMocks
    private AccountDetailsIdServiceImpl service;

    private static AccountDetailsIdEntity accountDetailsId1;

    private static AccountDetailsIdEntity accountDetailsId2;

    @BeforeAll
    static void setUp() {
        ServiceTestSupplier supplier = new ServiceTestSupplier();

        accountDetailsId1 = new AccountDetailsIdEntity();
        accountDetailsId2 = new AccountDetailsIdEntity();

        supplier.setUpAccountDetailsId(accountDetailsId1, accountDetailsId2);
    }

    @Test
    @DisplayName("Создание объекта")
    void saveTest() {
        AccountDetailsIdDto accountDetailsIdDto = mapper.toDto(accountDetailsId2);
        when(rep.save(any(AccountDetailsIdEntity.class))).thenReturn(accountDetailsId2);
        assertThat(service.save(accountDetailsIdDto)).isEqualTo(accountDetailsIdDto);
    }

    @Test
    @DisplayName("Поиск по списку айди")
    void findAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<AccountDetailsIdDto> listOfDto = List
                .of(mapper.toDto(accountDetailsId1), mapper.toDto(accountDetailsId2));
        when(rep.findAllById(any())).thenReturn(List.of(accountDetailsId1, accountDetailsId2));
        assertThat(service.findAllById(ids)).isEqualTo(listOfDto);
    }

    @Test
    @DisplayName("Поиск по списку айди должен кинуть исключение если один из пользователей не найден")
    void findAllByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        when(rep.findAllById(any())).thenReturn(List.of(accountDetailsId1, accountDetailsId2));
        assertThrows(EntityNotFoundException.class, () -> service.findAllById(ids));
    }

    @Test
    @DisplayName("Поиск по одному айди")
    void findById() {
        when(rep.findById(2L)).thenReturn(Optional.of(accountDetailsId2));
        assertThat(service.findById(2L)).isEqualTo(mapper.toDto(accountDetailsId2));
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
                () -> service.update(3L, mapper.toDto(accountDetailsId1)));
    }
}
