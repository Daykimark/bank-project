package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.AtmDto;
import com.bank.publicinfo.dto.BranchDto;
import com.bank.publicinfo.entity.AtmEntity;
import com.bank.publicinfo.entity.BranchEntity;
import com.bank.publicinfo.supplier.MapperSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class AtmMapperTest {

    private AtmMapper mapper;
    private AtmEntity atm;
    private AtmEntity secondAtm;
    private AtmDto atmDto;
    private AtmDto secondAtmDto;
    @InjectMocks
    private MapperSupplier supplier;


    @BeforeEach
    void prepare() {
        mapper = new AtmMapperImpl();
        supplier = new MapperSupplier();
        atm = supplier.supplyAtm(1L, "test", LocalTime.of(12, 0, 0),
                LocalTime.of(14, 0, 0), true, new BranchEntity(
                        1L, "address", 8909445113L, "city",
                        LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0)));
        secondAtm = supplier.supplyAtm(2L, "test", LocalTime.of(12, 0, 0),
                LocalTime.of(14, 0, 0), true, new BranchEntity(
                        2L, "address", 909445113L, "city",
                        LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0)));
        atmDto = supplier.supplyAtmDto(1L, "test", LocalTime.of(12, 0, 0),
                LocalTime.of(14, 0, 0), true, new BranchDto(
                        1L, "address", 8909445113L, "city",
                        LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0)));
        secondAtmDto = supplier.supplyAtmDto(2L, "test", LocalTime.of(12, 0, 0),
                LocalTime.of(14, 0, 0), true, new BranchDto(
                        2L, "address", 909445113L, "city",
                        LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0)));
    }

    @Test
    @DisplayName("entity to dto")
    public void entityToDtoTest() {
        AtmDto result = mapper.toDto(atm);

        assertEquals(result, atmDto);
    }

    @Test
    @DisplayName("dto to entity")
    public void dtoToEntityTest() {
        AtmEntity result = mapper.toEntity(atmDto);

        assertEquals(result, atm);
    }

    @Test
    @DisplayName("entity list to dto list")
    public void entityListToDtoListTest() {
        List<AtmEntity> atmEntityList = List.of(atm, secondAtm);
        List<AtmDto> atmDtoList = List.of(atmDto, secondAtmDto);
        List<AtmDto> result = mapper.toDtoList(atmEntityList);

        assertAll(
                () -> {
                    assertNotNull(result);
                    assertIterableEquals(atmDtoList, result);
                }
        );
    }


    @Test
    @DisplayName("merge to entity")
    public void mergeToEntityTest() {
        AtmEntity result = mapper.mergeToEntity(atmDto, atm);

        assertEquals(result, atm);
    }
}

