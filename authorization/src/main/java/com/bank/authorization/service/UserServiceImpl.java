package com.bank.authorization.service;

import com.bank.authorization.dto.UserDto;
import com.bank.authorization.mapper.UserMapper;
import com.bank.authorization.entity.UserEntity;
import com.bank.authorization.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Реализация {@link UserService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final static String MESSAGE = "Не был найден пользователь с ID ";

    private final UserRepository repository;
    private final UserMapper mapper;

    /**
     * @param id технический идентификатор {@link UserEntity}
     * @return {@link UserDto}
     */
    @Override
    public UserDto findById(Long id) {
        final UserEntity user = repository.findById(id)
                .orElseThrow(
                        () -> logAndException(id)
                );

        return mapper.toDTO(user);
    }

    /**
     * @param userDto {@link UserDto}
     * @return {@link UserDto}
     */
    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        final UserEntity user = mapper.toEntity(userDto);
        return mapper.toDTO(repository.save(user));
    }

    /**
     * @param id      технический идентификатор {@link UserEntity}
     * @param userDto {@link UserDto}
     * @return {@link UserDto}
     */
    @Override
    @Transactional
    public UserDto update(Long id, UserDto userDto) {
        final UserEntity user = repository.findById(id)
                .orElseThrow(
                        () -> logAndException(id)
                );

        final UserEntity updatedUser = repository.save(mapper.mergeToEntity(userDto, user));
        return mapper.toDTO(updatedUser);
    }

    /**
     * TODO Л измени на л
     * @param ids Лист технических идентификаторов {@link UserEntity}
     * @return {@link UserDto}
     */
    @Override
    public List<UserDto> findAllByIds(List<Long> ids) {
        // TODO entities переименуй в users.
        final List<UserEntity> entities = ids.stream()
                .map(id -> repository.findById(id)
                        .orElseThrow(
                                () -> logAndException(id))
                )
                .toList();

        return mapper.toDtoList(entities);
    }

    // TODO как будет готов общий рест эксепшен хэндлер, удали логирование, этим будем хэндлер заниматься.
    //  метод переименовать в getException.
    private EntityNotFoundException logAndException(Long id) {
        final var exception = new EntityNotFoundException(MESSAGE + id);
        log.error(exception.getMessage(), exception);
        return exception;
    }
}
