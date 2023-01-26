package com.bank.account.service;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.entity.AccountDetailsEntity;
import com.bank.account.mapper.AccountDetailsMapper;
import com.bank.account.repository.AccountDetailRepository;
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

    private final static String EXCEPTIONS_MESSAGE = "Не найдена сущность AccountDetailsEntity с id ";
    // TODO удалить и оставь пустую строку.
    private final AccountDetailRepository repository;
    private final AccountDetailsMapper mapper;

    /**
     * TODO удали javadoc для приватного метода, так как приватные методы не описываются джавадоками.
     * возвращает {@link EntityNotFoundException}.
     * Сообщение об ошибке
     */
    // TODO так же метод перенеси в самый конец класса. И String message убери, так как ты всегда одно и тоже передаешь.
    private EntityNotFoundException exceptionThrower(String message, Long id) {
        return new EntityNotFoundException(message + id);
    }
    /**
     * @param id технический идентификатор {@link AccountDetailsEntity}
     * @return {@link AccountDetailsDto}
     */
    @Override
    public AccountDetailsDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> exceptionThrower(EXCEPTIONS_MESSAGE, id))
        );
    }

    /**
     * TODO в строку снизу указать ссылку на энтити.
     * @param ids лист технических идентификаторов
     * @return {@link List<AccountDetailsDto>}
     */
    @Override
    public List<AccountDetailsDto> findAllById(List<Long> ids) {

        final List<AccountDetailsEntity> accountDetailsList = ids.stream()
                .map(id -> repository.findById(id)
                        .orElseThrow(() -> exceptionThrower(EXCEPTIONS_MESSAGE, id)))
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
        // TODO удалить и оставь пустую строку.
        final AccountDetailsEntity accountDetails = repository.save(
                mapper.toEntity(accountDetailsDto)
        );
        // TODO удалить и оставь пустую строку.
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
                .orElseThrow(() -> exceptionThrower(EXCEPTIONS_MESSAGE, id));
        // TODO удалить и оставь пустую строку.
        final AccountDetailsEntity updateAccountDetails = repository.save(
                mapper.mergeToEntity(accountDetails, accountDetailsDto)
        );
        // TODO удалить и оставь пустую строку.
        return mapper.toDto(updateAccountDetails);
    }
}
