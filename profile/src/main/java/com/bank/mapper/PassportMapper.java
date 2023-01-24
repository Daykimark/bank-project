package com.bank.mapper;

import com.bank.dto.PassportDto;
import com.bank.model.PassportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * TODO Маппер переименуй в Mapper.
 * Маппер для {@link PassportEntity} и {@link PassportDto}
 */
@Mapper(componentModel = "spring")
public interface PassportMapper {

    /**
     * @param passport {@link PassportDto}
     * @return {@link PassportEntity}
     */
    PassportEntity toEntity(PassportDto passport);

    /**
     * @param passport {@link PassportEntity}
     * @return {@link PassportDto}
     */
    PassportDto toDto(PassportEntity passport);

    /**
     * @param passports {@link List<PassportEntity>}
     * @return {@link List<PassportDto>}
     */
    List<PassportDto> toDtoList(List<PassportEntity> passports);

    /**
     * TODO после исправления предпоследнего todo исправь javadoc.
     * @param passportEntity {@link PassportEntity}
     * @param passportDto {@link PassportDto}
     * @return {@link PassportEntity}
     */
    @Mappings({
            // TODO source удалить
            @Mapping(target = "id", source = "id", ignore = true),
            // TODO source удалить
            @Mapping(target = "registration.id", source = "registration.id", ignore = true)
    })
    // TODO updateEntity переименуй в mergeToEntity. passportEntity переименовать в passport
    PassportEntity updateEntity(@MappingTarget PassportEntity passportEntity, // TODO перенести 48 строку сюда.
                                        PassportDto passportDto);
}
