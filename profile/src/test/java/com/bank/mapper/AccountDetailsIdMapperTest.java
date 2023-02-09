package com.bank.mapper;

import com.bank.AbstractTest;
import com.bank.dto.AccountDetailsIdDto;
import com.bank.entity.AccountDetailsIdEntity;
import com.bank.supplier.DtoSupplier;
import com.bank.supplier.EntitySupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AccountDetailsIdMapperTest extends AbstractTest {

    private static EntitySupplier supplier1;

    private static DtoSupplier supplier2;

    private static AccountDetailsIdMapperImpl mapper;

    private static AccountDetailsIdEntity accountDetailsId1;

    private static AccountDetailsIdDto accountDetailsId2;

    @BeforeAll
    static void setUp() {
        supplier1 = new EntitySupplier();
        supplier2 = new DtoSupplier();
        mapper = new AccountDetailsIdMapperImpl();

        accountDetailsId1 = supplier1.getAccountDetailsId(1L, 1L,
                supplier1.getProfile(1L, 11L, "Hello@mail.ru", "JENYA", 88L,
                        90L, supplier1.getPassport(1L, 12, 37882L, "lol", "john",
                                "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                                LocalDate.MIN, 72, LocalDate.MIN, supplier1.getRegistration(1L,
                                        "Russia", "Mos", "Moso", "Some", "Soe",
                                        "OOO", "28838", "dhh", "2888", 28L)),
                        supplier1.getActualRegistration(1L, "Russia", "Mos", "Moscow",
                                "Hjs", "Sone", "Some",
                                "Some", "322", "22", 2L))
        );
        accountDetailsId2 = supplier2.getAccountDetailsId(1L, 1L,
                supplier2.getProfile(1L, 11L, "Hello@mail.ru", "JENYA", 88L,
                        90L, supplier2.getPassport(1L, 12, 37882L, "lol", "john",
                                "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                                LocalDate.MIN, 72, LocalDate.MIN, supplier2.getRegistration(1L,
                                        "Russia", "Mos", "Moso", "Some", "Soe",
                                        "OOO", "28838", "dhh", "2888", 28L)),
                        supplier2.getActualRegistration(1L, "Russia", "Mos", "Moscow",
                                "Hjs", "Sone", "Some",
                                "Some", "322", "22", 2L))
        );
    }

    @Test
    @DisplayName("Тест из Entity в Dto")
    void toEntityTest() {
        assertEquals(mapper.toEntity(accountDetailsId2), accountDetailsId1);
    }

    @Test
    @DisplayName("Тест из Dto в Entity")
    void toDtoTest() {
        assertEquals(mapper.toDto(accountDetailsId1), accountDetailsId2);
    }

    @Test
    @DisplayName("Тест из листа Entity в лист Dto")
    void toDtoListTest() {
        List<AccountDetailsIdEntity> accountDetailsIds = List.of(accountDetailsId1, new AccountDetailsIdEntity());

        List<AccountDetailsIdDto> accountDetailsIdDtoes = List.of(accountDetailsId2, new AccountDetailsIdDto());

        assertEquals(mapper.toDtoList(accountDetailsIds), accountDetailsIdDtoes);
    }

    @Test
    @DisplayName("Обновление Entity на базе Dto")
    void mergeToEntity() {
        AccountDetailsIdEntity accountDetailsId3 = new AccountDetailsIdEntity();
        accountDetailsId1.setId(null);
        accountDetailsId1.getProfile().setId(null);
        assertEquals(mapper.mergeToEntity(accountDetailsId3, accountDetailsId2), accountDetailsId1);
        accountDetailsId1.setId(1L);
        accountDetailsId1.getProfile().setId(1L);
    }
}