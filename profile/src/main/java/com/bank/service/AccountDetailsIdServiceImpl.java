package com.bank.service;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.mapper.AccountDetailsIdMapper;
import com.bank.model.AccountDetailsIdEntity;
import com.bank.repository.AccountDetailsIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
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
        return mapper.toDto(repository.findById(id)
                    .orElseThrow(() ->
                                new EntityNotFoundException("Сущность AccountDetailsId с айди " + id + " не найдена"))
        );
    }

    /**
     * @param ids лист технических идентификаторов {@link AccountDetailsIdEntity}
     * @return {@link List<AccountDetailsIdDto>}
     */
    @Override
    public List<AccountDetailsIdDto> findAllById(List<Long> ids) {
        final List<AccountDetailsIdEntity> accountDetailsIds = repository.findAllById(ids);

        if (accountDetailsIds.size() < ids.size()) {
            throw new EntityNotFoundException("Одной или нескольких сущностей" +
                    " AccountDetailsId с такими айди не существует " + ids);
        }

        return mapper.toDtoList(accountDetailsIds);
    }

    /**
     * @param accountDetails {@link AccountDetailsIdDto}
     * @return {@link AccountDetailsIdDto}
     */
    @Override
    @Transactional
    public AccountDetailsIdDto save(AccountDetailsIdDto accountDetails) {
        final AccountDetailsIdEntity accountDetailsId = repository.save(mapper.toEntity(accountDetails));
        return mapper.toDto(accountDetailsId);
    }

    /**
     * @param id технический идентификатор {@link AccountDetailsIdEntity}
     * @param accountDetailsId {@link AccountDetailsIdDto}
     * @return {@link AccountDetailsIdDto}
     */
    @Override
    @Transactional
    public AccountDetailsIdDto update(Long id, AccountDetailsIdDto accountDetailsId) {
        final AccountDetailsIdEntity accountDetailsIdEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Сущности AccountDetailsId с айди " + id + " не найдено")
        );
        return mapper.toDto(repository.save(mapper.updateEntity(accountDetailsIdEntity, accountDetailsId)));
    }
}
