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
@RequiredArgsConstructor
@RequestMapping("/passport")
public class PassportController {

    private final PassportService service;

    /**
     * @param id технический идентификатор {@link PassportEntity}
     * @return {@link ResponseEntity<PassportDto>}
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<PassportDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * @param passport {@link PassportDto}
     * @return {@link ResponseEntity<PassportDto>}
     */
    //TODO save переименуй в create.
    @PostMapping("/save")
    //TODO save переименуй в create.
    public ResponseEntity<PassportDto> save(@RequestBody PassportDto passport) {
        return ResponseEntity.ok(service.save(passport));
    }

    /**
     * @param passport {@link PassportDto}
     * @param id технический идентификатор {@link PassportEntity}
     * @return {@link ResponseEntity<PassportDto>}
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<PassportDto> update(@PathVariable Long id, @RequestBody PassportDto passport) {
        return ResponseEntity.ok(service.update(id, passport));
    }

    /**
     * @param ids лист технических идентификаторов {@link PassportDto}
     * TODO удали "листом".
     * @return {@link ResponseEntity} с листом {@link List<PassportDto>}
     */
    @GetMapping("read/all")
    public ResponseEntity<List<PassportDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }
}
