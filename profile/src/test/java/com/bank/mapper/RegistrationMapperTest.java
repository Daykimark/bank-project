package com.bank.mapper;

import com.bank.dto.RegistrationDto;
import com.bank.entity.RegistrationEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class RegistrationMapperTest {

    RegistrationMapperImpl mapper = new RegistrationMapperImpl();

    RegistrationEntity testEntity;

    RegistrationDto testDto;

    @BeforeEach
    void setUp() {
        testEntity = new RegistrationEntity();
        testDto = new RegistrationDto();

        testEntity.setId(1L);
        testEntity.setCity("London");


        testDto.setId(1L);
        testDto.setCity("London");
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
        List<RegistrationEntity> entities = new ArrayList<>();
        entities.add(testEntity);
        entities.add(new RegistrationEntity());

        List<RegistrationDto> dtoes = new ArrayList<>();
        dtoes.add(testDto);
        dtoes.add(new RegistrationDto());

        assertThat(mapper.toDtoList(entities)).isEqualTo(dtoes);
    }

    @Test
    void mergeToEntity() {
        RegistrationEntity entity = new RegistrationEntity();
        testEntity.setId(null);
        assertThat(mapper.mergeToEntity(entity, testDto)).isEqualTo(testEntity);
    }
}