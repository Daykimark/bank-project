package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.BranchDto;
import com.bank.publicinfo.entity.BranchEntity;

import java.util.List;

/**
 * Сервис для {@link BranchEntity} и {@link BranchDto}
 */
public interface BranchService {

    /**
     * TODO @param ids технические идентификаторы и ссылку на entity.
     * @param ids технический идентификатор
     * @return лист {@link BranchDto}
     */
    List<BranchDto> findAllById(List<Long> ids);

    /**
     * @param branch {@link BranchDto}
     * @return {@link BranchDto}
     */
    BranchDto create(BranchDto branch);

    /**
     * TODO @param id технический идентификатор и ссылку на entity.
     * @param id технический идентификатор
     * @param branch {@link BranchDto}
     * @return {@link BranchDto}
     */
    BranchDto update(Long id, BranchDto branch);

    /**
     * TODO @param id технический идентификатор и ссылку на entity.
     * @param id технический идентификатор
     * @return {@link BranchDto}
     */
    BranchDto findById(Long id);
}
