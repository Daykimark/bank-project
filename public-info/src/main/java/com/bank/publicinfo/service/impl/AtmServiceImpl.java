package com.bank.publicinfo.service.impl;

import com.bank.publicinfo.dto.AtmDto;
import com.bank.publicinfo.entity.AtmEntity;
import com.bank.publicinfo.mapper.AtmMapper;
import com.bank.publicinfo.repository.AtmRepository;
import com.bank.publicinfo.service.AtmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация {@link AtmService}
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AtmServiceImpl implements AtmService {

    private final AtmRepository repository;
    private final AtmMapper mapper;

    /**
     * @param ids список технических идентификаторов {@link AtmEntity}
     * @return лист {@link AtmDto}
     */
    @Override
    public List<AtmDto> findAllById(List<Long> ids) {
        final List<AtmEntity> atms = repository.findAllById(ids);

        // TODO во всех реализациях этот if дублируется вынести его в отдельный класс компонент
        if (atms.size() < ids.size()) {
            final var entityNotFound = new EntityNotFoundException("Банкоматов с id= " + ids + "не существует");
            log.error(entityNotFound.getMessage(), entityNotFound);
            throw entityNotFound;
        }

        return mapper.toDtoList(atms);
    }

    /**
     * @param atmDto {@link AtmDto}
     * @return {@link AtmDto}
     */
    @Override
    @Transactional
    public AtmDto create(AtmDto atmDto) {
        final AtmEntity atm = repository.save(mapper.toEntity(atmDto));
        return mapper.toDto(atm);
    }

    /**
     * @param atm {@link AtmDto}
     * TODO удали "измененный ".
     * @return измененный {@link AtmDto}
     */
    @Override
    @Transactional
    public AtmDto update(Long id, AtmDto atm) {
        final AtmEntity entity = repository.findById(id)
                .orElseThrow(() -> {
                    // TODO данный функционал так же дублируется, подумай возможно 2 разными методами засунуть их в
                    //  в один класс-компонент
                    log.error("Переданный id не найден!");
                    return new EntityNotFoundException("Данного id не существует!");
                });
        final AtmEntity updatedAtm = mapper.mergeToEntity(atm, entity);
        return mapper.toDto(updatedAtm);
    }

    /**
     * TODO удали "банкомата" и добавь ссылку на entity.
     * @param id технический идентификатор банкомата
     * @return объект {@link AtmDto}
     */
    @Override
    public AtmDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                // TODO где-то есть логирование, где-то нет, либо выпили везде, либо добавь везде при выкидавынии
                //  exception'а.
                .orElseThrow(() -> new EntityNotFoundException("Банкомат с id = " + id + " не найден")));
    }
}
