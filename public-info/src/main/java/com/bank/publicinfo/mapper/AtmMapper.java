package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.AtmDto;
import com.bank.publicinfo.entity.AtmEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Mapper {@link AtmEntity} и {@link AtmDto}
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
     * @param atm {@link AtmEntity}
     * @return {@link AtmEntity}
     */
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "branch.id", ignore = true)
    })
    AtmEntity mergeToEntity(AtmDto atmDto, @MappingTarget AtmEntity atm);
}
