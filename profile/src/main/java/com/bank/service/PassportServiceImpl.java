package com.bank.service;

import com.bank.repository.PassportRepository;
import com.bank.dto.PassportDto;
import com.bank.mapper.PassportMapper;
import com.bank.model.PassportEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return mapper.toDto(repository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Сущности Passport с айди " + id + " нет в БД")));
    }

    /**
     * @param ids лист технических идентификаторов
     * @return {@link List<PassportDto>}
     */
    @Override
    public List<PassportDto> findAllById(List<Long> ids) {
        final List<PassportEntity> dtoList = repository.findAllById(ids);
        if (dtoList.size() < ids.size()) {
            throw new EntityNotFoundException("Одной или нескольких сущностей с такими айди не существует " + ids);
        }
        return mapper.toDtoList(dtoList);
    }

    /**
     * @param dto {@link PassportDto}
     * @return {@link PassportDto}
     */
    @Override
    public PassportDto save(PassportDto dto) {
        PassportEntity entity = repository.save(mapper.toEntity(dto));
        return mapper.toDto(entity);
    }
}
