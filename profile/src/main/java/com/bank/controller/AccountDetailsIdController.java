package com.bank.controller;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.model.AccountDetailsIdEntity;
import com.bank.service.AccountDetailsIdService;
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
 * Контроллер для {@link AccountDetailsIdEntity}
 */
// TODO удали пустую строку.
@RestController
// TODO "/accountDetails/" переименуй "/account/details".
@RequestMapping("/accountDetails/")
@RequiredArgsConstructor
public class AccountDetailsIdController {

    private final AccountDetailsIdService service;

    /**
     * TODO из {@link com.bank.model.AccountDetailsIdEntity} в {@link AccountDetailsIdEntity}.
     * @param id технический идентификатор {@link com.bank.model.AccountDetailsIdEntity}
     * TODO удали "сущность в виде ".
     * @return сущность в виде {@link ResponseEntity<AccountDetailsIdDto>}
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<AccountDetailsIdDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * TODO удали "- сущность для сохранения в виде ".
     * @param dto - сущность для сохранения в виде {@link AccountDetailsIdDto}
     * TODO удали "сохраненная сущность в виде ".
     * @return сохраненная сущность в виде {@link ResponseEntity<AccountDetailsIdDto>}
     */
    @PostMapping("/save")
    // TODO имя dto не информативно, переименуй в accountDetailsId.
    public ResponseEntity<AccountDetailsIdDto> save(@RequestBody AccountDetailsIdDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * TODO удали "- сущность для обновления в виде ".
     * @param dto - сущность для обновления в виде {@link AccountDetailsIdDto}
     * TODO удали "обновленная сущность в виде ".
     * @return обновленная сущность в виде {@link ResponseEntity<AccountDetailsIdDto>}
     */
    @PutMapping("/update")
    // TODO имя dto не информативно, переименуй в accountDetailsId.
    public ResponseEntity<AccountDetailsIdDto> update(@RequestBody AccountDetailsIdDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param ids лист технических идентификаторов {@link AccountDetailsIdEntity}
     * TODO "сущности в виде " удали, а {@link ResponseEntity<List<AccountDetailsIdDto>>}
     *            надо изменить на {@link ResponseEntity} с листом {@link List<AccountDetailsIdDto>}.
     * @return сущности в виде {@link ResponseEntity<List<AccountDetailsIdDto>>}
     */
    // TODO "readAllById" измени на read/all
    @GetMapping("readAllById")
    public ResponseEntity<List<AccountDetailsIdDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }
}
