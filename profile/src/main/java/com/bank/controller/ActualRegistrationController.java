package com.bank.controller;

// TODO удали пустую строку.
import com.bank.dto.ActualRegistrationDto;
import com.bank.model.ActualRegistrationEntity;
import com.bank.service.ActualRegistrationService;
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
 * Контроллер для {@link ActualRegistrationEntity}
 */
// TODO удали пустую строку.
@RestController
@RequiredArgsConstructor
// TODO "/actualRegistration/" измени на "/actual/registration".
@RequestMapping("/actualRegistration/")
public class ActualRegistrationController {

    private final ActualRegistrationService service;

    /**
     * @param id технический идентификатор {@link ActualRegistrationEntity}
     * TODO удали "сущность в виде ".
     * @return сущность в виде {@link ResponseEntity<ActualRegistrationDto>}
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<ActualRegistrationDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * TODO удали "- сущность для сохранения в виде ".
     * @param dto - сущность для сохранения в виде {@link ActualRegistrationDto}
     * TODO удали "сохраненная сущность в виде ".
     * @return сохраненная сущность в виде {@link ResponseEntity<ActualRegistrationDto>}
     */
    @PostMapping("/save")
    // TODO имя dto не информативно, переименуй в actualRegistration.
    public ResponseEntity<ActualRegistrationDto> save(@RequestBody ActualRegistrationDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * TODO удали "- сущность для обновления в виде ".
     * @param dto - сущность для обновления в виде {@link ActualRegistrationDto}
     * TODO удали "обновленная сущность в виде ".
     * @return обновленная сущность в виде {@link ResponseEntity<ActualRegistrationDto>}
     */
    @PutMapping("/update")
    // TODO имя dto не информативно, переименуй в actualRegistration.
    public ResponseEntity<ActualRegistrationDto> update(@RequestBody ActualRegistrationDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param ids лист технических идентификаторов {@link ActualRegistrationEntity}
     * TODO "сущности в виде " удали, а {@link ResponseEntity<List<ActualRegistrationDto>>}
     *            надо изменить на {@link ResponseEntity} с листом {@link List<ActualRegistrationDto>}.
     * @return сущности в виде {@link ResponseEntity<List<ActualRegistrationDto>>}
     */
    // TODO "readAllById" измени на read/all
    @GetMapping("readAllById")
    public ResponseEntity<List<ActualRegistrationDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }
}