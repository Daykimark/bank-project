package com.bank.mapper;

import com.bank.dto.ProfileDto;
import com.bank.entity.ProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Mapper для {@link ProfileEntity} и {@link ProfileDto}
 */
@Mapper(componentModel = "spring")
public interface ProfileMapper {

    /**
     * @param profile {@link ProfileDto}
     * @return {@link ProfileEntity}
     */
    ProfileEntity toEntity(ProfileDto profile);

    /**
     * @param profile {@link ProfileEntity}
     * @return {@link ProfileDto}
     */
    ProfileDto toDto(ProfileEntity profile);

    /**
     * @param profiles {@link List<ProfileEntity>}
     * @return {@link List<ProfileDto>}
     */
    List<ProfileDto> toDtoList(List<ProfileEntity> profiles);

    /**
     * @param profile {@link ProfileEntity}
     * @param profileDto {@link ProfileDto}
     * @return {@link ProfileEntity}
     */
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "passport.id", ignore = true),
            @Mapping(target = "passport.registration.id", ignore = true),
            @Mapping(target = "actualRegistration.id", ignore = true)
    })
    ProfileEntity mergeToEntity(@MappingTarget ProfileEntity profile, ProfileDto profileDto);
}
