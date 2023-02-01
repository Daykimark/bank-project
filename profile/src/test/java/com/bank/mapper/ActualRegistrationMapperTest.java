package com.bank.mapper;

import com.bank.dto.ActualRegistrationDto;
import com.bank.dto.RegistrationDto;
import com.bank.entity.ActualRegistrationEntity;
import com.bank.entity.RegistrationEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ActualRegistrationMapperTest {

    ActualRegistrationMapperImpl mapper = new ActualRegistrationMapperImpl();

    ActualRegistrationEntity testEntity;

    ActualRegistrationDto testDto;

    @BeforeEach
    void setUp() {
        testEntity = new ActualRegistrationEntity();
        testDto = new ActualRegistrationDto();


        testEntity.setId(1L);
        testEntity.setIndex(23L);
        testEntity.setCity("Gorod");

        testDto.setId(1L);
        testDto.setIndex(23L);
        testDto.setCity("Gorod");
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
        List<ActualRegistrationEntity> entities = new ArrayList<>();
        entities.add(testEntity);
        entities.add(new ActualRegistrationEntity());

        List<ActualRegistrationDto> dtoes = new ArrayList<>();
        dtoes.add(testDto);
        dtoes.add(new ActualRegistrationDto());

        assertThat(mapper.toDtoList(entities)).isEqualTo(dtoes);
    }

    @Test
    void mergeToEntity() {
        ActualRegistrationEntity entity = new ActualRegistrationEntity();
        testEntity.setId(null);
        assertThat(mapper.mergeToEntity(entity, testDto)).isEqualTo(testEntity);
    }
}