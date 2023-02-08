package com.bank.account.service;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.entity.AccountDetailsEntity;
import com.bank.account.mapper.AccountDetailsMapper;
import com.bank.account.repository.AccountDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация {@link AccountDetailsService}
 */
@Service
@RequiredArgsConstructor
public class AccountDetailsServiceImpl implements AccountDetailsService {

    private final AccountDetailsMapper mapper;
    private final AccountDetailsRepository repository;

    /**
     * @param id технический идентификатор {@link AccountDetailsEntity}
     * @return {@link AccountDetailsDto}
     */
    @Override
    public AccountDetailsDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> exceptionReturner(id))
        );
    }

    /**
     * @param ids лист технических идентификаторов {@link AccountDetailsEntity}
     * @return {@link List<AccountDetailsDto>}
     */
    @Override
    public List<AccountDetailsDto> findAllById(List<Long> ids) {

        final List<AccountDetailsEntity> accountDetailsList = ids.stream()
                .map(id -> repository.findById(id)
                        .orElseThrow(() -> exceptionReturner(id)))
                .toList();
        return mapper.toDtoList(accountDetailsList);
    }

    /**
     * @param accountDetailsDto {@link AccountDetailsDto}
     * @return {@link AccountDetailsDto}
     */
    @Override
    @Transactional
    public AccountDetailsDto save(AccountDetailsDto accountDetailsDto) {

        final AccountDetailsEntity accountDetails = repository.save(
                mapper.toEntity(accountDetailsDto)
        );

        return mapper.toDto(accountDetails);
    }

    /**
     * @param id технический идентификатор {@link AccountDetailsEntity}
     * @param accountDetailsDto {@link AccountDetailsDto}
     * @return {@link AccountDetailsDto}
     */
    @Override
    @Transactional
    public AccountDetailsDto update(Long id, AccountDetailsDto accountDetailsDto) {

        final AccountDetailsEntity accountDetails = repository.findById(id)
                .orElseThrow(() -> exceptionReturner(id));

        final AccountDetailsEntity updateAccountDetails = repository.save(
                mapper.mergeToEntity(accountDetails, accountDetailsDto)
        );

        return mapper.toDto(updateAccountDetails);
    }
    private EntityNotFoundException exceptionReturner(Long id) {
        return new EntityNotFoundException("Не найдена сущность AccountDetailsEntity с id " + id);
    }
}
