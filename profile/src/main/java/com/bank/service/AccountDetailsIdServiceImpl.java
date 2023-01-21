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
    private final AccountDetailsIdRepository repository;

    private final AccountDetailsIdMapper mapper;

    /**
     * @param id технический идентификатор {@link AccountDetailsIdEntity}
     * @return {@link AccountDetailsIdDto}
     */
    @Override
    public AccountDetailsIdDto findById(Long id) {
        return mapper.toDto(repository
                    .findById(id)
                    .orElseThrow(() ->
                                new EntityNotFoundException("Сущности AccountDetailsId с айди " + id + " нет в БД")));
    }

    /**
     * @param ids лист технических идентификаторов
     * @return {@link List<AccountDetailsIdDto>}
     */
    @Override
    public List<AccountDetailsIdDto> findAllById(List<Long> ids) {
        final List<AccountDetailsIdEntity> dtoList = repository.findAllById(ids);
        if (dtoList.size() < ids.size()) {
            throw new EntityNotFoundException("Одной или нескольких сущностей с такими айди не существует " + ids);
        }
        return mapper.toDtoList(dtoList);
    }

    /**
     * @param dto {@link AccountDetailsIdDto}
     * @return {@link AccountDetailsIdDto}
     */
    @Override
    public AccountDetailsIdDto save(AccountDetailsIdDto dto) {
        AccountDetailsIdEntity entity = repository.save(mapper.toEntity(dto));
        return mapper.toDto(entity);
    }
}
