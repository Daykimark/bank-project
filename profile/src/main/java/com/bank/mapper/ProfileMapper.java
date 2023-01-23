package com.bank.mapper;

import com.bank.dto.ProfileDto;
import com.bank.model.ProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Маппер для {@link ProfileEntity} и {@link ProfileDto}
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
     * @param profileEntity {@link ProfileEntity}
     * @param profileDto {@link ProfileDto}
     * @return {@link ProfileEntity}
     */
    @Mappings({
            @Mapping(target = "id", source = "id", ignore = true),
            @Mapping(target = "passport.id", source = "passport.id", ignore = true),
            @Mapping(target = "passport.registration.id", source = "passport.registration.id", ignore = true),
            @Mapping(target = "actualRegistration.id", source = "actualRegistration.id", ignore = true)
    })
    ProfileEntity updateEntity(@MappingTarget ProfileEntity profileEntity,
                                        ProfileDto profileDto);
}
