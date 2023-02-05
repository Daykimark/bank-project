package com.bank.service;

import com.bank.dto.RegistrationDto;
import com.bank.entity.RegistrationEntity;
import com.bank.mapper.RegistrationMapperImpl;
import com.bank.repository.RegistrationRepository;
import com.bank.service.impl.RegistrationServiceImpl;
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
import static org.testng.Assert.assertThrows;

@ExtendWith(MockitoExtension.class)
public class RegistrationServiceTest {

    @Mock
    private RegistrationRepository rep;

    @Spy
    private RegistrationMapperImpl mapper;

    @InjectMocks
    private RegistrationServiceImpl service;

    private RegistrationEntity registrationEntity1;

    private RegistrationEntity registrationEntity2;

    @BeforeEach
    void setUp() {
        registrationEntity1 = new RegistrationEntity();
        registrationEntity2 = new RegistrationEntity();
        registrationEntity1.setId(1L);
        registrationEntity1.setId(2L);
    }

    @Test
    void saveTest() {
        RegistrationDto registrationDto = mapper.toDto(registrationEntity2);
        when(rep.save(any(RegistrationEntity.class))).thenReturn(registrationEntity2);
        assertThat(service.save(registrationDto)).isEqualTo(registrationDto);
    }

    @Test
    void findAllByIdTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<RegistrationDto> listOfDto = List.of(mapper.toDto(registrationEntity1), mapper.toDto(registrationEntity2));
        when(rep.findAllById(any())).thenReturn(List.of(registrationEntity1, registrationEntity2));
        assertThat(service.findAllById(ids)).isEqualTo(listOfDto);
    }

    @Test
    void findAllByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        when(rep.findAllById(any())).thenReturn(List.of(registrationEntity1, registrationEntity2));
        assertThrows(EntityNotFoundException.class, () -> service.findAllById(ids));
    }

    @Test
    void findById() {
        when(rep.findById(2L)).thenReturn(Optional.of(registrationEntity2));
        assertThat(service.findById(2L)).isEqualTo(mapper.toDto(registrationEntity2));
    }

    @Test
    void getByIdShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        when(rep.findById(3L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> service.findById(3L));
    }

    @Test
    void updateShouldThrowExceptionIfOneOfIdsDoesntExistTest() {
        when(rep.findById(3L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> service.update(3L, mapper.toDto(registrationEntity1)));
    }
}
