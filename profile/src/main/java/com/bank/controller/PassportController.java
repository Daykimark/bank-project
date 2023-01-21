package com.bank.controller;


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

@RestController
@RequestMapping("/passport/")
@RequiredArgsConstructor
public class PassportController {

    private final PassportService service;

    /**
     * @param id технический идентификатор {@link PassportEntity}
     * @return сущность в виде {@link ResponseEntity<PassportDto>}
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<PassportDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * @param dto - сущность для сохранения в виде {@link PassportDto}
     * @return сохраненная сущность в виде {@link ResponseEntity<PassportDto>}
     */
    @PostMapping("/save")
    public ResponseEntity<PassportDto> save(@RequestBody PassportDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param dto - сущность для обновления в виде {@link PassportDto}
     * @return обновленная сущность в виде {@link ResponseEntity<PassportDto>}
     */
    @PutMapping("/update")
    public ResponseEntity<PassportDto> update(@RequestBody PassportDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param ids лист технических идентификаторов {@link PassportDto}
     * @return сущности в виде {@link ResponseEntity<List<PassportDto>>}
     */
    @GetMapping("readAllById")
    public ResponseEntity<List<PassportDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }
}