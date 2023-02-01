package com.bank.mapper;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.dto.ActualRegistrationDto;
import com.bank.dto.PassportDto;
import com.bank.dto.ProfileDto;
import com.bank.dto.RegistrationDto;
import com.bank.entity.AccountDetailsIdEntity;
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
class AccountDetailsIdMapperTest {

    AccountDetailsIdMapperImpl mapper = new AccountDetailsIdMapperImpl();

    AccountDetailsIdEntity testEntity;

    AccountDetailsIdDto testDto;

    @BeforeEach
    void setUp() {
        testEntity = new AccountDetailsIdEntity();
        testDto = new AccountDetailsIdDto();

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setId(1L);
        PassportEntity passportEntity = new PassportEntity();
        passportEntity.setId(1L);
        passportEntity.setBirthPlace("Russia");
        passportEntity.setSeries(89);
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setId(1L);
        registrationEntity.setCountry("Russia");
        passportEntity.setRegistration(registrationEntity);
        profileEntity.setPassport(passportEntity);
        ActualRegistrationEntity actualRegistrationEntity = new ActualRegistrationEntity();
        actualRegistrationEntity.setId(1L);
        profileEntity.setActualRegistration(actualRegistrationEntity);

        testEntity.setId(1L);
        testEntity.setProfile(profileEntity);

        ProfileDto profileDto = new ProfileDto();
        profileDto.setId(1L);
        PassportDto passportDto = new PassportDto();
        passportDto.setId(1L);
        passportDto.setBirthPlace("Russia");
        passportDto.setSeries(89);
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setId(1L);
        registrationDto.setCountry("Russia");
        passportDto.setRegistration(registrationDto);
        profileDto.setPassport(passportDto);
        ActualRegistrationDto actualRegistrationDto = new ActualRegistrationDto();
        actualRegistrationDto.setId(1L);
        profileDto.setActualRegistration(actualRegistrationDto);

        testDto.setId(1L);
        testDto.setProfile(profileDto);
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
        List<AccountDetailsIdEntity> entities = new ArrayList<>();
        entities.add(testEntity);
        entities.add(new AccountDetailsIdEntity());

        List<AccountDetailsIdDto> dtoes = new ArrayList<>();
        dtoes.add(testDto);
        dtoes.add(new AccountDetailsIdDto());

        assertThat(mapper.toDtoList(entities)).isEqualTo(dtoes);
    }

    @Test
    void mergeToEntity() {
        AccountDetailsIdEntity entity = new AccountDetailsIdEntity();
        testEntity.setId(null);
        testEntity.getProfile().setId(null);
        assertThat(mapper.mergeToEntity(entity, testDto)).isEqualTo(testEntity);
    }
}