package com.bank.controller;

import com.bank.dto.ActualRegistrationDto;
import com.bank.service.ActualRegistrationService;
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
@RequestMapping("actualRegistration")
public class ActualRegistrationController {

    @Autowired
    private ActualRegistrationService actualRegistrationService;

    @PostMapping("/save")
    public ResponseEntity<ActualRegistrationDto> save(@RequestBody ActualRegistrationDto dto) {
        return ResponseEntity.ok(actualRegistrationService.save(dto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ActualRegistrationDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(actualRegistrationService.findById(id));
    }

    @GetMapping("/getAllById")
    public ResponseEntity<List<ActualRegistrationDto>> getAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(actualRegistrationService.findAllById(ids));
    }

    @PutMapping("/update")
    public ResponseEntity<ActualRegistrationDto> update(@RequestBody ActualRegistrationDto dto) {
        return ResponseEntity.ok(actualRegistrationService.save(dto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ActualRegistrationDto>> getAll() {
        return ResponseEntity.ok(actualRegistrationService.findAll());
    }
}
