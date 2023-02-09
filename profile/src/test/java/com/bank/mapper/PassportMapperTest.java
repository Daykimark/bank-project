package com.bank.mapper;

import com.bank.AbstractTest;
import com.bank.dto.PassportDto;
import com.bank.entity.PassportEntity;
import com.bank.supplier.DtoSupplier;
import com.bank.supplier.EntitySupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassportMapperTest extends AbstractTest {

    private static EntitySupplier supplier1;

    private static DtoSupplier supplier2;

    private static PassportMapperImpl mapper;

    private static PassportEntity passport1;

    private static PassportDto passport2;

    @BeforeAll
    static void setUp() {
        supplier1 = new EntitySupplier();
        supplier2 = new DtoSupplier();
        mapper = new PassportMapperImpl();

        passport1 = supplier1.getPassport(1L, 12, 37882L, "lol", "john",
                "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                LocalDate.MIN, 72, LocalDate.MIN, supplier1.getRegistration(1L,
                        "Russia", "Mos", "Moso", "Some", "Soe",
                        "OOO", "28838", "dhh", "2888", 28L));
        passport2 = supplier2.getPassport(1L, 12, 37882L, "lol", "john",
                "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                LocalDate.MIN, 72, LocalDate.MIN, supplier2.getRegistration(1L,
                        "Russia", "Mos", "Moso", "Some", "Soe",
                        "OOO", "28838", "dhh", "2888", 28L));
    }

    @Test
    @DisplayName("Тест из Entity в Dto")
    void toEntityTest() {
        assertEquals(mapper.toEntity(passport2), passport1);
    }

    @Test
    @DisplayName("Тест из Dto в Entity")
    void toDtoTest() {
        assertEquals(mapper.toDto(passport1), passport2);
    }

    @Test
    @DisplayName("Тест из листа Entity в лист Dto")
    void toDtoListTest() {
        List<PassportEntity> passports = List.of(passport1, new PassportEntity());

        List<PassportDto> passportDtoes = List.of(passport2, new PassportDto());

        assertEquals(mapper.toDtoList(passports), passportDtoes);
    }

    @Test
    @DisplayName("Обновление Entity на базе Dto")
    void mergeToEntity() {
        PassportEntity passport3 = new PassportEntity();
        passport1.setId(null);
        passport1.getRegistration().setId(null);
        assertEquals(mapper.mergeToEntity(passport3, passport2), passport1);
        passport1.setId(1L);
        passport1.getRegistration().setId(1L);
    }
}
