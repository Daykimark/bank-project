package com.bank.controller;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.service.AccountDetailsIdService;
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
@RequestMapping("/accountId")
public class AccountDetailsIdController {

    @Autowired
    private AccountDetailsIdService accountDetailsIdService;

    @GetMapping("/get/{id}")
    public ResponseEntity<AccountDetailsIdDto> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(accountDetailsIdService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<AccountDetailsIdDto> save(@RequestBody AccountDetailsIdDto dto) {
        return ResponseEntity.ok(accountDetailsIdService.save(dto));
    }

    @PutMapping("/update")
    public ResponseEntity<AccountDetailsIdDto> update(@RequestBody AccountDetailsIdDto dto) {
        return ResponseEntity.ok(accountDetailsIdService.save(dto));
    }

    @GetMapping("/getAllById")
    public ResponseEntity<List<AccountDetailsIdDto>> getAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(accountDetailsIdService.findAllById(ids));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<AccountDetailsIdDto>> getAll() {
        return ResponseEntity.ok(accountDetailsIdService.findAll());
    }
}
