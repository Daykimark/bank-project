package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.BranchDto;
import com.bank.publicinfo.entity.BranchEntity;
import com.bank.publicinfo.supplier.MapperSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BranchMapperTest {

    private BranchMapper mapper;
    @InjectMocks
    private MapperSupplier supplier;
    private BranchEntity branch;
    private BranchEntity secondBranch;
    private BranchDto branchDto;
    private BranchDto secondBranchDto;

    @BeforeEach
    void prepare() {
        mapper = new BranchMapperImpl();
        supplier = new MapperSupplier();
        branch = supplier.supplyBranch(1L, "address", 85053L, "city",
                LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0));
        secondBranch = supplier.supplyBranch(2L, "address", 85053L, "city",
                LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0));
        branchDto = supplier.supplyBranchDto(1L, "address", 85053L, "city",
                LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0));
        secondBranchDto = supplier.supplyBranchDto(2L, "address", 85053L, "city",
                LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0));

    }

    @Test
    @DisplayName("entity to dto")
    public void entityToDtoTest() {
        BranchDto result = mapper.toDto(branch);

        assertEquals(result, branchDto);
    }

    @Test
    @DisplayName("dto to entity")
    public void dtoToEntityTest() {
        BranchEntity result = mapper.toEntity(branchDto);

        assertEquals(result, branch);
    }

    @Test
    @DisplayName("entity list to dto list")
    public void entityListToDtoListTest() {
        List<BranchEntity> branchEntityList = List.of(branch, secondBranch);
        List<BranchDto> branchDtoList = List.of(branchDto, secondBranchDto);
        List<BranchDto> result = mapper.toDtoList(branchEntityList);

        assertAll(
                () -> {
                    assertNotNull(result);
                    assertIterableEquals(branchDtoList, result);
                }
        );
    }

    @Test
    @DisplayName("merge to entity")
    public void mergeToEntityTest() {
        BranchEntity result = mapper.mergeToEntity(branchDto, branch);

        assertEquals(result, branch);
    }
}
