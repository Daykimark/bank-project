package com.bank.service;

import com.bank.dao.PassportDao;
import com.bank.dto.PassportDto;
import com.bank.mapper.PassportMapper;
import com.bank.model.PassportEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Реализация
 * @see com.bank.service.PassportService*/
@Service
@RequiredArgsConstructor
@Slf4j
public class PassportSerivceImpl implements PassportService {
    private final PassportDao passportDao;
    private final PassportMapper passportMapper;
    /**
     * @param id
     * @return
     */
    @Override
    public PassportDto findById(Long id) {
        return passportMapper.
                toDto(passportDao.
                        findById(id).
                        orElseThrow(() ->
                        {log.error("Сущности AccountDetailsId с айди " + id + " нет в БД");
                            return new EntityNotFoundException("Сущности AccountDetailsId с айди " + id + " нет в БД");}));
    }

    /**
     * @param ids
     * @return
     */
    @Override
    public List<PassportDto> findAllById(List<Long> ids) {
        final List<PassportEntity> dtoList = passportDao.findAllById(ids);
        if (dtoList.size() < ids.size()) {
            log.error("Одной или нескольких сущностей с такими айди не существует " + ids);
            throw new EntityNotFoundException("Одной или нескольких сущностей с такими айди не существует " + ids);
        }
        return passportMapper.toDtoList(dtoList);
    }

    /**
     * @return
     */
    @Override
    public List<PassportDto> findAll() {
        return passportMapper.toDtoList(passportDao.findAll());
    }

    /**
     * @param passportDto
     * @return
     */
    @Override
    public PassportDto save(PassportDto passportDto) {
        passportDao.save(passportMapper.toEntity(passportDto));
        return passportDto;
    }
}
