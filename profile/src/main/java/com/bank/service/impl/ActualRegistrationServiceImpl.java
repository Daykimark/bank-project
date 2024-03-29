package com.bank.service.impl;

import com.bank.dto.ActualRegistrationDto;
import com.bank.entity.ActualRegistrationEntity;
import com.bank.exceptionManager.ExceptionManager;
import com.bank.mapper.ActualRegistrationMapper;
import com.bank.repository.ActualRegistrationRepository;
import com.bank.service.ActualRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация {@link ActualRegistrationService}
 */
@Service
@RequiredArgsConstructor
public class ActualRegistrationServiceImpl implements ActualRegistrationService {

    private final ActualRegistrationRepository repository;
    private final ActualRegistrationMapper mapper;

    /**
     * @param id технический идентификатор {@link ActualRegistrationEntity}
     * @return {@link ActualRegistrationDto}
     */
    @Override
    public ActualRegistrationDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() ->
                        ExceptionManager
                                .getEntityNotFoundException(
                                        "Сущности ActualRegistration с айди " + id + " не найдено"))
        );

    }

    /**
     * @param ids лист технических идентификаторов {@link ActualRegistrationEntity}
     * @return {@link List<ActualRegistrationDto>}
     */
    @Override
    public List<ActualRegistrationDto> findAllById(List<Long> ids) {
        final List<ActualRegistrationEntity> actualRegistrations = repository.findAllById(ids);

        ExceptionManager.getEntityNotFoundException(ids.size(), actualRegistrations.size(),
                "Одной или нескольких сущностей ActualRegistration с такими айди не существует " + ids);

        return mapper.toDtoList(actualRegistrations);
    }

    /**
     * @param accountDetails {@link ActualRegistrationDto}
     * @return {@link ActualRegistrationDto}
     */
    @Override
    @Transactional
    public ActualRegistrationDto save(ActualRegistrationDto accountDetails) {
        final ActualRegistrationEntity actualRegistration = repository.save(mapper.toEntity(accountDetails));
        return mapper.toDto(actualRegistration);
    }

    /**
     * @param id технический идентификатор {@link ActualRegistrationEntity}
     * @param actualRegistration {@link ActualRegistrationDto}
     * @return {@link ActualRegistrationDto}
     */
    @Override
    @Transactional
    public ActualRegistrationDto update(Long id, ActualRegistrationDto actualRegistration) {
        final ActualRegistrationEntity actualRegistrationEntity = repository.findById(id)
                .orElseThrow(() ->
                        ExceptionManager
                                .getEntityNotFoundException(
                                        "Сущности АctualRegistration с айди " + id + " не нaйдено")
        );
        return mapper.toDto(repository.save(mapper.mergeToEntity(actualRegistrationEntity, actualRegistration)));
    }
}
