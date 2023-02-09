package com.bank.controller;

import com.bank.AbstractTest;
import com.bank.dto.RegistrationDto;
import com.bank.service.impl.RegistrationServiceImpl;
import com.bank.supplier.DtoSupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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

@WebMvcTest(RegistrationController.class)
class RegistrationControllerTest extends AbstractTest {

    private static DtoSupplier supplier;

    @MockBean
    private RegistrationServiceImpl service;

    @Autowired
    private MockMvc mockMvc;

    private static RegistrationDto registration1;

    private static RegistrationDto registration2;

    @BeforeAll
    static void setUp() {
        supplier = new DtoSupplier();

        registration1 = supplier.getRegistration(1L,
                "Russia", "Mos", "Moso", "Some", "Soe",
                "OOO", "28838", "dhh", "2888", 28L);
        registration2 = supplier.getRegistration(2L,
                "Russia", "Mos", "Moso", "Some", "Soe",
                "OOO", "28838", "dhh", "2888", 28L);
    }

    @Test
    @DisplayName("Поиск по одному айди")
    void readTest() throws Exception {
        doReturn(registration1).when(service).findById(any());

        mockMvc.perform(get("/registration/read/1").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1));

    }

    @Test
    @DisplayName("Создание объекта")
    void createTest() throws Exception {
        doReturn(registration1).when(service).save(any());

        String json = toJson(registration1);

        mockMvc.perform(post("/registration/create").content(json).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @DisplayName("Обновление объекта")
    void updateTest() throws Exception {
        doReturn(registration1).when(service).update(eq(1L), any());

        String json = toJson(registration1);

        mockMvc.perform(put("/registration/update/1").content(json).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @DisplayName("Поиск по списку айди")
    void readAllByIdTest() throws Exception {
        doReturn(List.of(registration1, registration2)).when(service).findAllById(any());

        mockMvc.perform(get("/registration/read/all?ids=1,2").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1]").exists())
                .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    @DisplayName("Некорректный URL при чтении одной записи")
    void incorrectUrlReadTest() throws Exception {
        mockMvc.perform(get("/registration/read/p").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }

    @Test
    @DisplayName("Некорректный URL при чтении одной или более записей")
    void incorrectUrlReadAllByIdTest() throws Exception {
        mockMvc.perform(get("/registration/read/all/p").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404));
    }

    @Test
    @DisplayName("Некорректный URL при обновлении")
    void incorrectUrlUpdateTest() throws Exception {
        mockMvc.perform(get("/registration/update").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404));
    }

    @Test
    @DisplayName("Некорректный URL при создании")
    void incorrectUrlCreateTest() throws Exception {
        mockMvc.perform(get("/registration/create").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(405));
    }
}