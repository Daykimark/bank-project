package com.bank.mapper;

import com.bank.dto.ProfileDto;
import com.bank.model.ProfileEntity;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * Маппер для {@link ProfileEntity} в {@link ProfileDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface ProfileMapper {

    /**
     * @param auditDto {@link ProfileDto}
     * @return {@link ProfileEntity}
     */
    ProfileEntity toEntity(ProfileDto auditDto);

    /**
     * @param auditEntity {@link ProfileEntity}
     * @return {@link ProfileDto}
     */
    ProfileDto toDto(ProfileEntity auditEntity);

    /**
     * @param entities {@link List<ProfileEntity>}
     * @return {@link List<ProfileDto>}
     */
    List<ProfileDto> toDtoList(List<ProfileEntity> entities);

    /**
     * @param dto {@link List<ProfileDto>}
     * @return {@link List<ProfileEntity>}
     */
    List<ProfileEntity> toEntityList(List<ProfileDto> dto);

}
