package com.bank.service;

import com.bank.dao.RegistrationDao;
import com.bank.dto.RegistrationDto;
import com.bank.mapper.RegistrationMapper;
import com.bank.model.RegistrationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService{
    private final RegistrationDao registrationDao;
    private final RegistrationMapper registrationMapper;
    /**
     * @param id
     * @return
     */
    @Override
    public RegistrationDto findById(Long id) {
        return registrationMapper.toDto(registrationDao.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    /**
     * @param ids
     * @return
     */
    @Override
    public List<RegistrationDto> findAllById(List<Long> ids) {
        List<RegistrationEntity> dtoList = registrationDao.findAllById(ids);
        if (dtoList.size() < ids.size()) {
            throw new EntityNotFoundException("one of ids doesn't exist " + ids);
        }
        return registrationMapper.toDtoList(dtoList);
    }

    /**
     * @return
     */
    @Override
    public List<RegistrationDto> findAll() {
        return registrationMapper.toDtoList(registrationDao.findAll());
    }

    /**
     * @param registrationDto
     * @return
     */
    @Override
    public RegistrationDto save(RegistrationDto registrationDto) {
        registrationDao.save(registrationMapper.toEntity(registrationDto));
        return registrationDto;
    }
}
