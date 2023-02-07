package com.bank.service;

import com.bank.AbstractTest;
import com.bank.dto.ProfileDto;
import com.bank.entity.ProfileEntity;
import com.bank.mapper.ProfileMapperImpl;
import com.bank.repository.ProfileRepository;
import com.bank.service.impl.ProfileServiceImpl;
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


public class ProfileServiceTest extends AbstractTest {

    @Mock
    private ProfileRepository rep;

    @Spy
    private ProfileMapperImpl mapper;

    @InjectMocks
    private ProfileServiceImpl service;

    private static ProfileEntity profile1;

    private static ProfileEntity profile2;

    @BeforeAll
    static void setUp() {
        profile1 = new ProfileEntity();
        profile2 = new ProfileEntity();

        ServiceTestSupplier supplier = new ServiceTestSupplier();

        supplier.setUpProfileService(profile1, profile2);
    }

    @Test
    @DisplayName("Создание объекта")
    void saveTest() {
        ProfileDto profileDto = mapper.toDto(profile2);
        when(rep.save(any(ProfileEntity.class))).thenReturn(profile2);
        assertThat(service.save(profileDto)).isEqualTo(profileDto);
    }

    @Test
    @DisplayName("Поиск по списку айди")
    void findAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<ProfileDto> listOfDto = List.of(mapper.toDto(profile1), mapper.toDto(profile2));
        when(rep.findAllById(any())).thenReturn(List.of(profile1, profile2));
        assertThat(service.findAllById(ids)).isEqualTo(listOfDto);
    }

    @Test
    @DisplayName("Поиск по списку айди должен кинуть исключение если один из пользователей не найден")
    void findAllByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        when(rep.findAllById(any())).thenReturn(List.of(profile1, profile2));
        assertThrows(EntityNotFoundException.class, () -> service.findAllById(ids));
    }

    @Test
    @DisplayName("Поиск по одному айди")
    void findById() {
        when(rep.findById(2L)).thenReturn(Optional.of(profile2));
        assertThat(service.findById(2L)).isEqualTo(mapper.toDto(profile2));
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
        assertThrows(EntityNotFoundException.class, () -> service.update(3L, mapper.toDto(profile1)));
    }
}
