package com.bank.mapper;

import com.bank.AbstractTest;
import com.bank.dto.AccountDetailsIdDto;
import com.bank.entity.AccountDetailsIdEntity;
import com.bank.supplier.MapperTestSupplier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class AccountDetailsIdMapperTest extends AbstractTest {

    private static final MapperTestSupplier supplier = new MapperTestSupplier();

    private final AccountDetailsIdMapperImpl mapper = new AccountDetailsIdMapperImpl();

    private static AccountDetailsIdEntity testEntity;

    private static AccountDetailsIdDto testDto;

    @BeforeAll
    static void setUp() {
        testEntity = new AccountDetailsIdEntity();
        testDto = new AccountDetailsIdDto();

        supplier.setUpAccountDetailsIdMapper(testEntity, testDto);
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
        List<AccountDetailsIdEntity> entities = new ArrayList<>();
        entities.add(testEntity);
        entities.add(new AccountDetailsIdEntity());

        List<AccountDetailsIdDto> dtoes = new ArrayList<>();
        dtoes.add(testDto);
        dtoes.add(new AccountDetailsIdDto());

        assertThat(mapper.toDtoList(entities)).isEqualTo(dtoes);
        System.out.println(this);
    }

    @Test
    @DisplayName("Обновление Entity на базе Dto")
    void mergeToEntity() {
        AccountDetailsIdEntity entity = new AccountDetailsIdEntity();
        testEntity.setId(null);
        testEntity.getProfile().setId(null);
        assertThat(mapper.mergeToEntity(entity, testDto)).isEqualTo(testEntity);
        supplier.setUpAccountDetailsIdMapper(testEntity, testDto);
        System.out.println(this);
    }
}