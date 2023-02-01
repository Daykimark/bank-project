package com.bank.service;

import com.bank.dto.ActualRegistrationDto;
import com.bank.entity.ActualRegistrationEntity;
import com.bank.mapper.ActualRegistrationMapperImpl;
import com.bank.repository.ActualRegistrationRepository;
import com.bank.service.impl.ActualRegistrationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActualRegistrationServiceTest {

    @Mock
    private ActualRegistrationRepository rep;

    @Spy
    private ActualRegistrationMapperImpl mapper;

    @InjectMocks
    private ActualRegistrationServiceImpl service;

    private ActualRegistrationEntity actualRegistrationEntity1;

    private ActualRegistrationEntity actualRegistrationEntity2;

    @BeforeEach
    void setUp() {
        actualRegistrationEntity1 = new ActualRegistrationEntity();
        actualRegistrationEntity2 = new ActualRegistrationEntity();
        actualRegistrationEntity1.setId(1L);
        actualRegistrationEntity1.setId(2L);
    }

    @Test
    void saveTest() {
        ActualRegistrationDto actualRegistrationDto = mapper.toDto(actualRegistrationEntity2);
        when(rep.save(any(ActualRegistrationEntity.class))).thenReturn(actualRegistrationEntity2);
        assertThat(service.save(actualRegistrationDto)).isEqualTo(actualRegistrationDto);
    }

    @Test
    void findAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<ActualRegistrationDto> listOfDto = List.of(mapper.toDto(actualRegistrationEntity1), mapper.toDto(actualRegistrationEntity2));
        when(rep.findAllById(any())).thenReturn(List.of(actualRegistrationEntity1, actualRegistrationEntity2));
        assertThat(service.findAllById(ids)).isEqualTo(listOfDto);
    }

    @Test
    void findAllByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        when(rep.findAllById(any())).thenReturn(List.of(actualRegistrationEntity1, actualRegistrationEntity2));
        try {
            service.findAllById(ids);
            fail();
        } catch (EntityNotFoundException ex) {
            assertTrue(true);
        }
    }

    @Test
    void findById() {
        when(rep.findById(2L)).thenReturn(Optional.of(actualRegistrationEntity2));
        assertThat(service.findById(2L)).isEqualTo(mapper.toDto(actualRegistrationEntity2));
    }

    @Test
    void getByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        when(rep.findById(3L)).thenReturn(Optional.empty());
        try {
            service.findById(3L);
            fail();
        } catch (EntityNotFoundException ex) {
            assertTrue(true);
        }
    }

    @Test
    void updateShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        when(rep.findById(3L)).thenReturn(Optional.empty());
        try {
            service.update(3L, mapper.toDto(actualRegistrationEntity1));
            fail();
        } catch (EntityNotFoundException ex) {
            assertTrue(true);
        }
    }
}

