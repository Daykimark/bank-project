package com.bank.service;

import com.bank.dto.ProfileDto;

import java.util.List;

public interface ProfileService {
    ProfileDto findById(Long id);

    List<ProfileDto> findAllById(Iterable<Long> id);

    List<ProfileDto> findAll();

    ProfileDto save(ProfileDto profileDto);
}
