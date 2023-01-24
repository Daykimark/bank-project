package com.bank.authorization.service;

import com.bank.authorization.dto.UserDto;
import com.bank.authorization.entity.UserEntity;

import java.util.List;

/**
 * Сервис для {@link UserDto} и {@link UserEntity}
 */
public interface UserService {

    /**
     * @param id технический идентификатор {@link UserEntity}
     * @return {@link UserDto}
     */
    UserDto findById(Long id);

    /**
     * TODO userDto переименуй в user.
     * @param userDto {@link UserDto}
     * @return {@link UserDto}
     */
    // TODO userDto переименуй в user.
    UserDto save(UserDto userDto);

    /**
     * @param id технический идентификатор {@link UserEntity}
     * TODO userDto переименуй в user.
     * @param userDto {@link UserDto}
     * @return {@link UserDto}
     */
    UserDto update(Long id, UserDto userDto);

    /**
     * TODO Л измени на л.
     * @param ids Лист технических идентификаторов {@link UserEntity}
     * @return {@link UserDto}
     */
    List<UserDto> findAllByIds(List<Long> ids);
}
