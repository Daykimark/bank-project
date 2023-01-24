package com.bank.publicinfo.service.impl;

import com.bank.publicinfo.dto.BranchDto;
import com.bank.publicinfo.entity.BranchEntity;
import com.bank.publicinfo.mapper.BranchMapper;
import com.bank.publicinfo.repository.BranchRepository;
import com.bank.publicinfo.service.BranchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация {@link BranchService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    // TODO repositiry переименуй repository.
    private final BranchRepository repositiry;
    private final BranchMapper mapper;

    /**
     * @param ids список технических идентификаторов {@link BranchEntity}
     * @return лист {@link BranchDto}
     */
    @Override
    public List<BranchDto> findAllById(List<Long> ids) {
        final List<BranchEntity> branches = repositiry.findAllById(ids);

        if (branches.size() < ids.size()) {
            final var entityNotFound = new EntityNotFoundException("Отделений с id= " + ids + "не существует");
            log.error(entityNotFound.getMessage(), entityNotFound);
            throw entityNotFound;
        }

        return mapper.toDtoList(branches);
    }

    /**
     * @param branchDto {@link BranchDto}
     * @return {@link BranchDto}
     */
    @Override
    @Transactional
    public BranchDto create(BranchDto branchDto) {
        final BranchEntity branch = repositiry.save(mapper.toEntity(branchDto));
        return mapper.toDto(branch);
    }

    /**
     * @param branch {@link BranchDto}
     * TODO удали "измененный ".
     * @return измененный {@link BranchDto}
     */
    @Override
    @Transactional
    public BranchDto update(Long id, BranchDto branch) {
        final BranchEntity entity = repositiry.findById(id)
                .orElseThrow(() -> {
                    log.error("Переданный id не найден!");
                    return new EntityNotFoundException("Данного id не существует!");
                });
        final BranchEntity updatedBranch = mapper.mergeToEntity(branch, entity);
        return mapper.toDto(updatedBranch);
    }

    /**
     * TODO удали "отделения о банке" и добавь ссылку на entity.
     * @param id технический идентификатор отделения о банке
     * @return {@link BranchDto}
     */
    @Override
    public BranchDto findById(Long id) {
        return mapper.toDto(repositiry.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Отделение с id = " + id + " не найдено")));
    }
}
