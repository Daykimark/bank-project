package com.bank.service;

import com.bank.dao.ProfileDao;
import com.bank.dto.ProfileDto;
import com.bank.mapper.ProfileMapper;
import com.bank.model.ProfileEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
     * @param ids
     * @return
     */
    @Override
    public List<ProfileDto> findAllById(List<Long> ids) {
        List<ProfileEntity> dtoList = profileDao.findAllById(ids);
        if (dtoList.size() < ids.size()) {
            throw new EntityNotFoundException("one of ids doesn't exist " + ids);
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
