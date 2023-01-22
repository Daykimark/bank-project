package com.bank.controller;

// TODO удали пустую строку.
import com.bank.dto.ProfileDto;
import com.bank.model.ProfileEntity;
import com.bank.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для {@link ProfileEntity}
 */
// TODO удали пустую строку.
@RestController
// TODO "/profile/" измени на "/profile".
@RequestMapping("/profile/")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService service;

    /**
     * @param id технический идентификатор {@link ProfileEntity}
     * TODO удали "сущность в виде ".
     * @return сущность в виде {@link ResponseEntity<ProfileDto>}
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<ProfileDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * TODO удали "- сущность для сохранения в виде ".
     * @param dto - сущность для сохранения в виде {@link ProfileDto}
     * TODO удали "сохраненная сущность в виде ".
     * @return сохраненная сущность в виде {@link ResponseEntity<ProfileDto>}
     */
    @PostMapping("/save")
    // TODO имя dto не информативно, переименуй в profile.
    public ResponseEntity<ProfileDto> save(@RequestBody ProfileDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * TODO удали "- сущность для обновления в виде ".
     * @param dto - сущность для обновления в виде {@link ProfileDto}
     * TODO удали "обновленная сущность в виде ".
     * @return обновленная сущность в виде {@link ResponseEntity<ProfileDto>}
     */
    @PutMapping("/update")
    // TODO имя dto не информативно, переименуй в profile.
    public ResponseEntity<ProfileDto> update(@RequestBody ProfileDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param ids лист технических идентификаторов {@link com.bank.model.ProfileEntity}
     * TODO "сущности в виде " удали, а {@link ResponseEntity<List<ProfileDto>>}
     *            надо изменить на {@link ResponseEntity} с листом {@link List<ProfileDto>}.
     * @return сущности в виде {@link ResponseEntity<List<ProfileDto>>}
     */
    // TODO "readAllById" измени на read/all
    @GetMapping("readAllById")
    public ResponseEntity<List<ProfileDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }
}
