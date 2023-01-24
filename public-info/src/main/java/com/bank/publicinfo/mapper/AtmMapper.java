package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.AtmDto;
import com.bank.publicinfo.entity.AtmEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * TODO Маппер для {@link AtmEntity} и {@link AtmDto}.
 * Маппер {@link AtmEntity} в {@link AtmDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface AtmMapper {

    /**
     * @param atm {@link AtmEntity}
     * @return {@link AtmDto}
     */
    AtmDto toDto(AtmEntity atm);

    /**
     * @param atm {@link AtmDto}
     * @return {@link AtmEntity}
     */
    AtmEntity toEntity(AtmDto atm);

    /**
     * @param atms лист с {@link AtmEntity}
     * @return лист с {@link AtmDto}
     */
    List<AtmDto> toDtoList(List<AtmEntity> atms);

    /**
     * @param atmDto    {@link AtmDto}
     * TODO atmEntity переименуй в atm.
     * @param atmEntity {@link AtmEntity}
     * @return {@link AtmEntity}
     */
    @Mappings({
            // TODO удалить "source = "id", "
            @Mapping(target = "id", source = "id", ignore = true),
            // TODO удалить "source = "branch.id" "
            @Mapping(target = "branch.id", source = "branch.id", ignore = true)
    })
    // TODO atmEntity переименуй в atm.
    AtmEntity mergeToEntity(AtmDto atmDto, @MappingTarget AtmEntity atmEntity);
}
