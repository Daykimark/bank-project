package com.bank.controller;

import com.bank.AbstractTest;
import com.bank.dto.AccountDetailsIdDto;
import com.bank.service.impl.AccountDetailsIdServiceImpl;
import com.bank.supplier.DtoSupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountDetailsIdController.class)
class AccountDetailsIdControllerTest extends AbstractTest {

    private static DtoSupplier supplier;

    @MockBean
    private AccountDetailsIdServiceImpl service;

    @Autowired
    private MockMvc mockMvc;

    private static AccountDetailsIdDto accountDetailsId1;

    private static AccountDetailsIdDto accountDetailsId2;

    @BeforeAll
    static void setUp() {
        supplier = new DtoSupplier();

        accountDetailsId1 = supplier.getAccountDetailsId(1L, 1L,
                supplier.getProfile(1L, 11L, "Hello@mail.ru", "JENYA", 88L,
                        90L, supplier.getPassport(1L, 89, 37882L, "lol", "john",
                                "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                                LocalDate.MIN, 72, LocalDate.MIN, supplier.getRegistration(1L,
                                        "Russia", "Mos", "Moso", "Some", "Soe",
                                        "OOO", "28838", "dhh", "2888", 28L)),
                        supplier.getActualRegistration(1L, "Russia", "Mos", "Moscow", "Hjs",
                                "Sone", "Some", "Some",
                                "322", "22", 2L))
        );
        accountDetailsId2 = supplier.getAccountDetailsId(2L, 2L,
                supplier.getProfile(2L, 11L, "Hello@mail.ru", "JENYA", 88L,
                        90L, supplier.getPassport(2L, 33, 37882L, "lol", "john",
                                "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                                LocalDate.MIN, 72, LocalDate.MIN, supplier.getRegistration(2L,
                                        "Eng", "Mos", "Moso", "Some", "Soe",
                                        "OOO", "28838", "dhh", "2888", 28L)),
                        supplier.getActualRegistration(2L, "Russia", "Mos", "Moscow", "Hjs",
                                "Sone", "Some", "Some",
                                "322", "22", 2L))
        );
    }

    @Test
    @DisplayName("Поиск по одному айди")
    void readTest() throws Exception {
        doReturn(accountDetailsId1).when(service).findById(any());

        mockMvc.perform(get("/account/details/read/1").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.profile.id").value(1))
                .andExpect(jsonPath("$.profile.passport.id").value(1))
                .andExpect(jsonPath("$.profile.passport.series").value(89))
                .andExpect(jsonPath("$.profile.passport.dateOfIssue").isNotEmpty())
                .andExpect(jsonPath("$.profile.passport.registration.id").value(1))
                .andExpect(jsonPath("$.profile.passport.registration.country").value("Russia"))
                .andExpect(jsonPath("$.profile.actualRegistration.id").value(1));

    }

    @Test
    @DisplayName("Создание объекта")
    void createTest() throws Exception {
        doReturn(accountDetailsId1).when(service).save(any());

        String json = toJson(accountDetailsId1);

        mockMvc.perform(post("/account/details/create").content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.profile.id").value(1))
                .andExpect(jsonPath("$.profile.passport.id").value(1))
                .andExpect(jsonPath("$.profile.passport.series").value(89))
                .andExpect(jsonPath("$.profile.passport.dateOfIssue").isNotEmpty())
                .andExpect(jsonPath("$.profile.passport.registration.id").value(1))
                .andExpect(jsonPath("$.profile.passport.registration.country").value("Russia"))
                .andExpect(jsonPath("$.profile.actualRegistration.id").value(1));
    }

    @Test
    @DisplayName("Обновление объекта")
    void updateTest() throws Exception {
        doReturn(accountDetailsId1).when(service).update(eq(1L), any());

        String json = toJson(accountDetailsId1);

        mockMvc.perform(put("/account/details/update/1").content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.profile.id").value(1))
                .andExpect(jsonPath("$.profile.passport.id").value(1))
                .andExpect(jsonPath("$.profile.passport.series").value(89))
                .andExpect(jsonPath("$.profile.passport.dateOfIssue").isNotEmpty())
                .andExpect(jsonPath("$.profile.passport.registration.id").value(1))
                .andExpect(jsonPath("$.profile.passport.registration.country").value("Russia"))
                .andExpect(jsonPath("$.profile.actualRegistration.id").value(1));
    }

    @Test
    @DisplayName("Поиск по списку айди")
    void readAllByIdTest() throws Exception {
        doReturn(List.of(accountDetailsId1, accountDetailsId2)).when(service).findAllById(any());

        mockMvc.perform(get("/account/details/read/all?ids=1,2").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].profile.id").value(1))
                .andExpect(jsonPath("$[0].profile.passport.id").value(1))
                .andExpect(jsonPath("$[0].profile.passport.series").value(89))
                .andExpect(jsonPath("$[0].profile.passport.dateOfIssue").isNotEmpty())
                .andExpect(jsonPath("$[0].profile.passport.registration.id").value(1))
                .andExpect(jsonPath("$[0].profile.passport.registration.country").value("Russia"))
                .andExpect(jsonPath("$[0].profile.actualRegistration.id").value(1))
                .andExpect(jsonPath("$[1]").exists())
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].profile.id").value(2))
                .andExpect(jsonPath("$[1].profile.passport.id").value(2))
                .andExpect(jsonPath("$[1].profile.passport.series").value(33))
                .andExpect(jsonPath("$[1].profile.passport.dateOfIssue").isNotEmpty())
                .andExpect(jsonPath("$[1].profile.passport.registration.id").value(2))
                .andExpect(jsonPath("$[1].profile.passport.registration.country").value("Eng"))
                .andExpect(jsonPath("$[1].profile.actualRegistration.id").value(2));
    }

    @Test
    @DisplayName("Некорректный URL при чтении одной записи")
    void incorrectUrlReadTest() throws Exception {
        mockMvc.perform(get("/account/details/read/p").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }

    @Test
    @DisplayName("Некорректный URL при чтении одной или более записей")
    void incorrectUrlReadAllByIdTest() throws Exception {
        mockMvc.perform(get("/account/details/read/all/p").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404));
    }

    @Test
    @DisplayName("Некорректный URL при обновлении")
    void incorrectUrlUpdateTest() throws Exception {
        mockMvc.perform(get("/account/details/update").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404));
    }

    @Test
    @DisplayName("Некорректный URL при создании")
    void incorrectUrlCreateTest() throws Exception {
        mockMvc.perform(get("/account/details/create").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(405));
    }
}