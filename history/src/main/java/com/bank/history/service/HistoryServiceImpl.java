package com.bank.history.service;

import com.bank.history.converter.HistoryConverter;
import com.bank.history.mapper.HistoryMapper;
import com.bank.history.dto.HistoryDto;
import com.bank.history.entity.HistoryEntity;
import com.bank.history.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс сервисного слоя, реализующий {@link HistoryService}.
 */
@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    public static final String MESSAGE = "История не найдена с идентификатором: ";
    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;
    private final HistoryConverter historyConverter;

    /**
     * @param history {@link HistoryDto}.
     * @return {@link HistoryDto}.
     */
    @Override
    @Transactional
    public HistoryDto create(HistoryDto history) {
        HistoryEntity historyEntity = historyMapper.toEntity(history);
        historyEntity = historyRepository.save(historyEntity);
        return historyMapper.toDto(historyEntity);
    }

    /**
     * @param id технический идентификатор {@link HistoryDto}.
     * @return {@link HistoryDto}.
     */
    public HistoryDto findById(Long id) {
        return historyMapper.toDto(historyRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(MESSAGE + id))
        );
    }

    /**
     * @param id технический идентификатор {@link HistoryEntity}.
     * @param history {@link HistoryDto}.
     * @return лист {@link HistoryDto}.
     */
    @Override
    @Transactional
    public HistoryDto update(Long id, HistoryDto history) {
        final HistoryEntity historyEntity = historyRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(MESSAGE + id)
                );

        return historyMapper.toDto(historyMapper.mergeToEntity(history, historyEntity));
    }

    /**
     * @param ids лист технических идентификаторов {@link HistoryEntity}.
     * @return лист {@link HistoryDto}.
     */
    @Override
    public List<HistoryDto> findAllById(List<Long> ids) {
        // TODO в 74 строке напиши стрим по кодстайлу.
        final List<HistoryEntity> histories = ids.stream().map(id -> historyRepository.findById(id)
                //TODO логика с выбросом EntityNotFoundException дублируется, вынеси в приватный метод и переиспользуй.
                        .orElseThrow(
                                () -> new EntityNotFoundException(MESSAGE + id)))
                .collect(Collectors.toList());

        return historyConverter.toListDto(histories);
    }
}
