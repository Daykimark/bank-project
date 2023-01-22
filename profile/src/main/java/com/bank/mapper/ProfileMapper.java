package com.bank.mapper;

import com.bank.dto.ProfileDto;
import com.bank.model.ProfileEntity;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * TODO Маппер для {@link ProfileEntity} и {@link ProfileDto}.
 * Маппер для {@link ProfileEntity} в {@link ProfileDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface ProfileMapper {

    /**
     * TODO переименуй "auditDto" в "profile".
     * @param auditDto {@link ProfileDto}
     * @return {@link ProfileEntity}
     */
    // TODO переименуй "auditDto" в "profile".
    ProfileEntity toEntity(ProfileDto auditDto);

    /**
     * TODO переименуй "auditEntity" в "profile".
     * @param auditEntity {@link ProfileEntity}
     * @return {@link ProfileDto}
     */
    // TODO переименуй "auditEntity" в "profile".
    ProfileDto toDto(ProfileEntity auditEntity);

    /**
     * TODO переименуй "entities" в "profiles".
     * @param entities {@link List<ProfileEntity>}
     * @return {@link List<ProfileDto>}
     */
    // TODO переименуй "entities" в "profiles".
    List<ProfileDto> toDtoList(List<ProfileEntity> entities);

    // TODO удали метод toEntityList, так как он не используется.
    /**
     * @param dto {@link List<ProfileDto>}
     * @return {@link List<ProfileEntity>}
     */
    List<ProfileEntity> toEntityList(List<ProfileDto> dto);
    // TODO удали пустую строку.
}
