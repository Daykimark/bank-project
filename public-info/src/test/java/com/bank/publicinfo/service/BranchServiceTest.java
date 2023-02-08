package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.BranchDto;
import com.bank.publicinfo.entity.BranchEntity;
import com.bank.publicinfo.mapper.BranchMapperImpl;
import com.bank.publicinfo.repository.BranchRepository;
import com.bank.publicinfo.service.impl.BranchServiceImpl;
import com.bank.publicinfo.supplier.ServiceSupplier;
import com.bank.publicinfo.util.EntityNotFoundSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BranchServiceTest {

    @Mock
    private BranchRepository repository;
    @InjectMocks
    private BranchServiceImpl service;
    @Spy
    private BranchMapperImpl mapper;
    @Spy
    private EntityNotFoundSupplier supplierNotFound;
    @InjectMocks
    private ServiceSupplier supplier;
    private BranchEntity branch;
    private BranchEntity secondBranch;
    private BranchDto branchDto;

    @BeforeEach
    void prepare() {
        branch = supplier.supplyBranch(1L, "address", 85053L, "city",
                LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0));
        secondBranch = supplier.supplyBranch(2L, "address", 85053L, "city",
                LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0));
        branchDto = supplier.supplyBranchDto(1L, "address", 85053L, "city",
                LocalTime.of(12, 0, 0), LocalTime.of(14, 0, 0));
    }

    @Test
    @DisplayName("create")
    public void createTest() {
        doReturn(branch).when(repository).save(any(BranchEntity.class));

        BranchDto result = service.create(branchDto);

        assertEquals(result, branchDto);
    }

    @Test
    @DisplayName("update")
    public void updateTest() {
        branch.setCity("new city");
        service.create(mapper.toDto(branch));

        doReturn(Optional.of(branch)).when(repository).findById(any(Long.class));

        BranchDto result = service.update(1L, mapper.toDto(branch));

        assertEquals(result, mapper.toDto(branch));
    }

    @Test
    @DisplayName("read by id")
    public void readByIdTest() {
        doReturn(Optional.of(branch)).when(repository).findById(any(Long.class));

        BranchDto result = service.findById(branch.getId());

        assertEquals(1L, result.getId());
    }

    @Test
    @DisplayName("read all by id")
    public void readAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<BranchDto> branches = List.of(mapper.toDto(branch), mapper.toDto(secondBranch));

        when(repository.findAllById(any())).thenReturn(List.of(branch, secondBranch));

        assertThat(service.findAllById(ids)).isEqualTo(branches);
    }
}
