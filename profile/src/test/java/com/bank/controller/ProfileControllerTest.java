package com.bank.controller;

import com.bank.AbstractTest;
import com.bank.dto.ProfileDto;
import com.bank.service.impl.ProfileServiceImpl;
import com.bank.supplier.ControllerTestSupplier;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProfileController.class)
class ProfileControllerTest extends AbstractTest {

    private static final ControllerTestSupplier supplier = new ControllerTestSupplier();

    @MockBean
    private ProfileServiceImpl service;

    @Autowired
    private MockMvc mockMvc;

    private static ProfileDto testDto1;

    private static ProfileDto testDto2;

    @BeforeAll
    static void setUp() {
        testDto1 = new ProfileDto();
        testDto2 = new ProfileDto();

        supplier.setUpProfileController(testDto1, testDto2);
    }

    @Test
    @DisplayName("Поиск по одному айди")
    void read() throws Exception {
        when(service.findById(any())).thenReturn(testDto1);

        mockMvc.perform(get("/profile/read/1").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.passport.id").value(1))
                .andExpect(jsonPath("$.passport.series").value(89))
                .andExpect(jsonPath("$.passport.dateOfIssue").isNotEmpty())
                .andExpect(jsonPath("$.passport.registration.id").value(1))
                .andExpect(jsonPath("$.passport.registration.country").value("Russia"))
                .andExpect(jsonPath("$.actualRegistration.id").value(1));

    }

    @Test
    @DisplayName("Создание объекта")
    void create() throws Exception {
        ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(testDto1);

        when(service.save(any())).thenReturn(testDto1);

        mockMvc.perform(post("/profile/create").content(json).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.passport.id").value(1))
                .andExpect(jsonPath("$.passport.series").value(89))
                .andExpect(jsonPath("$.passport.dateOfIssue").isNotEmpty())
                .andExpect(jsonPath("$.passport.registration.id").value(1))
                .andExpect(jsonPath("$.passport.registration.country").value("Russia"))
                .andExpect(jsonPath("$.actualRegistration.id").value(1));
    }

    @Test
    @DisplayName("Обновление объекта")
    void update() throws Exception {
        ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(testDto1);

        when(service.update(eq(1L), any())).thenReturn(testDto1);

        mockMvc.perform(put("/profile/update/1").content(json).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.passport.id").value(1))
                .andExpect(jsonPath("$.passport.series").value(89))
                .andExpect(jsonPath("$.passport.dateOfIssue").isNotEmpty())
                .andExpect(jsonPath("$.passport.registration.id").value(1))
                .andExpect(jsonPath("$.passport.registration.country").value("Russia"))
                .andExpect(jsonPath("$.actualRegistration.id").value(1));
    }

    @Test
    @DisplayName("Поиск по списку айди")
    void readAllById() throws Exception {
        when(service.findAllById(any())).thenReturn(List.of(testDto1, testDto2));

        mockMvc.perform(get("/profile/read/all?ids=1,2").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].passport.id").value(1))
                .andExpect(jsonPath("$[0].passport.series").value(89))
                .andExpect(jsonPath("$[0].passport.dateOfIssue").isNotEmpty())
                .andExpect(jsonPath("$[0].passport.registration.id").value(1))
                .andExpect(jsonPath("$[0].passport.registration.country").value("Russia"))
                .andExpect(jsonPath("$[0].actualRegistration.id").value(1))
                .andExpect(jsonPath("$[1]").exists())
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].passport.id").value(2))
                .andExpect(jsonPath("$[1].passport.series").value(33))
                .andExpect(jsonPath("$[1].passport.dateOfIssue").isNotEmpty())
                .andExpect(jsonPath("$[1].passport.registration.id").value(2))
                .andExpect(jsonPath("$[1].passport.registration.country").value("NOTRussia"))
                .andExpect(jsonPath("$[1].actualRegistration.id").value(2));
    }
}