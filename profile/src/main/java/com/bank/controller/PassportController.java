package com.bank.controller;

// TODO удали пустую строку.
import com.bank.dto.PassportDto;
import com.bank.model.PassportEntity;
import com.bank.service.PassportService;
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
 * Контроллер для {@link PassportEntity}
 */
// TODO удали пустую строку.
@RestController
// TODO "/passport/" измени на "/passport".
@RequestMapping("/passport/")
@RequiredArgsConstructor
public class PassportController {

    private final PassportService service;

    /**
     * @param id технический идентификатор {@link PassportEntity}
     * TODO удали "сущность в виде ".
     * @return сущность в виде {@link ResponseEntity<PassportDto>}
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<PassportDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * TODO удали "- сущность для сохранения в виде ".
     * @param dto - сущность для сохранения в виде {@link PassportDto}
     * TODO удали "сохраненная сущность в виде ".
     * @return сохраненная сущность в виде {@link ResponseEntity<PassportDto>}
     */
    @PostMapping("/save")
    // TODO имя dto не информативно, переименуй в passport.
    public ResponseEntity<PassportDto> save(@RequestBody PassportDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * TODO удали "- сущность для обновления в виде ".
     * @param dto - сущность для обновления в виде {@link PassportDto}
     * TODO удали "обновленная сущность в виде ".
     * @return обновленная сущность в виде {@link ResponseEntity<PassportDto>}
     */
    // TODO имя dto не информативно, переименуй в passport.
    @PutMapping("/update")
    public ResponseEntity<PassportDto> update(@RequestBody PassportDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param ids лист технических идентификаторов {@link PassportDto}
     * TODO "сущности в виде " удали, а {@link ResponseEntity<List<PassportDto>>}
     *            надо изменить на {@link ResponseEntity} с листом {@link List<PassportDto>}.
     * @return сущности в виде {@link ResponseEntity<List<PassportDto>>}
     */
    // TODO "readAllById" измени на read/all
    @GetMapping("readAllById")
    public ResponseEntity<List<PassportDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }
}