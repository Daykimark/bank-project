package com.bank.controller;


import com.bank.dto.RegistrationDto;
import com.bank.service.RegistrationService;
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
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/save")
    public ResponseEntity<RegistrationDto> save(@RequestBody RegistrationDto dto) {
        return ResponseEntity.ok(registrationService.save(dto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RegistrationDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(registrationService.findById(id));
    }

    @GetMapping("/getAllById")
    public ResponseEntity<List<RegistrationDto>> getAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(registrationService.findAllById(ids));
    }

    @PutMapping("/update")
    public ResponseEntity<RegistrationDto> update(@RequestBody RegistrationDto dto) {
        return ResponseEntity.ok(registrationService.save(dto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<RegistrationDto>> getAll() {
        return ResponseEntity.ok(registrationService.findAll());
    }
}
