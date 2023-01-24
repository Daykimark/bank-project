package com.bank.authorization.mapper;

import com.bank.authorization.dto.UserDto;
import com.bank.authorization.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Маппер для {@link UserEntity} и {@link UserDto}
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * TODO userEntity переименуй в user.
     * @param userEntity {@link UserEntity}
     * @return {@link UserDto}
     */
    // TODO userEntity переименуй в user.
    UserDto toDTO(UserEntity userEntity);

    /**
     * TODO userDto переименуй в user.
     * @param userDto {@link UserDto}
     * @return {@link UserEntity}
     */
    @Mapping(target = "id", ignore = true)
    // TODO userDto переименуй в user.
    UserEntity toEntity(UserDto userDto);

    /**
     * TODO userEntityList переименуй в users.
     * @param userEntityList лист сущностей {@link UserEntity}
     * TODO удали "dto ".
     * @return лист dto {@link UserDto}
     */
    // TODO userEntityList переименуй в users.
    List<UserDto> toDtoList(List<UserEntity> userEntityList);

    /**
     * @param userDto {@link UserDto}
     * TODO userEntity переименуй в user.
     * @param userEntity {@link UserEntity}
     * @return {@link UserEntity}
     */
    @Mapping(target = "id", ignore = true)
    // TODO userEntity переименуй в user.
    UserEntity mergeToEntity(UserDto userDto, @MappingTarget UserEntity userEntity);
}
