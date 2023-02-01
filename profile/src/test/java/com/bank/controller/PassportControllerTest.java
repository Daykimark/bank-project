package com.bank.controller;

import com.bank.dto.PassportDto;
import com.bank.dto.RegistrationDto;
import com.bank.service.impl.PassportServiceImpl;
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

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PassportController.class)
class PassportControllerTest {

    @MockBean
    PassportServiceImpl service;

    @Autowired
    MockMvc mockMvc;

    private PassportDto passportDto1;

    private PassportDto passportDto2;

    @BeforeEach
    void setUp() {
        passportDto1 = new PassportDto();
        passportDto1.setId(1L);
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setId(1L);
        registrationDto.setCountry("Russia");
        passportDto1.setRegistration(registrationDto);

        passportDto2 = new PassportDto();
        passportDto2.setId(2L);
        RegistrationDto registrationDto2 = new RegistrationDto();
        registrationDto2.setId(2L);
        registrationDto2.setCountry("NOTRussia");
        passportDto2.setRegistration(registrationDto2);
    }

    @Test
    void read() throws Exception {
        when(service.findById(any())).thenReturn(passportDto1);

        mockMvc.perform(get("/passport/read/1").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.registration.id").value(1))
                .andExpect(jsonPath("$.registration.country").value("Russia"));

    }

    @Test
    void create() throws Exception {
        ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(passportDto1);

        when(service.save(any())).thenReturn(passportDto1);

        mockMvc.perform(post("/passport/create").content(json).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.registration.id").value(1))
                .andExpect(jsonPath("$.registration.country").value("Russia"));
    }

    @Test
    void update() throws Exception {
        ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(passportDto1);

        when(service.update(eq(1L),any())).thenReturn(passportDto1);

        mockMvc.perform(put("/passport/update/1").content(json).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.registration.id").value(1))
                .andExpect(jsonPath("$.registration.country").value("Russia"));
    }

    @Test
    void readAllById() throws Exception {
        when(service.findAllById(any())).thenReturn(List.of(passportDto1, passportDto2));

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
}