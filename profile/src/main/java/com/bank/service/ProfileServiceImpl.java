package com.bank.service;

// TODO удали пустую строку.
import com.bank.dto.ProfileDto;
import com.bank.mapper.ProfileMapper;
import com.bank.model.ProfileEntity;
import com.bank.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Реализация {@link ProfileService}
 */
@Service
@RequiredArgsConstructor
// TODO те же замечания, что и AccountDetailsIdServiceImpl.
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
                        new EntityNotFoundException("Сущность Profile с айди " + id + " не найдена"))
        );
    }

    /**
     * @param ids лист технических идентификаторов {@link ProfileEntity}
     * @return {@link List<ProfileDto>}
     */
    @Override
    public List<ProfileDto> findAllById(List<Long> ids) {
        final List<ProfileEntity> profiles = repository.findAllById(ids);

        if (profiles.size() < ids.size()) {
            throw new EntityNotFoundException("Одной или нескольких сущностей" +
                    " Profile с такими айди не существует " + ids);
        }

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
                .orElseThrow(() -> new EntityNotFoundException("Сущности Profile с айди " + id + " не найдено")
                );
        return mapper.toDto(repository.save(mapper.updateEntity(profileEntity, profile)));
    }
}
