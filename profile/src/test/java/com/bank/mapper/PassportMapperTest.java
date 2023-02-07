package com.bank.mapper;

import com.bank.AbstractTest;
import com.bank.dto.PassportDto;
import com.bank.entity.PassportEntity;
import com.bank.supplier.MapperTestSupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PassportMapperTest extends AbstractTest {

    private static final MapperTestSupplier  supplier = new MapperTestSupplier();

    private final PassportMapperImpl mapper = new PassportMapperImpl();

    private static PassportEntity testEntity;

    private static PassportDto testDto;

    @BeforeAll
    static void setUp() {
        testEntity = new PassportEntity();
        testDto = new PassportDto();

        supplier.setUpPassportMapper(testEntity, testDto);
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
        List<PassportEntity> entities = new ArrayList<>();
        entities.add(testEntity);
        entities.add(new PassportEntity());

        List<PassportDto> dtoes = new ArrayList<>();
        dtoes.add(testDto);
        dtoes.add(new PassportDto());

        assertThat(mapper.toDtoList(entities)).isEqualTo(dtoes);
    }

    @Test
    @DisplayName("Обновление Entity на базе Dto")
    void mergeToEntity() {
        PassportEntity entity = new PassportEntity();
        testEntity.setId(null);
        testEntity.getRegistration().setId(null);
        assertThat(mapper.mergeToEntity(entity, testDto)).isEqualTo(testEntity);
        supplier.setUpPassportMapper(testEntity, testDto);
    }
}