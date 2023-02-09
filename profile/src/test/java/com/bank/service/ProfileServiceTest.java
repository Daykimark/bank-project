package com.bank.service;

import com.bank.AbstractTest;
import com.bank.dto.ProfileDto;
import com.bank.entity.ProfileEntity;
import com.bank.mapper.ProfileMapperImpl;
import com.bank.repository.ProfileRepository;
import com.bank.service.impl.ProfileServiceImpl;
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


public class ProfileServiceTest extends AbstractTest {

    @Mock
    private ProfileRepository repository;

    @Spy
    private ProfileMapperImpl mapper;

    @InjectMocks
    private ProfileServiceImpl service;

    private static ProfileEntity profile1;

    private static ProfileEntity profile2;

    @BeforeAll
    static void setUp() {
        EntitySupplier supplier = new EntitySupplier();

        profile1 = supplier.getProfile(1L, 11L, "Hello@mail.ru", "JENYA", 88L,
                90L, supplier.getPassport(1L, 12, 37882L, "lol", "john",
                        "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                        LocalDate.MIN, 72, LocalDate.MIN, supplier.getRegistration(1L,
                                "Russia", "Mos", "Moso", "Some", "Soe",
                                "OOO", "28838", "dhh", "2888", 28L)),
                supplier.getActualRegistration(1L, "Russia", "Mos", "Moscow", "Hjs",
                        "Sone", "Some", "Some", "322", "22", 2L));

        profile2 = supplier.getProfile(2L, 11L, "Hello@mail.ru", "JENYA", 88L,
                90L, supplier.getPassport(2L, 12, 37882L, "lol", "john",
                        "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                        LocalDate.MIN, 72, LocalDate.MIN, supplier.getRegistration(2L,
                                "Russia", "Mos", "Moso", "Some", "Soe",
                                "OOO", "28838", "dhh", "2888", 28L)),
                supplier.getActualRegistration(2L, "Russia", "Mos", "Moscow", "Hjs",
                        "Sone", "Some", "Some", "322", "22", 2L));

    }

    @Test
    @DisplayName("Создание объекта")
    void saveTest() {
        doReturn(profile2).when(repository).save(any(ProfileEntity.class));

        ProfileDto profileDto = mapper.toDto(profile2);

        assertEquals(service.save(profileDto), profileDto);
    }

    @Test
    @DisplayName("Поиск по списку айди")
    void findAllByIdTest() {
        doReturn(List.of(profile1, profile2)).when(repository).findAllById(any());

        List<Long> ids = List.of(1L, 2L);
        List<ProfileDto> profiles = List.of(mapper.toDto(profile1),
                mapper.toDto(profile2));

        assertEquals(service.findAllById(ids), profiles);
    }

    @Test
    @DisplayName("Поиск по списку айди должен кинуть исключение если один из пользователей не найден")
    void findAllByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        doReturn(List.of(profile1, profile2)).when(repository).findAllById(any());

        List<Long> ids = List.of(1L, 2L, 3L);

        assertThrows(EntityNotFoundException.class, () -> service.findAllById(ids));
    }

    @Test
    @DisplayName("Поиск по одному айди")
    void findByIdTest() {
        doReturn(Optional.of(profile2)).when(repository).findById(2L);

        assertEquals(service.findById(2L), mapper.toDto(profile2));
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

        assertThrows(EntityNotFoundException.class, () -> service.update(3L, mapper.toDto(profile1)));
    }
}
