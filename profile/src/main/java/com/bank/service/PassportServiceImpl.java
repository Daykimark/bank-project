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
    // TODO туду удали и оставь пустую строку.
    private final PassportRepository repository;

    private final PassportMapper mapper;

    /**
     * @param id технический идентификатор {@link PassportEntity}
     * @return {@link PassportDto}
     */
    @Override
    public PassportDto findById(Long id) {
        // TODO привести к виду
        //  return mapper.toDto(repository.findById(id)
        //                    .orElseThrow(() ->
        //                        new EntityNotFoundException("Сущности Passport с айди " + id + " нет в БД"))
        //  );
        return mapper.toDto(repository
                .findById(id)
                .orElseThrow(() ->
                        // TODO измени " нет в БД" на " не найдена".
                        new EntityNotFoundException("Сущности Passport с айди " + id + " нет в БД")));
    }

    /**
     * TODO в описание ids добавить ссылку PassportEntity.
     * @param ids лист технических идентификаторов
     * @return {@link List<PassportDto>}
     */
    @Override
    public List<PassportDto> findAllById(List<Long> ids) {
        // TODO переименуй dtoList в passports.
        final List<PassportEntity> dtoList = repository.findAllById(ids);
        // TODO туду удали и оставь пустую строку.
        if (dtoList.size() < ids.size()) {
            // TODO лучше указать имя сущности, а не просто "сущностей с такими айди не существует"
            throw new EntityNotFoundException("Одной или нескольких сущностей с такими айди не существует " + ids);
        }
        // TODO туду удали и оставь пустую строку.
        return mapper.toDtoList(dtoList);
    }

    /**
     * @param dto {@link PassportDto}
     * @return {@link PassportDto}
     */
    @Override
    // TODO где @Transactional. И dto переименуй в passport.
    public PassportDto save(PassportDto dto) {
        // TODO entity переименуй в passportEntity.
        PassportEntity entity = repository.save(mapper.toEntity(dto));
        return mapper.toDto(entity);
    }

    // TODO а где Update?
}
