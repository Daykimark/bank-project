package com.bank.controller;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.mapper.AccountDetailsIdMapper;
import com.bank.model.AccountDetailsIdEntity;
import com.bank.service.AccountDetailsIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accountId")
public class AccountDetailsIdController {

    @Autowired
    private AccountDetailsIdService accountDetailsIdService;

    @GetMapping("/get")
    public ResponseEntity<List<AccountDetailsIdDto>> get(@RequestParam(name = "ids") List<Long> ids) {
        return ResponseEntity.ok(accountDetailsIdService.findAllById(ids));
    }

    @PostMapping("/save")
    public ResponseEntity<AccountDetailsIdDto> save(@RequestBody AccountDetailsIdDto dto) {
        return ResponseEntity.ok(accountDetailsIdService.save(dto));
    }
}
