package com.bank.controller;

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

@RestController
@RequestMapping("/registration/")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService service;

    /**
     * @param id технический идентификатор {@link RegistrationEntity}
     * @return сущность в виде {@link ResponseEntity<RegistrationDto>}
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<RegistrationDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * @param dto - сущность для сохранения в виде {@link RegistrationDto}
     * @return сохраненная сущность в виде {@link ResponseEntity<RegistrationDto>}
     */
    @PostMapping("/save")
    public ResponseEntity<RegistrationDto> save(@RequestBody RegistrationDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param dto - сущность для обновления в виде {@link RegistrationDto}
     * @return обновленная сущность в виде {@link ResponseEntity<RegistrationDto>}
     */
    @PutMapping("/update")
    public ResponseEntity<RegistrationDto> update(@RequestBody RegistrationDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param ids лист технических идентификаторов {@link RegistrationEntity}
     * @return сущности в виде {@link ResponseEntity<List<RegistrationDto>>}
     */
    @GetMapping("readAllById")
    public ResponseEntity<List<RegistrationDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }
}