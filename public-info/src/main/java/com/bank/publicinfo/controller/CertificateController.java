package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.CertificateDto;
import com.bank.publicinfo.service.CertificateService;
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
 * Контроллер для {@link CertificateDto}
 */
// TODO удали пустую строку.
@RestController
@RequiredArgsConstructor
@RequestMapping("/certificate")
// TODO добавь джавадоки для методов, без описание просто @param и @return.
public class CertificateController {
    // TODO certificateService переименуй service.
    private final CertificateService certificateService;

    @GetMapping("/{id}")
    private ResponseEntity<CertificateDto> readById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(certificateService.findById(id));
    }

    @GetMapping("/read/all")
    private ResponseEntity<List<CertificateDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok().body(certificateService.findAllById(ids));
    }

    @PostMapping("/create")
    private ResponseEntity<CertificateDto> create(@RequestBody CertificateDto certificate) {
        return ResponseEntity.ok().body(certificateService.create(certificate));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<CertificateDto> update(@PathVariable("id") Long id,
                                                  @RequestBody CertificateDto certificate) {
        return ResponseEntity.ok().body(certificateService.update(id, certificate));
    }
}

// TODO удали пустую строку.