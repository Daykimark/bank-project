package com.bank.antifraud.controller;

import com.bank.antifraud.dto.SuspiciousAccountTransferDto;
import com.bank.antifraud.entity.SuspiciousAccountTransferEntity;
import com.bank.antifraud.service.SuspiciousAccountTransferService;
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
 * Контроллер для {@link SuspiciousAccountTransferDto}
 */
@RestController
// TODO @RequestMapping("/suspicious/account/transfer") и @RequiredArgsConstructor поменять местами.
@RequestMapping("/suspicious/account/transfer")
@RequiredArgsConstructor
public class SuspiciousAccountTransferController {
    // TODO suspiciousAccountTransferService переименуй в service.
    private final SuspiciousAccountTransferService suspiciousAccountTransferService;

    /**
     * @param id технический идентификатор {@link SuspiciousAccountTransferEntity}
     * @return {@link ResponseEntity} {@link SuspiciousAccountTransferDto}
     */
    @GetMapping("/{id}")
    // TODO getById переименуй в read.
    public ResponseEntity<SuspiciousAccountTransferDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(suspiciousAccountTransferService.findById(id));
    }

    /**
     * @param ids список технических идентификаторов {@link SuspiciousAccountTransferEntity}
     * @return {@link ResponseEntity} c листом {@link SuspiciousAccountTransferDto}
     */
    @GetMapping
    // TODO getById переименуй в readAll.
    public ResponseEntity<List<SuspiciousAccountTransferDto>> getAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(suspiciousAccountTransferService.findAllById(ids));
    }

    /**
     * @param suspiciousTransfer {@link SuspiciousAccountTransferDto}
     * TODO после ResponseEntity и SuspiciousAccountTransferDto удали пробелы.
     * @return {@link ResponseEntity } {@link SuspiciousAccountTransferDto }
     */
    @PostMapping("/create")
    public ResponseEntity<SuspiciousAccountTransferDto> create(
            @RequestBody SuspiciousAccountTransferDto suspiciousTransfer) {
        return ResponseEntity.ok(suspiciousAccountTransferService.save(suspiciousTransfer));
    }

    /**
     * @param suspiciousTransfer {@link SuspiciousAccountTransferDto}
     * @param id технический идентификатор {@link SuspiciousAccountTransferEntity}
     * TODO после ResponseEntity удали пробел.
     * @return {@link ResponseEntity } {@link SuspiciousAccountTransferDto}
     */
    @PutMapping("/{id}")
    public ResponseEntity<SuspiciousAccountTransferDto> update(
            @RequestBody SuspiciousAccountTransferDto suspiciousTransfer,
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(suspiciousAccountTransferService.update(id, suspiciousTransfer));
    }
}
