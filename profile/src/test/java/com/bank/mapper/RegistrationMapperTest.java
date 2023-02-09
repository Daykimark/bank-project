package com.bank.mapper;

import com.bank.AbstractTest;
import com.bank.dto.RegistrationDto;
import com.bank.entity.RegistrationEntity;
import com.bank.supplier.DtoSupplier;
import com.bank.supplier.EntitySupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationMapperTest extends AbstractTest {

    private static RegistrationMapperImpl mapper;

    private static RegistrationEntity registration1;

    private static RegistrationDto registration2;

    @BeforeAll
    static void setUp() {
        EntitySupplier supplier1 = new EntitySupplier();
        DtoSupplier supplier2 = new DtoSupplier();
        mapper = new RegistrationMapperImpl();

        registration1 = supplier1.getRegistration(1L,
                "Russia", "Mos", "Moso", "Some", "Soe",
                "OOO", "28838", "dhh", "2888", 28L);
        registration2 = supplier2.getRegistration(1L,
                "Russia", "Mos", "Moso", "Some", "Soe",
                "OOO", "28838", "dhh", "2888", 28L);
    }

    @Test
    @DisplayName("Тест из Entity в Dto")
    void toEntityTest() {
        assertEquals(mapper.toEntity(registration2), registration1);
    }

    @Test
    @DisplayName("Тест из Dto в Entity")
    void toDtoTest() {
        assertEquals(mapper.toDto(registration1), registration2);
    }

    @Test
    @DisplayName("Тест из листа Entity в лист Dto")
    void toDtoListTest() {
        List<RegistrationEntity> registrations = List.of(registration1, new RegistrationEntity());

        List<RegistrationDto> registrationDtoes = List.of(registration2, new RegistrationDto());

        assertEquals(mapper.toDtoList(registrations), registrationDtoes);
    }

    @Test
    @DisplayName("Обновление Entity на базе Dto")
    void mergeToEntity() {
        RegistrationEntity registration3 = new RegistrationEntity();
        registration1.setId(null);
        assertEquals(mapper.mergeToEntity(registration3, registration2), registration1);
        registration1.setId(1L);
    }
}
