package com.bank.service;

import com.bank.repository.RegistrationRepository;
import com.bank.dto.RegistrationDto;
import com.bank.mapper.RegistrationMapper;
import com.bank.model.RegistrationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return mapper.toDto(repository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Сущности Registration с айди " + id + " нет в БД")));
    }

    /**
     * @param ids лист технических идентификаторов
     * @return {@link List<RegistrationDto>}
     */
    @Override
    public List<RegistrationDto> findAllById(List<Long> ids) {
        final List<RegistrationEntity> dtoList = repository.findAllById(ids);
        if (dtoList.size() < ids.size()) {
            throw new EntityNotFoundException("Одной или нескольких сущностей с такими айди не существует " + ids);
        }
        return mapper.toDtoList(dtoList);
    }

    /**
     * @param accountDetailsIdDto {@link RegistrationDto}
     * @return {@link RegistrationDto}
     */
    @Override
    public RegistrationDto save(RegistrationDto accountDetailsIdDto) {
        RegistrationEntity entity = repository.save(mapper.toEntity(accountDetailsIdDto));
        return mapper.toDto(entity);
    }
}