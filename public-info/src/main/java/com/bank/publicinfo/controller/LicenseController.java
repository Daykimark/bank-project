package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.LicenseDto;
import com.bank.publicinfo.service.LicenseService;
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
 * Контроллер для {@link LicenseDto}
 */
// TODO удали пустую строку.
@RestController
@RequiredArgsConstructor
@RequestMapping("/license")
// TODO добавь джавадоки для методов, без описание просто @param и @return.
public class LicenseController {
    // TODO licenseService переименуй service.
    private final LicenseService licenseService;

    @GetMapping("/{id}")
    private ResponseEntity<LicenseDto> readById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(licenseService.findById(id));
    }

    @GetMapping("/read/all")
    private ResponseEntity<List<LicenseDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok().body(licenseService.findAllById(ids));
    }

    @PostMapping("/create")
    private ResponseEntity<LicenseDto> create(@RequestBody LicenseDto license) {
        return ResponseEntity.ok().body(licenseService.create(license));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<LicenseDto> update(@PathVariable("id") Long id,
                                              @RequestBody LicenseDto license) {
        return ResponseEntity.ok().body(licenseService.update(id, license));
    }
}

// TODO удали пустую строку.