package com.bank.controller;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.dto.ActualRegistrationDto;
import com.bank.dto.PassportDto;
import com.bank.dto.ProfileDto;
import com.bank.dto.RegistrationDto;
import com.bank.service.impl.AccountDetailsIdServiceImpl;
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
@WebMvcTest(AccountDetailsIdController.class)
class AccountDetailsIdControllerTest {

    @MockBean
    AccountDetailsIdServiceImpl service;

    @Autowired
    MockMvc mockMvc;

    private AccountDetailsIdDto accountDetailsIdDto1;

    private AccountDetailsIdDto accountDetailsIdDto2;

    @BeforeEach
    void setUp() {
        ProfileDto profileDto1 = new ProfileDto();
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

        ProfileDto profileDto2 = new ProfileDto();
        profileDto2.setId(2L);
        PassportDto passportDto2 = new PassportDto();
        passportDto2.setId(2L);
        passportDto2.setSeries(33);
        passportDto2.setDateOfIssue(LocalDate.now());
        RegistrationDto registrationDto2 = new RegistrationDto();
        registrationDto2.setId(2L);
        registrationDto2.setCountry("Eng");
        passportDto2.setRegistration(registrationDto2);
        profileDto2.setPassport(passportDto2);
        ActualRegistrationDto actualRegistrationDto2 = new ActualRegistrationDto();
        actualRegistrationDto2.setId(2L);
        profileDto2.setActualRegistration(actualRegistrationDto2);

        accountDetailsIdDto1 = new AccountDetailsIdDto();
        accountDetailsIdDto2 = new AccountDetailsIdDto();
        accountDetailsIdDto1.setId(1L);
        accountDetailsIdDto2.setId(2L);
        accountDetailsIdDto1.setProfile(profileDto1);
        accountDetailsIdDto2.setProfile(profileDto2);
    }

    @Test
    void read() throws Exception {
        when(service.findById(any())).thenReturn(accountDetailsIdDto1);

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
    void create() throws Exception {
        ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(accountDetailsIdDto1);

        when(service.save(any())).thenReturn(accountDetailsIdDto1);

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
    void update() throws Exception {
        ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(accountDetailsIdDto1);

        when(service.update(eq(1L),any())).thenReturn(accountDetailsIdDto1);

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
    void readAllById() throws Exception {
        when(service.findAllById(any())).thenReturn(List.of(accountDetailsIdDto1, accountDetailsIdDto2));

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
}