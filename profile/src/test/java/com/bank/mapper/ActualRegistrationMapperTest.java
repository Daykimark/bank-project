package com.bank.mapper;

import com.bank.AbstractTest;
import com.bank.dto.ActualRegistrationDto;
import com.bank.entity.ActualRegistrationEntity;
import com.bank.supplier.DtoSupplier;
import com.bank.supplier.EntitySupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActualRegistrationMapperTest extends AbstractTest {

    private static EntitySupplier supplier1;

    private static DtoSupplier supplier2;

    private static ActualRegistrationMapperImpl mapper;

    private static ActualRegistrationEntity actualRegistration1;

    private static ActualRegistrationDto actualRegistration2;

    @BeforeAll
    static void setUp() {
        supplier1 = new EntitySupplier();
        supplier2 = new DtoSupplier();
        mapper = new ActualRegistrationMapperImpl();

        actualRegistration1 = supplier1.getActualRegistration(1L, "Russia", "Mos", "Moscow",
                "Hjs", "Sone", "Some", "Some", "322", "22", 2L);

        actualRegistration2 = supplier2.getActualRegistration(1L, "Russia", "Mos", "Moscow",
                "Hjs", "Sone", "Some", "Some", "322", "22", 2L);
    }

    @Test
    @DisplayName("Тест из Entity в Dto")
    void toEntityTest() {
        assertEquals(mapper.toEntity(actualRegistration2), actualRegistration1);
    }

    @Test
    @DisplayName("Тест из Dto в Entity")
    void toDtoTest() {
        assertEquals(mapper.toDto(actualRegistration1), actualRegistration2);
    }

    @Test
    @DisplayName("Тест из листа Entity в лист Dto")
    void toDtoListTest() {
        List<ActualRegistrationEntity> actualRegistrations = List.of(actualRegistration1,
                new ActualRegistrationEntity());

        List<ActualRegistrationDto> actualRegistrationDtoes = List.of(actualRegistration2,
                new ActualRegistrationDto());

        assertEquals(mapper.toDtoList(actualRegistrations), actualRegistrationDtoes);
    }

    @Test
    @DisplayName("Обновление Entity на базе Dto")
    void mergeToEntity() {
        ActualRegistrationEntity actualRegistration3 = new ActualRegistrationEntity();
        actualRegistration1.setId(null);
        assertEquals(mapper.mergeToEntity(actualRegistration3, actualRegistration2), actualRegistration1);
        actualRegistration1.setId(1L);
    }
}