package com.bank.mapper;

import com.bank.AbstractTest;
import com.bank.dto.ProfileDto;
import com.bank.entity.ProfileEntity;
import com.bank.supplier.MapperTestSupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProfileMapperTest extends AbstractTest {

    private final static MapperTestSupplier supplier = new MapperTestSupplier();

    private final ProfileMapperImpl mapper = new ProfileMapperImpl();

    private static ProfileEntity testEntity;

    private static ProfileDto testDto;

    @BeforeAll
    static void setUp() {
        testEntity = new ProfileEntity();
        testDto = new ProfileDto();

        supplier.setUpProfileMapper(testEntity, testDto);
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
        List<ProfileEntity> entities = new ArrayList<>();
        entities.add(testEntity);
        entities.add(new ProfileEntity());

        List<ProfileDto> dtoes = new ArrayList<>();
        dtoes.add(testDto);
        dtoes.add(new ProfileDto());

        assertThat(mapper.toDtoList(entities)).isEqualTo(dtoes);
    }

    @Test
    @DisplayName("Обновление Entity на базе Dto")
    void mergeToEntity() {
        ProfileEntity entity = new ProfileEntity();
        testEntity.setId(null);
        testEntity.getPassport().setId(null);
        testEntity.getActualRegistration().setId(null);
        testEntity.getPassport().getRegistration().setId(null);
        assertThat(mapper.mergeToEntity(entity, testDto)).isEqualTo(testEntity);
        supplier.setUpProfileMapper(testEntity, testDto);
    }
}