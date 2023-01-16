package com.bank.service;

import com.bank.dao.ActualRegistrationDao;
import com.bank.dao.ProfileDao;
import com.bank.dto.ActualRegistrationDto;
import com.bank.dto.ProfileDto;
import com.bank.mapper.ActualRegistrationMapper;
import com.bank.mapper.ProfileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService{
    private final ProfileDao profileDao;
    private final ProfileMapper profileMapper;
    /**
     * @param id
     * @return
     */
    @Override
    public ProfileDto findById(Long id) {
        return profileMapper.toDto(profileDao.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<ProfileDto> findAllById(Iterable<Long> id) {
        return profileMapper.toDtoList(new ArrayList<>(profileDao.findAllById(id)));
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
        int x = 5;
        profileDao.save(profileMapper.toEntity(profileDto));
        return profileDto;
    }
}
