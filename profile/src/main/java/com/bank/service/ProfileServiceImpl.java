package com.bank.service;

import com.bank.repository.ProfileRepository;
import com.bank.dto.ProfileDto;
import com.bank.mapper.ProfileMapper;
import com.bank.model.ProfileEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return mapper.toDto(repository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Сущности Profile с айди " + id + " нет в БД")));
    }

    /**
     * @param ids лист технических идентификаторов
     * @return {@link List<ProfileDto>}
     */
    @Override
    public List<ProfileDto> findAllById(List<Long> ids) {
        final List<ProfileEntity> dtoList = repository.findAllById(ids);
        if (dtoList.size() < ids.size()) {
            throw new EntityNotFoundException("Одной или нескольких сущностей с такими айди не существует " + ids);
        }
        return mapper.toDtoList(dtoList);
    }

    /**
     * @param dto {@link ProfileDto}
     * @return {@link ProfileDto}
     */
    @Override
    public ProfileDto save(ProfileDto dto) {
        ProfileEntity entity = repository.save(mapper.toEntity(dto));
        return mapper.toDto(entity);
    }
}
