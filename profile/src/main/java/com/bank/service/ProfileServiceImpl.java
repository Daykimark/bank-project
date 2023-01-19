package com.bank.service;

import com.bank.dao.ProfileDao;
import com.bank.dto.ProfileDto;
import com.bank.mapper.ProfileMapper;
import com.bank.model.ProfileEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Реализация
 * @see com.bank.service.ProfileService*/
@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {
    private final ProfileDao profileDao;
    private final ProfileMapper profileMapper;
    /**
     * @param id
     * @return
     */
    @Override
    public ProfileDto findById(Long id) {
        return profileMapper.
                toDto(profileDao.
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
    public List<ProfileDto> findAllById(List<Long> ids) {
        final List<ProfileEntity> dtoList = profileDao.findAllById(ids);
        if (dtoList.size() < ids.size()) {
            log.error("Одной или нескольких сущностей с такими айди не существует " + ids);
            throw new EntityNotFoundException("Одной или нескольких сущностей с такими айди не существует " + ids);
        }
        return profileMapper.toDtoList(dtoList);
    }

    /**
     * @return
     */
    @Override
    public List<ProfileDto> findAll() {
        return profileMapper.toDtoList(profileDao.findAll());
    }

    /**
     * @param profileDto
     * @return
     */
    @Override
    public ProfileDto save(ProfileDto profileDto) {
        profileDao.save(profileMapper.toEntity(profileDto));
        return profileDto;
    }
}
