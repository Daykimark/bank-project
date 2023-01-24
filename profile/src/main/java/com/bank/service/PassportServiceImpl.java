package com.bank.service;

import com.bank.dto.PassportDto;
import com.bank.mapper.PassportMapper;
import com.bank.model.PassportEntity;
import com.bank.repository.PassportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация {@link PassportService}
 */
// TODO те же замечания, что и AccountDetailsIdServiceImpl.
@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {
    // TODO удали и оставь пустую строку.
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
                        new EntityNotFoundException("Сущность Passport с айди " + id + " не найдена"))
        );
    }

    /**
     * @param ids лист технических идентификаторов {@link PassportEntity}
     * @return {@link List<PassportDto>}
     */
    @Override
    public List<PassportDto> findAllById(List<Long> ids) {
        final List<PassportEntity> passports = repository.findAllById(ids);

        if (passports.size() < ids.size()) {
            throw new EntityNotFoundException("Одной или нескольких сущностей" +
                    " Passport с такими айди не существует " + ids);
        }

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
                .orElseThrow(() -> new EntityNotFoundException("Сущности Passport с айди " + id + " не найдено")
                );
        return mapper.toDto(repository.save(mapper.updateEntity(passportEntity, passport)));
    }
}
