package com.bank.service;

import com.bank.dto.ProfileDto;
import com.bank.entity.ActualRegistrationEntity;
import com.bank.entity.PassportEntity;
import com.bank.entity.ProfileEntity;
import com.bank.entity.RegistrationEntity;
import com.bank.mapper.ProfileMapperImpl;
import com.bank.repository.ProfileRepository;
import com.bank.service.impl.ProfileServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProfileServiceTest {

    @Mock
    private ProfileRepository rep;

    @Spy
    private ProfileMapperImpl mapper;

    @InjectMocks
    private ProfileServiceImpl service;

    private ProfileEntity profileEntity1;

    private ProfileEntity profileEntity2;

    @BeforeEach
    void setUp() {
        profileEntity1 = new ProfileEntity();
        profileEntity1.setId(1L);
        PassportEntity passportEntity = new PassportEntity();
        passportEntity.setId(1L);
        passportEntity.setSeries(89);
        passportEntity.setDateOfIssue(LocalDate.now());
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setId(1L);
        registrationEntity.setCountry("Russia");
        passportEntity.setRegistration(registrationEntity);
        profileEntity1.setPassport(passportEntity);
        ActualRegistrationEntity actualRegistrationEntity = new ActualRegistrationEntity();
        actualRegistrationEntity.setId(1L);
        profileEntity1.setActualRegistration(actualRegistrationEntity);

        profileEntity2 = new ProfileEntity();
        profileEntity2.setId(2L);
        PassportEntity passportEntity2 = new PassportEntity();
        passportEntity2.setId(2L);
        passportEntity2.setSeries(33);
        passportEntity2.setDateOfIssue(LocalDate.now());
        RegistrationEntity registrationEntity2 = new RegistrationEntity();
        registrationEntity2.setId(2L);
        registrationEntity2.setCountry("NOTRussia");
        passportEntity2.setRegistration(registrationEntity2);
        profileEntity2.setPassport(passportEntity2);
        ActualRegistrationEntity actualRegistrationEntity2 = new ActualRegistrationEntity();
        actualRegistrationEntity2.setId(2L);
        profileEntity2.setActualRegistration(actualRegistrationEntity2);
    }

    @Test
    void saveTest() {
        ProfileDto profileDto = mapper.toDto(profileEntity2);
        when(rep.save(any(ProfileEntity.class))).thenReturn(profileEntity2);
        assertThat(service.save(profileDto)).isEqualTo(profileDto);
    }

    @Test
    void findAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<ProfileDto> listOfDto = List.of(mapper.toDto(profileEntity1), mapper.toDto(profileEntity2));
        when(rep.findAllById(any())).thenReturn(List.of(profileEntity1, profileEntity2));
        assertThat(service.findAllById(ids)).isEqualTo(listOfDto);
    }

    @Test
    void findAllByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        when(rep.findAllById(any())).thenReturn(List.of(profileEntity1, profileEntity2));
        try {
            service.findAllById(ids);
            fail();
        } catch (EntityNotFoundException ex) {
            assertTrue(true);
        }
    }

    @Test
    void findById() {
        when(rep.findById(2L)).thenReturn(Optional.of(profileEntity2));
        assertThat(service.findById(2L)).isEqualTo(mapper.toDto(profileEntity2));
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
            service.update(3L, mapper.toDto(profileEntity1));
            fail();
        } catch (EntityNotFoundException ex) {
            assertTrue(true);
        }
    }
}
