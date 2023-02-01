package com.bank.mapper;

import com.bank.dto.PassportDto;
import com.bank.dto.RegistrationDto;
import com.bank.entity.PassportEntity;
import com.bank.entity.RegistrationEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class PassportMapperTest {

    PassportMapperImpl mapper = new PassportMapperImpl();

    PassportEntity testEntity;

    PassportDto testDto;

    @BeforeEach
    void setUp() {
        testEntity = new PassportEntity();
        testDto = new PassportDto();

        testEntity.setGender("MUZ");
        testEntity.setId(1L);
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setId(1L);
        registrationEntity.setCountry("Russia");
        testEntity.setRegistration(registrationEntity);

        testDto.setGender("MUZ");
        testDto.setId(1L);
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setId(1L);
        registrationDto.setCountry("Russia");
        testDto.setRegistration(registrationDto);
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
        List<PassportEntity> entities = new ArrayList<>();
        entities.add(testEntity);
        entities.add(new PassportEntity());

        List<PassportDto> dtoes = new ArrayList<>();
        dtoes.add(testDto);
        dtoes.add(new PassportDto());

        assertThat(mapper.toDtoList(entities)).isEqualTo(dtoes);
    }

    @Test
    void mergeToEntity() {
        PassportEntity entity = new PassportEntity();
        testEntity.setId(null);
        testEntity.getRegistration().setId(null);
        assertThat(mapper.mergeToEntity(entity, testDto)).isEqualTo(testEntity);
    }
}