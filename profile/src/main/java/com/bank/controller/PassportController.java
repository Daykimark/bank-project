package com.bank.controller;

import com.bank.dto.PassportDto;
import com.bank.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private PassportService passportService;

    @PostMapping("/save")
    public ResponseEntity<PassportDto> save(@RequestBody PassportDto dto) {
        return ResponseEntity.ok(passportService.save(dto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PassportDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(passportService.findById(id));
    }

    @GetMapping("/getAllById")
    public ResponseEntity<List<PassportDto>> getAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(passportService.findAllById(ids));
    }

    @PutMapping("/update")
    public ResponseEntity<PassportDto> update(@RequestBody PassportDto dto) {
        return ResponseEntity.ok(passportService.save(dto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PassportDto>> getAll() {
        return ResponseEntity.ok(passportService.findAll());
    }
}
