package com.bank.antifraud.controller;

import com.bank.antifraud.dto.SuspiciousCardTransferDto;
import com.bank.antifraud.entity.SuspiciousCardTransferEntity;
import com.bank.antifraud.service.SuspiciousCardTransferService;
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
 * Контроллер для {@link SuspiciousCardTransferDto}
 */
@RestController
// TODO @RequestMapping("/suspicious/card/transfer" и @RequiredArgsConstructor поменять местами.
@RequestMapping("/suspicious/card/transfer")
@RequiredArgsConstructor
public class SuspiciousCardTransferController {
    // TODO suspiciousCardTransferService переименуй в service.
    private final SuspiciousCardTransferService suspiciousCardTransferService;

    /**
     * @param id технический идентификатор {@link SuspiciousCardTransferEntity}
     * @return {@link ResponseEntity} {@link SuspiciousCardTransferDto}
     */
    @GetMapping("/{id}")
    // TODO getById переименуй в read.
    public ResponseEntity<SuspiciousCardTransferDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(suspiciousCardTransferService.findById(id));
    }

    /**
     * @param ids список технических идентификаторов {@link SuspiciousCardTransferEntity}
     * @return {@link ResponseEntity } c листом {@link SuspiciousCardTransferDto}
     */
    @GetMapping
    // TODO getById переименуй в readAll.
    public ResponseEntity<List<SuspiciousCardTransferDto>> getAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(suspiciousCardTransferService.findAllById(ids));
    }

    /**
     * @param suspiciousTransfer {@link SuspiciousCardTransferDto}
     * @return {@link ResponseEntity} {@link SuspiciousCardTransferDto}
     */
    @PostMapping("/create")
    public ResponseEntity<SuspiciousCardTransferDto> create(
            @RequestBody SuspiciousCardTransferDto suspiciousTransfer) {
        return ResponseEntity.ok(suspiciousCardTransferService.save(suspiciousTransfer));
    }

    /**
     * @param suspiciousTransfer {@link SuspiciousCardTransferDto}
     * @param id технический идентификатор {@link SuspiciousCardTransferEntity}
     * TODO после ResponseEntity удали пробел.
     * @return {@link ResponseEntity } {@link SuspiciousCardTransferDto}
     */
    @PutMapping("/{id}")
    public ResponseEntity<SuspiciousCardTransferDto> update(
            @RequestBody SuspiciousCardTransferDto suspiciousTransfer,
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(suspiciousCardTransferService.update(id, suspiciousTransfer));
    }
}
