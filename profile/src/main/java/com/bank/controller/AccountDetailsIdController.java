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

@RestController
@RequestMapping("/accountDetails/")
@RequiredArgsConstructor
public class AccountDetailsIdController {

    private final AccountDetailsIdService service;

    /**
     * @param id технический идентификатор {@link com.bank.model.AccountDetailsIdEntity}
     * @return сущность в виде {@link ResponseEntity<AccountDetailsIdDto>}
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<AccountDetailsIdDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * @param dto - сущность для сохранения в виде {@link AccountDetailsIdDto}
     * @return сохраненная сущность в виде {@link ResponseEntity<AccountDetailsIdDto>}
     */
    @PostMapping("/save")
    public ResponseEntity<AccountDetailsIdDto> save(@RequestBody AccountDetailsIdDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param dto - сущность для обновления в виде {@link AccountDetailsIdDto}
     * @return обновленная сущность в виде {@link ResponseEntity<AccountDetailsIdDto>}
     */
    @PutMapping("/update")
    public ResponseEntity<AccountDetailsIdDto> update(@RequestBody AccountDetailsIdDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param ids лист технических идентификаторов {@link AccountDetailsIdEntity}
     * @return сущности в виде {@link ResponseEntity<List<AccountDetailsIdDto>>}
     */
    @GetMapping("readAllById")
    public ResponseEntity<List<AccountDetailsIdDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }
}
