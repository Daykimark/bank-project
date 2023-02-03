package com.bank.service.impl;

import com.bank.dto.RegistrationDto;
import com.bank.exceptionManager.ExceptionManager;
import com.bank.mapper.RegistrationMapper;
import com.bank.entity.RegistrationEntity;
import com.bank.repository.RegistrationRepository;
import com.bank.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация {@link RegistrationService}
 */
@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationRepository repository;
    private final RegistrationMapper mapper;

    /**
     * @param id технический идентификатор {@link RegistrationEntity}
     * @return {@link RegistrationDto}
     */
    @Override
    public RegistrationDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() ->
                        ExceptionManager.
                                getEntityNotFoundException("Сущности Registration с айди " + id + " не найдено"))
        );
    }

    /**
     * @param ids лист технических идентификаторов {@link RegistrationEntity}
     * @return {@link List<RegistrationDto>}
     */
    @Override
    public List<RegistrationDto> findAllById(List<Long> ids) {
        final List<RegistrationEntity> registrations = repository.findAllById(ids);

        ExceptionManager.getEntityNotFoundException(ids.size(), registrations.size(),
                "Одной или нескольких сущностей Registration с такими айди не существует " + ids);

        return mapper.toDtoList(registrations);
    }

    /**
     * @param accountDetails {@link RegistrationDto}
     * @return {@link RegistrationDto}
     */
    @Override
    @Transactional
    public RegistrationDto save(RegistrationDto accountDetails) {
        final RegistrationEntity registration = repository.save(mapper.toEntity(accountDetails));
        return mapper.toDto(registration);
    }

    /**
     * @param id технический идентификатор {@link RegistrationEntity}
     * @param registration {@link RegistrationDto}
     * @return {@link RegistrationDto}
     */
    @Override
    @Transactional
    public RegistrationDto update(Long id, RegistrationDto registration) {
        final RegistrationEntity registrationEntity = repository.findById(id)
                .orElseThrow(() ->
                        ExceptionManager.
                                getEntityNotFoundException("Сущности Registration с айди " + id + " не найдено")
                );
        return mapper.toDto(repository.save(mapper.mergeToEntity(registrationEntity, registration)));
    }
}
