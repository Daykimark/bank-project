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
    // TODO туду удали и оставь пустую строку.
    private final ActualRegistrationRepository repository;

    private final ActualRegistrationMapper mapper;

    /**
     * @param id технический идентификатор {@link ActualRegistrationEntity}
     * @return {@link ActualRegistrationDto}
     */
    @Override
    public ActualRegistrationDto findById(Long id) {
        // TODO привести к виду
        //  return mapper.toDto(repository.findById(id)
        //                    .orElseThrow(() ->
        //                        new EntityNotFoundException("Сущности ActualRegistration с айди " + id + " нет в БД"))
        //  );
        return mapper.toDto(repository
                .findById(id)
                .orElseThrow(() ->
                        // TODO измени " нет в БД" на " не найдена".
                        new EntityNotFoundException("Сущности ActualRegistration с айди " + id + " нет в БД")));
    }

    /**
     * TODO в описание ids добавить ссылку ActualRegistrationEntity.
     * @param ids лист технических идентификаторов
     * @return {@link List<ActualRegistrationDto>}
     */
    @Override
    public List<ActualRegistrationDto> findAllById(List<Long> ids) {
        // TODO переименуй dtoList в actualRegistrations.
        final List<ActualRegistrationEntity> dtoList = repository.findAllById(ids);
        // TODO туду удали и оставь пустую строку.
        if (dtoList.size() < ids.size()) {
            // TODO лучше указать имя сущности, а не просто "сущностей с такими айди не существует"
            throw new EntityNotFoundException("Одной или нескольких сущностей с такими айди не существует " + ids);
        }
        // TODO туду удали и оставь пустую строку.
        return mapper.toDtoList(dtoList);
    }

    /**
     * @param dto {@link ActualRegistrationDto}
     * @return {@link ActualRegistrationDto}
     */
    @Override
    // TODO где @Transactional. И dto переименуй в registration.
    public ActualRegistrationDto save(ActualRegistrationDto dto) {
        // TODO тут если чекстайл прогонял AccountDetailsIdEntity должна быть final.
        //  И entity переименуй в actualRegistration
        ActualRegistrationEntity entity = repository.save(mapper.toEntity(dto));
        return mapper.toDto(entity);
    }

    // TODO а где Update?
}
