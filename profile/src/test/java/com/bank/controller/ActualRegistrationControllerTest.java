package com.bank.controller;

import com.bank.dto.ActualRegistrationDto;
import com.bank.dto.PassportDto;
import com.bank.dto.ActualRegistrationDto;
import com.bank.dto.RegistrationDto;
import com.bank.entity.ActualRegistrationEntity;
import com.bank.service.impl.ActualRegistrationServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ActualRegistrationController.class)
class ActualRegistrationControllerTest {

    @MockBean
    ActualRegistrationServiceImpl service;

    @Autowired
    MockMvc mockMvc;

    private ActualRegistrationDto actualRegistrationDto1;

    private ActualRegistrationDto actualRegistrationDto2;

    @BeforeEach
    void setUp() {
        actualRegistrationDto1 = new ActualRegistrationDto();
        actualRegistrationDto2 = new ActualRegistrationDto();
        actualRegistrationDto1.setId(1L);
        actualRegistrationDto2.setId(2L);
    }

    @Test
    void read() throws Exception {
        when(service.findById(any())).thenReturn(actualRegistrationDto1);

        mockMvc.perform(get("/actual/registration/read/1").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1));

    }

    @Test
    void create() throws Exception {
        ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(actualRegistrationDto1);

        when(service.save(any())).thenReturn(actualRegistrationDto1);

        mockMvc.perform(post("/actual/registration/create").content(json).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void update() throws Exception {
        ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(actualRegistrationDto1);

        when(service.update(eq(1L),any())).thenReturn(actualRegistrationDto1);

        mockMvc.perform(put("/actual/registration/update/1").content(json).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void readAllById() throws Exception {
        when(service.findAllById(any())).thenReturn(List.of(actualRegistrationDto1, actualRegistrationDto2));

        mockMvc.perform(get("/actual/registration/read/all?ids=1,2").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1]").exists())
                .andExpect(jsonPath("$[1].id").value(2));
    }
}