package com.bank.mapper;

import com.bank.dto.ProfileDto;
import com.bank.model.ProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * TODO Маппер переименуй в Mapper.
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
     * TODO после исправления предпоследнего todo исправь javadoc.
     * @param profileEntity {@link ProfileEntity}
     * @param profileDto {@link ProfileDto}
     * @return {@link ProfileEntity}
     */
    @Mappings({
            // TODO source удалить
            @Mapping(target = "id", source = "id", ignore = true),
            // TODO source удалить
            @Mapping(target = "passport.id", source = "passport.id", ignore = true),
            // TODO source удалить
            @Mapping(target = "passport.registration.id", source = "passport.registration.id", ignore = true),
            // TODO source удалить
            @Mapping(target = "actualRegistration.id", source = "actualRegistration.id", ignore = true)
    })
    // TODO updateEntity переименуй в mergeToEntity. profileEntity переименовать в profile
    ProfileEntity updateEntity(@MappingTarget ProfileEntity profileEntity, // TODO перенести 53 строку сюда.
                                        ProfileDto profileDto);
}
