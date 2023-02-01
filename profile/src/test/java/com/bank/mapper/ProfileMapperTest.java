package com.bank.mapper;

import com.bank.dto.ActualRegistrationDto;
import com.bank.dto.PassportDto;
import com.bank.dto.ProfileDto;
import com.bank.dto.RegistrationDto;
import com.bank.entity.ActualRegistrationEntity;
import com.bank.entity.PassportEntity;
import com.bank.entity.ProfileEntity;
import com.bank.entity.RegistrationEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class ProfileMapperTest {

    ProfileMapperImpl mapper = new ProfileMapperImpl();

    ProfileEntity testEntity;

    ProfileDto testDto;

    @BeforeEach
    void setUp() {
        testEntity = new ProfileEntity();
        testDto = new ProfileDto();

        testEntity.setPhoneNumber(283992L);
        testEntity.setId(1L);
        PassportEntity passportEntity = new PassportEntity();
        passportEntity.setId(1L);
        passportEntity.setBirthPlace("Russia");
        passportEntity.setSeries(89);
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setId(1L);
        registrationEntity.setCountry("Russia");
        passportEntity.setRegistration(registrationEntity);
        testEntity.setPassport(passportEntity);
        ActualRegistrationEntity actualRegistrationEntity = new ActualRegistrationEntity();
        actualRegistrationEntity.setId(1L);
        testEntity.setActualRegistration(actualRegistrationEntity);

        testDto.setPhoneNumber(283992L);
        testDto.setId(1L);
        PassportDto passportDto = new PassportDto();
        passportDto.setId(1L);
        passportDto.setBirthPlace("Russia");
        passportDto.setSeries(89);
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setId(1L);
        registrationDto.setCountry("Russia");
        passportDto.setRegistration(registrationDto);
        testDto.setPassport(passportDto);
        ActualRegistrationDto actualRegistrationDto = new ActualRegistrationDto();
        actualRegistrationDto.setId(1L);
        testDto.setActualRegistration(actualRegistrationDto);
    }

    @Test
    void toEntity() {
        assertThat(mapper.toEntity(testDto)).isEqualTo(testEntity);
    }

    @Test
    void toDto() {
        assertThat(mapper.toDto(testEntity)).isEqualTo(testDto);
    }

    @Test
    void toDtoList() {
        List<ProfileEntity> entities = new ArrayList<>();
        entities.add(testEntity);
        entities.add(new ProfileEntity());

        List<ProfileDto> dtoes = new ArrayList<>();
        dtoes.add(testDto);
        dtoes.add(new ProfileDto());

        assertThat(mapper.toDtoList(entities)).isEqualTo(dtoes);
    }

    @Test
    void mergeToEntity() {
        ProfileEntity entity = new ProfileEntity();
        testEntity.setId(null);
        testEntity.getPassport().setId(null);
        testEntity.getActualRegistration().setId(null);
        testEntity.getPassport().getRegistration().setId(null);
        assertThat(mapper.mergeToEntity(entity, testDto)).isEqualTo(testEntity);
    }
}