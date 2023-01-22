package com.bank.service;

import com.bank.repository.AccountDetailsIdRepository;
import com.bank.dto.AccountDetailsIdDto;
import com.bank.mapper.AccountDetailsIdMapper;
import com.bank.model.AccountDetailsIdEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Реализация {@link AccountDetailsIdService}
 */
@Service
@RequiredArgsConstructor
public class AccountDetailsIdServiceImpl implements AccountDetailsIdService {
    // TODO туду удали и оставь пустую строку.
    private final AccountDetailsIdRepository repository;

    private final AccountDetailsIdMapper mapper;

    /**
     * @param id технический идентификатор {@link AccountDetailsIdEntity}
     * @return {@link AccountDetailsIdDto}
     */
    @Override
    public AccountDetailsIdDto findById(Long id) {
        // TODO привести к виду
        //  return mapper.toDto(repository.findById(id)
        //                    .orElseThrow(() ->
        //                        new EntityNotFoundException("Сущности AccountDetailsId с айди " + id + " нет в БД"))
        //  );
        return mapper.toDto(repository.findById(id)
                    .orElseThrow(() ->
                            // TODO измени " нет в БД" на " не найдена".
                                new EntityNotFoundException("Сущности AccountDetailsId с айди " + id + " нет в БД")));
    }

    /**
     * TODO в описание ids добавить ссылку AccountDetailsIdEntity.
     * @param ids лист технических идентификаторов
     * @return {@link List<AccountDetailsIdDto>}
     */
    @Override
    public List<AccountDetailsIdDto> findAllById(List<Long> ids) {
        // TODO переименуй dtoList в accountDetailsIds.
        final List<AccountDetailsIdEntity> dtoList = repository.findAllById(ids);
        // TODO туду удали и оставь пустую строку.
        if (dtoList.size() < ids.size()) {
            // TODO лучше указать имя сущности, а не просто "сущностей с такими айди не существует"
            throw new EntityNotFoundException("Одной или нескольких сущностей с такими айди не существует " + ids);
        }
        // TODO туду удали и оставь пустую строку.
        return mapper.toDtoList(dtoList);
    }

    /**
     * TODO dto переименуй в accountDetails
     * @param dto {@link AccountDetailsIdDto}
     * @return {@link AccountDetailsIdDto}
     */
    @Override
    // TODO где @Transactional. И dto переименуй в accountDetails.
    public AccountDetailsIdDto save(AccountDetailsIdDto dto) {
        // TODO тут если чекстайл прогонял AccountDetailsIdEntity должна быть final.
        //  И entity переименуй в accountDetailsId
        AccountDetailsIdEntity entity = repository.save(mapper.toEntity(dto));
        return mapper.toDto(entity);
    }

    // TODO а где Update?
}
