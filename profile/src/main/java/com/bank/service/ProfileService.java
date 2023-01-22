package com.bank.service;

import com.bank.dto.ProfileDto;
import com.bank.model.ProfileEntity;

import java.util.List;

/**
 * Сервис {@link ProfileEntity} {@link ProfileDto}
 */
// TODO удали пустую строку.
public interface ProfileService {

    /**
     * @param id технический идентификатор {@link ProfileEntity}
     * @return {@link ProfileDto}
     */
    ProfileDto findById(Long id);

    /**
     * TODO в описание ids добавить ссылку ProfileEntity.
     * @param ids лист технических идентификаторов
     * @return {@link List<ProfileDto>}
     */
    List<ProfileDto> findAllById(List<Long> ids);

    /**
     * TODO переименуй dto в profile.
     * @param dto {@link ProfileDto}
     * @return {@link ProfileDto}
     */
    // TODO переименуй dto в profile.
    ProfileDto save(ProfileDto dto);

    // TODO а где Update?
}
