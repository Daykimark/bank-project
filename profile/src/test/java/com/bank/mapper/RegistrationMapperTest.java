package com.bank.mapper;

import com.bank.AbstractTest;
import com.bank.dto.RegistrationDto;
import com.bank.entity.RegistrationEntity;
import com.bank.supplier.MapperTestSupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationMapperTest extends AbstractTest {

    private final static MapperTestSupplier supplier = new MapperTestSupplier();

    private final RegistrationMapperImpl mapper = new RegistrationMapperImpl();

    private static RegistrationEntity testEntity;

    private static RegistrationDto testDto;

    @BeforeAll
    static void setUp() {
        testEntity = new RegistrationEntity();
        testDto = new RegistrationDto();

        supplier.setUpRegistrationMapper(testEntity, testDto);
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
        List<RegistrationEntity> entities = new ArrayList<>();
        entities.add(testEntity);
        entities.add(new RegistrationEntity());

        List<RegistrationDto> dtoes = new ArrayList<>();
        dtoes.add(testDto);
        dtoes.add(new RegistrationDto());

        assertThat(mapper.toDtoList(entities)).isEqualTo(dtoes);
    }

    @Test
    @DisplayName("Обновление Entity на базе Dto")
    void mergeToEntity() {
        RegistrationEntity entity = new RegistrationEntity();
        testEntity.setId(null);
        assertThat(mapper.mergeToEntity(entity, testDto)).isEqualTo(testEntity);
        supplier.setUpRegistrationMapper(testEntity, testDto);
    }
}