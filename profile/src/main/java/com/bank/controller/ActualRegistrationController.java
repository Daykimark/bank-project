package com.bank.controller;


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

@RestController
@RequiredArgsConstructor
@RequestMapping("/actualRegistration/")
public class ActualRegistrationController {

    private final ActualRegistrationService service;

    /**
     * @param id технический идентификатор {@link ActualRegistrationEntity}
     * @return сущность в виде {@link ResponseEntity<ActualRegistrationDto>}
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<ActualRegistrationDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * @param dto - сущность для сохранения в виде {@link ActualRegistrationDto}
     * @return сохраненная сущность в виде {@link ResponseEntity<ActualRegistrationDto>}
     */
    @PostMapping("/save")
    public ResponseEntity<ActualRegistrationDto> save(@RequestBody ActualRegistrationDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param dto - сущность для обновления в виде {@link ActualRegistrationDto}
     * @return обновленная сущность в виде {@link ResponseEntity<ActualRegistrationDto>}
     */
    @PutMapping("/update")
    public ResponseEntity<ActualRegistrationDto> update(@RequestBody ActualRegistrationDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param ids лист технических идентификаторов {@link ActualRegistrationEntity}
     * @return сущности в виде {@link ResponseEntity<List<ActualRegistrationDto>>}
     */
    @GetMapping("readAllById")
    public ResponseEntity<List<ActualRegistrationDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }
}