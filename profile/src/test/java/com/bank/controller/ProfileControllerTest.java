package com.bank.controller;

import com.bank.dto.ActualRegistrationDto;
import com.bank.dto.PassportDto;
import com.bank.dto.ProfileDto;
import com.bank.dto.RegistrationDto;
import com.bank.service.impl.ProfileServiceImpl;
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
@WebMvcTest(ProfileController.class)
class ProfileControllerTest {

    @MockBean
    ProfileServiceImpl service;

    @Autowired
    MockMvc mockMvc;

    private ProfileDto profileDto1;

    private ProfileDto profileDto2;

    @BeforeEach
    void setUp() {
        profileDto1 = new ProfileDto();
        profileDto1.setId(1L);
        PassportDto passportDto = new PassportDto();
        passportDto.setId(1L);
        passportDto.setSeries(89);
        passportDto.setDateOfIssue(LocalDate.now());
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setId(1L);
        registrationDto.setCountry("Russia");
        passportDto.setRegistration(registrationDto);
        profileDto1.setPassport(passportDto);
        ActualRegistrationDto actualRegistrationDto = new ActualRegistrationDto();
        actualRegistrationDto.setId(1L);
        profileDto1.setActualRegistration(actualRegistrationDto);

        profileDto2 = new ProfileDto();
        profileDto2.setId(2L);
        PassportDto passportDto1 = new PassportDto();
        passportDto1.setId(2L);
        passportDto1.setSeries(33);
        passportDto1.setDateOfIssue(LocalDate.now());
        RegistrationDto registrationDto1 = new RegistrationDto();
        registrationDto1.setId(2L);
        registrationDto1.setCountry("NOTRussia");
        passportDto1.setRegistration(registrationDto1);
        profileDto2.setPassport(passportDto1);
        ActualRegistrationDto actualRegistrationDto1 = new ActualRegistrationDto();
        actualRegistrationDto1.setId(2L);
        profileDto2.setActualRegistration(actualRegistrationDto1);
    }

    @Test
    void read() throws Exception {
        when(service.findById(any())).thenReturn(profileDto1);

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
    void create() throws Exception {
        ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(profileDto1);

        when(service.save(any())).thenReturn(profileDto1);

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
    void update() throws Exception {
        ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(profileDto1);

        when(service.update(eq(1L),any())).thenReturn(profileDto1);

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
    void readAllById() throws Exception {
        when(service.findAllById(any())).thenReturn(List.of(profileDto1, profileDto2));

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