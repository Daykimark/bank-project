package com.bank.controller;

import com.bank.AbstractTest;
import com.bank.dto.PassportDto;
import com.bank.service.impl.PassportServiceImpl;
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

@WebMvcTest(PassportController.class)
class PassportControllerTest extends AbstractTest {

    private static DtoSupplier supplier;

    @MockBean
    private PassportServiceImpl service;

    @Autowired
    private MockMvc mockMvc;

    private static PassportDto profile1;

    private static PassportDto profile2;

    @BeforeAll
    static void setUp() {
        supplier = new DtoSupplier();

        profile1 = supplier.getPassport(1L, 12, 37882L, "lol", "john",
                "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                LocalDate.MIN, 72, LocalDate.MIN, supplier.getRegistration(1L,
                        "Russia", "Mos", "Moso", "Some", "Soe",
                        "OOO", "28838", "dhh", "2888", 28L)
        );
        profile2 = supplier.getPassport(2L, 12, 37882L, "lol", "john",
                "NO", "MUZ", LocalDate.MIN, "Moscow", "NOtrouble",
                LocalDate.MIN, 72, LocalDate.MIN, supplier.getRegistration(2L,
                        "NOTRussia", "Mos", "Moso", "Some", "Soe",
                        "OOO", "28838", "dhh", "2888", 28L));
    }

    @Test
    @DisplayName("Поиск по одному айди")
    void readTest() throws Exception {
        doReturn(profile1).when(service).findById(any());

        mockMvc.perform(get("/passport/read/1").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.registration.id").value(1))
                .andExpect(jsonPath("$.registration.country").value("Russia"));

    }

    @Test
    @DisplayName("Создание объекта")
    void createTest() throws Exception {
        doReturn(profile1).when(service).save(any());

        String json = toJson(profile1);

        mockMvc.perform(post("/passport/create").content(json).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.registration.id").value(1))
                .andExpect(jsonPath("$.registration.country").value("Russia"));
    }

    @Test
    @DisplayName("Обновление объекта")
    void updateTest() throws Exception {
        doReturn(profile1).when(service).update(eq(1L), any());

        String json = toJson(profile1);

        mockMvc.perform(put("/passport/update/1").content(json).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.registration.id").value(1))
                .andExpect(jsonPath("$.registration.country").value("Russia"));
    }

    @Test
    @DisplayName("Поиск по списку айди")
    void readAllByIdTest() throws Exception {
        doReturn(List.of(profile1, profile2)).when(service).findAllById(any());

        mockMvc.perform(get("/passport/read/all?ids=1,2").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].registration.id").value(1))
                .andExpect(jsonPath("$[0].registration.country").value("Russia"))
                .andExpect(jsonPath("$[1]").exists())
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].registration.id").value(2))
                .andExpect(jsonPath("$[1].registration.country").value("NOTRussia"));
    }

    @Test
    @DisplayName("Некорректный URL при чтении одной записи")
    void incorrectUrlReadTest() throws Exception {
        mockMvc.perform(get("/passport/read/p").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }

    @Test
    @DisplayName("Некорректный URL при чтении одной или более записей")
    void incorrectUrlReadAllByIdTest() throws Exception {
        mockMvc.perform(get("/passport/read/all/p").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404));
    }

    @Test
    @DisplayName("Некорректный URL при обновлении")
    void incorrectUrlUpdateTest() throws Exception {
        mockMvc.perform(get("/passport/update").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404));
    }

    @Test
    @DisplayName("Некорректный URL при создании")
    void incorrectUrlCreateTest() throws Exception {
        mockMvc.perform(get("/passport/create").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(405));
    }
}