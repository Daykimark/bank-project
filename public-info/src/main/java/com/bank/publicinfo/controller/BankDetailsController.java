package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.BankDetailsDto;
import com.bank.publicinfo.service.BankDetailsService;
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
 * Контроллер для {@link BankDetailsDto}
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/bank/details")
// TODO добавь джавадоки для методов, без описание просто @param и @return.
public class BankDetailsController {
    // TODO bankDetailsService переименуй service.
    private final BankDetailsService bankDetailsService;

    @GetMapping("/{id}")
    private ResponseEntity<BankDetailsDto> readById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(bankDetailsService.findById(id));
    }

    @GetMapping("/read/all")
    private ResponseEntity<List<BankDetailsDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok().body(bankDetailsService.findAllById(ids));
    }

    @PostMapping("/create")
    private ResponseEntity<BankDetailsDto> create(@RequestBody BankDetailsDto bankDetails) {
        return ResponseEntity.ok().body(bankDetailsService.create(bankDetails));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<BankDetailsDto> update(@PathVariable("id") Long id,
                                                  @RequestBody BankDetailsDto bankDetails) {
        return ResponseEntity.ok().body(bankDetailsService.update(id, bankDetails));
    }
}

// TODO удали пустую строку.