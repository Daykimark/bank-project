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
    // TODO туду удали и оставь пустую строку.
    private final ProfileRepository repository;

    private final ProfileMapper mapper;

    /**
     * @param id технический идентификатор {@link ProfileEntity}
     * @return {@link ProfileDto}
     */
    @Override
    public ProfileDto findById(Long id) {
        // TODO привести к виду
        //  return mapper.toDto(repository.findById(id)
        //                    .orElseThrow(() ->
        //                        new EntityNotFoundException("Сущности Profile с айди " + id + " нет в БД"))
        //  );
        return mapper.toDto(repository
                .findById(id)
                .orElseThrow(() ->
                        // TODO измени " нет в БД" на " не найдена".
                        new EntityNotFoundException("Сущности Profile с айди " + id + " нет в БД")));
    }

    /**
     * TODO в описание ids добавить ссылку ProfileEntity.
     * @param ids лист технических идентификаторов
     * @return {@link List<ProfileDto>}
     */
    @Override
    public List<ProfileDto> findAllById(List<Long> ids) {
        // TODO переименуй dtoList в profiles.
        final List<ProfileEntity> dtoList = repository.findAllById(ids);
        // TODO туду удали и оставь пустую строку.
        if (dtoList.size() < ids.size()) {
            // TODO лучше указать имя сущности, а не просто "сущностей с такими айди не существует"
            throw new EntityNotFoundException("Одной или нескольких сущностей с такими айди не существует " + ids);
        }
        // TODO туду удали и оставь пустую строку.
        return mapper.toDtoList(dtoList);
    }

    /**
     * TODO dto переименуй в profile
     * @param dto {@link ProfileDto}
     * @return {@link ProfileDto}
     */
    @Override
    // TODO где @Transactional. И dto переименуй в profile.
    public ProfileDto save(ProfileDto dto) {
        // TODO тут если чекстайл прогонял ProfileEntity должна быть final.
        //  И profileEntity переименуй в accountDetailsId
        ProfileEntity entity = repository.save(mapper.toEntity(dto));
        return mapper.toDto(entity);
    }
}
