package com.bank.service.impl;

import com.bank.dto.ProfileDto;
import com.bank.entity.ProfileEntity;
import com.bank.exceptionManager.ExceptionManager;
import com.bank.mapper.ProfileMapper;
import com.bank.repository.ProfileRepository;
import com.bank.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация {@link ProfileService}
 */
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;
    private final ProfileMapper mapper;

    /**
     * @param id технический идентификатор {@link ProfileEntity}
     * @return {@link ProfileDto}
     */
    @Override
    public ProfileDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() ->
                        ExceptionManager.getEntityNotFoundException("Сущности Profile с айди " + id + " не найдено"))
        );
    }

    /**
     * @param ids лист технических идентификаторов {@link ProfileEntity}
     * @return {@link List<ProfileDto>}
     */
    @Override
    public List<ProfileDto> findAllById(List<Long> ids) {
        final List<ProfileEntity> profiles = repository.findAllById(ids);

        ExceptionManager.getEntityNotFoundException(ids.size(), profiles.size(), "Одной или нескольких сущностей" +
                " Profile с такими айди не существует " + ids);

        return mapper.toDtoList(profiles);
    }

    /**
     * @param accountDetails {@link ProfileDto}
     * @return {@link ProfileDto}
     */
    @Override
    @Transactional
    public ProfileDto save(ProfileDto accountDetails) {
        final ProfileEntity profile = repository.save(mapper.toEntity(accountDetails));
        return mapper.toDto(profile);
    }

    /**
     * @param id технический идентификатор {@link ProfileEntity}
     * @param profile {@link ProfileDto}
     * @return {@link ProfileDto}
     */
    @Override
    @Transactional
    public ProfileDto update(Long id, ProfileDto profile) {
        final ProfileEntity profileEntity = repository.findById(id)
                .orElseThrow(() -> ExceptionManager.
                        getEntityNotFoundException("Сущности Рrofile с айди " + id + " не нaйдено")
                );
        return mapper.toDto(repository.save(mapper.mergeToEntity(profileEntity, profile)));
    }
}
