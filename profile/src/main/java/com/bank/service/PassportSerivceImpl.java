package com.bank.service;

import com.bank.dao.PassportDao;
import com.bank.dto.PassportDto;
import com.bank.mapper.PassportMapper;
import com.bank.model.PassportEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PassportSerivceImpl implements PassportService{
    private final PassportDao passportDao;
    private final PassportMapper passportMapper;
    /**
     * @param id
     * @return
     */
    @Override
    public PassportDto findById(Long id) {
        return passportMapper.toDto(passportDao.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    /**
     * @param ids
     * @return
     */
    @Override
    public List<PassportDto> findAllById(List<Long> ids) {
        List<PassportEntity> dtoList = passportDao.findAllById(ids);
        if (dtoList.size() < ids.size()) {
            throw new EntityNotFoundException("one of ids doesn't exist " + ids);
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
