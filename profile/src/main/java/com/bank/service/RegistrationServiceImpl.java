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
    // TODO туду удали и оставь пустую строку.
    private final RegistrationRepository repository;

    private final RegistrationMapper mapper;

    /**
     * @param id технический идентификатор {@link RegistrationEntity}
     * @return {@link RegistrationDto}
     */
    @Override
    public RegistrationDto findById(Long id) {
        // TODO привести к виду
        //  return mapper.toDto(repository.findById(id)
        //                    .orElseThrow(() ->
        //                        new EntityNotFoundException("Сущности Registration с айди " + id + " нет в БД"))
        //  );
        return mapper.toDto(repository
                .findById(id)
                .orElseThrow(() ->
                        // TODO измени " нет в БД" на " не найдена".
                        new EntityNotFoundException("Сущности Registration с айди " + id + " нет в БД")));
    }

    /**
     * TODO в описание ids добавить ссылку RegistrationEntity.
     * @param ids лист технических идентификаторов
     * @return {@link List<RegistrationDto>}
     */
    @Override
    public List<RegistrationDto> findAllById(List<Long> ids) {
        // TODO переименуй dtoList в registrations.
        final List<RegistrationEntity> dtoList = repository.findAllById(ids);
        // TODO туду удали и оставь пустую строку.
        if (dtoList.size() < ids.size()) {
            // TODO лучше указать имя сущности, а не просто "сущностей с такими айди не существует"
            throw new EntityNotFoundException("Одной или нескольких сущностей с такими айди не существует " + ids);
        }
        // TODO туду удали и оставь пустую строку.
        return mapper.toDtoList(dtoList);
    }

    /**
     * @param accountDetailsIdDto {@link RegistrationDto}
     * @return {@link RegistrationDto}
     */
    @Override
    // TODO где @Transactional. И dto переименуй в registration.
    public RegistrationDto save(RegistrationDto accountDetailsIdDto) {
        // TODO тут если чекстайл прогонял RegistrationEntity должна быть final.
        //  И entity переименуй в registrationEntity.
        RegistrationEntity entity = repository.save(mapper.toEntity(accountDetailsIdDto));
        return mapper.toDto(entity);
    }

    // TODO а где Update?
}