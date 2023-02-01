package com.bank.service;

import com.bank.dto.PassportDto;
import com.bank.entity.PassportEntity;
import com.bank.entity.RegistrationEntity;
import com.bank.mapper.PassportMapperImpl;
import com.bank.repository.PassportRepository;
import com.bank.service.impl.PassportServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PassportServiceTest {

    @Mock
    private PassportRepository rep;

    @Spy
    private PassportMapperImpl mapper;

    @InjectMocks
    private PassportServiceImpl service;

    private PassportEntity passportEntity1;

    private PassportEntity passportEntity2;

    @BeforeEach
    void setUp() {
        passportEntity1 = new PassportEntity();
        passportEntity1.setId(1L);
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setId(1L);
        registrationEntity.setCountry("Russia");
        passportEntity1.setRegistration(registrationEntity);

        passportEntity2 = new PassportEntity();
        passportEntity2.setId(2L);
        RegistrationEntity registrationEntity2 = new RegistrationEntity();
        registrationEntity2.setId(2L);
        registrationEntity2.setCountry("NOTRussia");
        passportEntity2.setRegistration(registrationEntity2);
    }

    @Test
    void saveTest() {
        PassportDto passportDto = mapper.toDto(passportEntity2);
        when(rep.save(any(PassportEntity.class))).thenReturn(passportEntity2);
        assertThat(service.save(passportDto)).isEqualTo(passportDto);
    }

    @Test
    void findAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<PassportDto> listOfDto = List.of(mapper.toDto(passportEntity1), mapper.toDto(passportEntity2));
        when(rep.findAllById(any())).thenReturn(List.of(passportEntity1, passportEntity2));
        assertThat(service.findAllById(ids)).isEqualTo(listOfDto);
    }

    @Test
    void findAllByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        when(rep.findAllById(any())).thenReturn(List.of(passportEntity1, passportEntity2));
        try {
            service.findAllById(ids);
            fail();
        } catch (EntityNotFoundException ex) {
            assertTrue(true);
        }
    }

    @Test
    void findById() {
        when(rep.findById(2L)).thenReturn(Optional.of(passportEntity2));
        assertThat(service.findById(2L)).isEqualTo(mapper.toDto(passportEntity2));
    }

    @Test
    void getByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        when(rep.findById(3L)).thenReturn(Optional.empty());
        try {
            service.findById(3L);
            fail();
        } catch (EntityNotFoundException ex) {
            assertTrue(true);
        }
    }

    @Test
    void updateShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        when(rep.findById(3L)).thenReturn(Optional.empty());
        try {
            service.update(3L, mapper.toDto(passportEntity1));
            fail();
        } catch (EntityNotFoundException ex) {
            assertTrue(true);
        }
    }
}
