package com.bank.history.converter;

import com.bank.history.dto.HistoryDto;
import com.bank.history.entity.HistoryEntity;
import com.bank.history.mapper.HistoryMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * лист {@link HistoryEntity} в лист {@link HistoryDto}.
 */
@Getter
@Setter
@Component
@RequiredArgsConstructor
public class HistoryConverter {

    private final HistoryMapper historyMapper;

    /**
     * @param histories лист {@link HistoryEntity}.
     * @return лист {@link HistoryDto}.
     */
    public List<HistoryDto> toListDto(List<HistoryEntity> histories) {
        return histories.stream()
                .map(historyMapper::toDto)
                .collect(Collectors.toList());
    }
}
