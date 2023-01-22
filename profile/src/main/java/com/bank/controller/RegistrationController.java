package com.bank.controller;

import com.bank.dto.ProfileDto;
import com.bank.dto.RegistrationDto;
import com.bank.model.RegistrationEntity;
import com.bank.service.RegistrationService;
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
 * Контроллер для {@link RegistrationEntity}
 */
// TODO удали пустую строку.
@RestController
// TODO "/registration/" измени на "/registration".
@RequestMapping("/registration/")
//TODO @RequestMapping("/registration") и @RequiredArgsConstructor поменять местами.
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService service;

    /**
     * @param id технический идентификатор {@link RegistrationEntity}
     * TODO удали "сущность в виде ".
     * @return сущность в виде {@link ResponseEntity<RegistrationDto>}
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<RegistrationDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * TODO удали "- сущность для сохранения в виде ".
     * @param dto - сущность для сохранения в виде {@link RegistrationDto}
     * TODO удали "сохраненная сущность в виде ".
     * @return сохраненная сущность в виде {@link ResponseEntity<RegistrationDto>}
     */
    @PostMapping("/save")
    // TODO имя dto не информативно, переименуй в registration.
    public ResponseEntity<RegistrationDto> save(@RequestBody RegistrationDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * TODO удали "- сущность для обновления в виде ".
     * @param dto - сущность для обновления в виде {@link RegistrationDto}
     * TODO удали "обновленная сущность в виде ".
     * @return обновленная сущность в виде {@link ResponseEntity<RegistrationDto>}
     */
    @PutMapping("/update")
    // TODO имя dto не информативно, переименуй в registration.
    public ResponseEntity<RegistrationDto> update(@RequestBody RegistrationDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param ids лист технических идентификаторов {@link RegistrationEntity}
     * TODO "сущности в виде " удали, а {@link ResponseEntity<List<RegistrationDto>>}
     *  надо изменить на {@link ResponseEntity} с листом {@link List<RegistrationDto>}.
     * @return сущности в виде {@link ResponseEntity<List<RegistrationDto>>}
     */
    // TODO "readAllById" измени на read/all
    @GetMapping("readAllById")
    public ResponseEntity<List<RegistrationDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }
}