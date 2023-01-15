package com.bank.mapper;

import com.bank.dto.ProfileDto;
import com.bank.model.ProfileEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProfileMapper {
    ProfileEntity toEntity(ProfileDto profileDto);

    ProfileDto toDto(ProfileEntity profileEntity);

    List<ProfileDto> toDtoList(List<ProfileEntity> entities);

    List<ProfileEntity> toEntityList(List<ProfileDto> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProfileEntity partialUpdate(ProfileDto profileDto, @MappingTarget ProfileEntity profileEntity);

    @AfterMapping
    default void linkAccountDetails(@MappingTarget ProfileEntity profileEntity) {
        profileEntity.getAccountDetails().forEach(accountDetail -> accountDetail.setProfile(profileEntity));
    }
}