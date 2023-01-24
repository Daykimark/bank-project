package com.bank.antifraud.controller;

import com.bank.antifraud.dto.SuspiciousPhoneTransferDto;
import com.bank.antifraud.entity.SuspiciousPhoneTransferEntity;
import com.bank.antifraud.service.SuspiciousPhoneTransferService;
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
 * Контроллер для {@link SuspiciousPhoneTransferDto}
 */
@RestController
// TODO @RequestMapping("/suspicious/phone/transfer") и @RequiredArgsConstructor поменять местами.
@RequestMapping("/suspicious/phone/transfer")
@RequiredArgsConstructor
public class SuspiciousPhoneTransferController {
    // TODO suspiciousPhoneTransferService переименуй в service.
    private final SuspiciousPhoneTransferService suspiciousPhoneTransferService;

    /**
     * @param id технический идентификатор {@link SuspiciousPhoneTransferEntity}
     * @return {@link ResponseEntity} {@link SuspiciousPhoneTransferDto}
     */
    @GetMapping("/{id}")
    // TODO getById переименуй в read.
    public ResponseEntity<SuspiciousPhoneTransferDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(suspiciousPhoneTransferService.findById(id));
    }

    /**
     * @param ids список технических идентификаторов {@link SuspiciousPhoneTransferEntity}
     * @return {@link ResponseEntity} c листом {@link SuspiciousPhoneTransferDto}
     */
    @GetMapping
    // TODO getById переименуй в readAll.
    public ResponseEntity<List<SuspiciousPhoneTransferDto>> getById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(suspiciousPhoneTransferService.findAllById(ids));
    }

    /**
     * @param suspiciousTransfer {@link SuspiciousPhoneTransferDto}
     * TODO после ResponseEntity удали пробел.
     * @return {@link ResponseEntity } {@link SuspiciousPhoneTransferDto}
     */
    @PostMapping("/create")
    public ResponseEntity<SuspiciousPhoneTransferDto> create(
            @RequestBody SuspiciousPhoneTransferDto suspiciousTransfer) {
        return ResponseEntity.ok(suspiciousPhoneTransferService.save(suspiciousTransfer));
    }

    /**
     * @param suspiciousTransfer {@link SuspiciousPhoneTransferDto}
     * @param id технический идентификатор {@link SuspiciousPhoneTransferEntity}
     * TODO после ResponseEntity удали пробел.
     * @return {@link ResponseEntity } {@link SuspiciousPhoneTransferDto}
     */
    @PutMapping("/{id}")
    public ResponseEntity<SuspiciousPhoneTransferDto> update(
            @RequestBody SuspiciousPhoneTransferDto suspiciousTransfer,
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(suspiciousPhoneTransferService.update(id, suspiciousTransfer));
    }
}
