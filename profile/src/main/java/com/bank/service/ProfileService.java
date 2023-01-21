package com.bank.service;

import com.bank.dto.ProfileDto;
import com.bank.model.ProfileEntity;

import java.util.List;

/**
 * Сервис {@link ProfileEntity} {@link ProfileDto}
 */

public interface ProfileService {

    /**
     * @param id технический идентификатор {@link ProfileEntity}
     * @return {@link ProfileDto}
     */
    ProfileDto findById(Long id);

    /**
     * @param ids лист технических идентификаторов
     * @return {@link List<ProfileDto>}
     */
    List<ProfileDto> findAllById(List<Long> ids);

    /**
     * @param dto {@link ProfileDto}
     * @return {@link ProfileDto}
     */
    ProfileDto save(ProfileDto dto);
}
