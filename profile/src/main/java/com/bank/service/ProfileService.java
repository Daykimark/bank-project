package com.bank.service;

import com.bank.dto.ProfileDto;

import java.util.List;

public interface ProfileService {
    ProfileDto findById(Long id);

    List<ProfileDto> findAllById(List<Long> ids);

    List<ProfileDto> findAll();

    ProfileDto save(ProfileDto profileDto);
}
