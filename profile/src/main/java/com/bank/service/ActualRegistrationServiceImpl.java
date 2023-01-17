package com.bank.service;

import com.bank.dao.ActualRegistrationDao;
import com.bank.dto.ActualRegistrationDto;
import com.bank.mapper.ActualRegistrationMapper;
import com.bank.model.ActualRegistrationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActualRegistrationServiceImpl implements ActualRegistrationService {
    private final ActualRegistrationDao actualRegistrationDao;
    private final ActualRegistrationMapper actualRegistrationMapper;
    /**
     * @param id
     * @return
     */
    @Override
    public ActualRegistrationDto findById(Long id) {
        return actualRegistrationMapper.toDto(actualRegistrationDao.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    /**
     * @param ids
     * @return
     */
    @Override
    public List<ActualRegistrationDto> findAllById(List<Long> ids) {
        List<ActualRegistrationEntity> dtoList = actualRegistrationDao.findAllById(ids);
        if (dtoList.size() < ids.size()) {
            throw new EntityNotFoundException("one of ids doesn't exist " + ids);
        }
        return actualRegistrationMapper.toDtoList(dtoList);
    }

    /**
     * @return
     */
    @Override
    public List<ActualRegistrationDto> findAll() {
        return actualRegistrationMapper.toDtoList(actualRegistrationDao.findAll());
    }

    /**
     * @param actualRegistrationDto
     * @return
     */
    @Override
    public ActualRegistrationDto save(ActualRegistrationDto actualRegistrationDto) {
        actualRegistrationDao.save(actualRegistrationMapper.toEntity(actualRegistrationDto));
        return actualRegistrationDto;
    }
}
