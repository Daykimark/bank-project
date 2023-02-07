package com.bank.mapper;

import com.bank.AbstractTest;
import com.bank.dto.ActualRegistrationDto;
import com.bank.entity.ActualRegistrationEntity;
import com.bank.supplier.MapperTestSupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ActualRegistrationMapperTest extends AbstractTest {

    private static final MapperTestSupplier supplier = new MapperTestSupplier();

    private final ActualRegistrationMapperImpl mapper = new ActualRegistrationMapperImpl();

    private static ActualRegistrationEntity testEntity;

    private static ActualRegistrationDto testDto;

    @BeforeAll
    static void setUp() {
        testEntity = new ActualRegistrationEntity();
        testDto = new ActualRegistrationDto();

        supplier.setUpActualRegistrationMapper(testEntity, testDto);
    }

    @Test
    @DisplayName("Тест из Entity в Dto")
    void toEntity() {
        assertThat(mapper.toEntity(testDto)).isEqualTo(testEntity);
    }

    @Test
    @DisplayName("Тест из Dto в Entity")
    void toDto() {
        assertThat(mapper.toDto(testEntity)).isEqualTo(testDto);
    }

    @Test
    @DisplayName("Тест из листа Entity в лист Dto")
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
    @DisplayName("Обновление Entity на базе Dto")
    void mergeToEntity() {
        ActualRegistrationEntity entity = new ActualRegistrationEntity();
        testEntity.setId(null);
        assertThat(mapper.mergeToEntity(entity, testDto)).isEqualTo(testEntity);
        supplier.setUpActualRegistrationMapper(testEntity, testDto);
    }
}