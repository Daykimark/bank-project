package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.AtmDto;
import com.bank.publicinfo.service.AtmService;
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

// TODO удали пустую строку.
/**
 * Контроллер для {@link AtmDto}
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/atm")
// TODO добавь джавадоки для методов, без описание просто @param и @return.
public class AtmController {
    // TODO atmService переименуй service.
    private final AtmService atmService;

    @GetMapping("/{id}")
    private ResponseEntity<AtmDto> readById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(atmService.findById(id));
    }

    @GetMapping("/read/all")
    private ResponseEntity<List<AtmDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok().body(atmService.findAllById(ids));
    }

    @PostMapping("/create")
    private ResponseEntity<AtmDto> create(@RequestBody AtmDto atm) {
        return ResponseEntity.ok().body(atmService.create(atm));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<AtmDto> update(@PathVariable("id") Long id, @RequestBody AtmDto atm) {
        return ResponseEntity.ok().body(atmService.update(id, atm));
    }
}
