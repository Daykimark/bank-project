package com.bank.account.controller;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.entity.AccountDetailsEntity;
import com.bank.account.service.AccountDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

/**
 * Контроллер для {@link AccountDetailsEntity}
 */
// TODO удалить пустую строку.
@RestController
// TODO "/detail" переименовать в "/details".
@RequestMapping("/detail")
@RequiredArgsConstructor
public class AccountDetailsController {

    private final AccountDetailsService service;

    /**
     * @param id технический идентификатор {@link AccountDetailsEntity}
     * @return {@link ResponseEntity<AccountDetailsDto>}
     */
    @GetMapping( "/{id}")
    public AccountDetailsDto read(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    /**
     * TODO "accountDetail" переименовать в "accountDetails".
     * @param accountDetail - сущность для создания в виде {@link AccountDetailsDto}
     * @return {@link ResponseEntity<AccountDetailsDto>}
     */
    @PostMapping("/create")
    // TODO "accountDetail" переименовать в "accountDetails".
    public ResponseEntity<AccountDetailsDto> create(@RequestBody AccountDetailsDto accountDetail) {
        return ResponseEntity.ok(service.save(accountDetail));
    }

    /**
     * TODO "accountDetail" переименовать в "accountDetails".
     * @param accountDetail {@link AccountDetailsDto}
     * @param id технический идентификатор {@link AccountDetailsEntity}
     * @return {@link ResponseEntity<AccountDetailsDto>}
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<AccountDetailsDto> update(@PathVariable Long id,
                                                    // TODO "accountDetail" переименовать в "accountDetails".
                                                   @RequestBody AccountDetailsDto accountDetail) {
        return ResponseEntity.ok(service.update(id, accountDetail));
    }

    /**
     * @param ids лист технических идентификаторов {@link AccountDetailsEntity}
     * @return {@link ResponseEntity} c {@link List<AccountDetailsDto>}.
     */
    @GetMapping("read/all")
    public ResponseEntity<List<AccountDetailsDto>> readAll(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }
}
