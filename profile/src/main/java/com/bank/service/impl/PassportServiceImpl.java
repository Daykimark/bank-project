package com.bank.service.impl;

import com.bank.dto.PassportDto;
import com.bank.exceptionManager.ExceptionManager;
import com.bank.mapper.PassportMapper;
import com.bank.entity.PassportEntity;
import com.bank.repository.PassportRepository;
import com.bank.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация {@link PassportService}
 */
@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {

    private final PassportRepository repository;
    private final PassportMapper mapper;

    /**
     * @param id технический идентификатор {@link PassportEntity}
     * @return {@link PassportDto}
     */
    @Override
    public PassportDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() ->
                        ExceptionManager.getEntityNotFoundException("Сущности Profile с айди " + id + " не найдено"))
        );
    }

    /**
     * @param ids лист технических идентификаторов {@link PassportEntity}
     * @return {@link List<PassportDto>}
     */
    @Override
    public List<PassportDto> findAllById(List<Long> ids) {
        final List<PassportEntity> passports = repository.findAllById(ids);

        ExceptionManager.getEntityNotFoundException(ids.size(), passports.size(),
                "Одной или нескольких сущностей Passport с такими айди не существует " + ids);

        return mapper.toDtoList(passports);
    }

    /**
     * @param accountDetails {@link PassportDto}
     * @return {@link PassportDto}
     */
    @Override
    @Transactional
    public PassportDto save(PassportDto accountDetails) {
        final PassportEntity passport = repository.save(mapper.toEntity(accountDetails));
        return mapper.toDto(passport);
    }

    /**
     * @param id технический идентификатор {@link PassportEntity}
     * @param passport {@link PassportDto}
     * @return {@link PassportDto}
     */
    @Override
    @Transactional
    public PassportDto update(Long id, PassportDto passport) {
        final PassportEntity passportEntity = repository.findById(id)
                .orElseThrow(() ->
                        ExceptionManager.getEntityNotFoundException("Сущности Profile с айди " + id + " не найдено")
                );
        return mapper.toDto(repository.save(mapper.mergeToEntity(passportEntity, passport)));
    }
}
