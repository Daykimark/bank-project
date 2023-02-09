package com.bank.mapper;

import com.bank.AbstractTest;
import com.bank.dto.ProfileDto;
import com.bank.entity.ProfileEntity;
import com.bank.supplier.DtoSupplier;
import com.bank.supplier.EntitySupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfileMapperTest extends AbstractTest {

    private static ProfileMapperImpl mapper;

    private static ProfileEntity profile1;

    private static ProfileDto profile2;

    @BeforeAll
    static void setUp() {
        EntitySupplier supplier1 = new EntitySupplier();
        DtoSupplier supplier2 = new DtoSupplier();
        mapper = new ProfileMapperImpl();

        profile1 = supplier1.getProfile(1L, 11L, "Hello@mail.ru", "JENYA", 88L,
                90L, supplier1.getPassport(1L, 12, 37882L, "lol", "john",
                        "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                        LocalDate.MIN, 72, LocalDate.MIN, supplier1.getRegistration(1L,
                                "Russia", "Mos", "Moso", "Some", "Soe",
                                "OOO", "28838", "dhh", "2888", 28L)),
                supplier1.getActualRegistration(1L, "Russia", "Mos", "Moscow", "Hjs",
                        "Sone", "Some", "Some", "322", "22", 2L));
        profile2 = supplier2.getProfile(1L, 11L, "Hello@mail.ru", "JENYA", 88L,
                90L, supplier2.getPassport(1L, 12, 37882L, "lol", "john",
                        "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                        LocalDate.MIN, 72, LocalDate.MIN, supplier2.getRegistration(1L,
                                "Russia", "Mos", "Moso", "Some", "Soe",
                                "OOO", "28838", "dhh", "2888", 28L)),
                supplier2.getActualRegistration(1L, "Russia", "Mos", "Moscow", "Hjs",
                        "Sone", "Some", "Some", "322", "22", 2L));
    }

    @Test
    @DisplayName("Тест из Entity в Dto")
    void toEntityTest() {
        assertEquals(mapper.toEntity(profile2), profile1);
    }

    @Test
    @DisplayName("Тест из Dto в Entity")
    void toDtoTest() {
        assertEquals(mapper.toDto(profile1), profile2);
    }

    @Test
    @DisplayName("Тест из листа Entity в лист Dto")
    void toDtoListTest() {
        List<ProfileEntity> profiles = List.of(profile1, new ProfileEntity());

        List<ProfileDto> profileDtoes = List.of(profile2, new ProfileDto());

        assertEquals(mapper.toDtoList(profiles), profileDtoes);
    }

    @Test
    @DisplayName("Обновление Entity на базе Dto")
    void mergeToEntity() {
        ProfileEntity profile3 = new ProfileEntity();
        profile1.setId(null);
        profile1.getPassport().setId(null);
        profile1.getActualRegistration().setId(null);
        profile1.getPassport().getRegistration().setId(null);
        assertEquals(mapper.mergeToEntity(profile3, profile2), profile1);
        profile1.setId(1L);
        profile1.getPassport().setId(1L);
        profile1.getActualRegistration().setId(1L);
        profile1.getPassport().getRegistration().setId(1L);
    }
}
