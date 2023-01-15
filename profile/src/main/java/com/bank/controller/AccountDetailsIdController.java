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
public class AccountDetailsIdController {

    @Autowired
    private AccountDetailsIdService accountDetailsIdService;

    @Autowired
    private AccountDetailsIdMapper accountDetailsIdMapper;

    @GetMapping("/get")
    public ResponseEntity<AccountDetailsIdDto> get(@RequestParam(name = "ids") List<Long> ids) {
        AccountDetailsIdEntity o = new AccountDetailsIdEntity();
        return ResponseEntity.ok(accountDetailsIdService.save(accountDetailsIdMapper.toDto(o)));
    }

    @PostMapping("/save")
    public ResponseEntity<AccountDetailsIdDto> save(@RequestBody AccountDetailsIdDto dto) {
        return ResponseEntity.ok(accountDetailsIdService.save(dto));
    }
}
