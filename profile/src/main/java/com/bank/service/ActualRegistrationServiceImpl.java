package com.bank.service;

import com.bank.dto.ActualRegistrationDto;
import com.bank.mapper.ActualRegistrationMapper;
import com.bank.model.ActualRegistrationEntity;
import com.bank.repository.ActualRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return mapper.toDto(repository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Сущности ActualRegistration с айди " + id + " нет в БД")));
    }

    /**
     * @param ids лист технических идентификаторов
     * @return {@link List<ActualRegistrationDto>}
     */
    @Override
    public List<ActualRegistrationDto> findAllById(List<Long> ids) {
        final List<ActualRegistrationEntity> dtoList = repository.findAllById(ids);
        if (dtoList.size() < ids.size()) {
            throw new EntityNotFoundException("Одной или нескольких сущностей с такими айди не существует " + ids);
        }
        return mapper.toDtoList(dtoList);
    }

    /**
     * @param dto {@link ActualRegistrationDto}
     * @return {@link ActualRegistrationDto}
     */
    @Override
    public ActualRegistrationDto save(ActualRegistrationDto dto) {
        ActualRegistrationEntity entity = repository.save(mapper.toEntity(dto));
        return mapper.toDto(entity);
    }
}
