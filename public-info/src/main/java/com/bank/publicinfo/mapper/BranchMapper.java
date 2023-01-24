package com.bank.publicinfo.mapper;

import com.bank.publicinfo.dto.BranchDto;
import com.bank.publicinfo.entity.BranchEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * TODO Маппер для {@link BranchEntity} и {@link BranchDto}.
 * Маппер {@link BranchEntity} в {@link BranchDto} и обратно
 */
@Mapper(componentModel = "spring")
public interface BranchMapper {

    /**
     * @param branch {@link BranchEntity}
     * @return {@link BranchDto}
     */
    BranchDto toDto(BranchEntity branch);

    /**
     * @param branch {@link BranchDto}
     * @return {@link BranchEntity}
     */
    BranchEntity toEntity(BranchDto branch);

    /**
     * @param branches лист с {@link BranchEntity}
     * @return лист с {@link BranchDto}
     */
    List<BranchDto> toDtoList(List<BranchEntity> branches);

    /**
     * @param dto {@link BranchDto}
     * @param entity {@link BranchEntity}
     * @return {@link BranchEntity}
     */
    @Mapping(target = "id", source = "id", ignore = true)
    BranchEntity mergeToEntity(BranchDto dto, @MappingTarget BranchEntity entity);
}
