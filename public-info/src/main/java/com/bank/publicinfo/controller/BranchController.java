package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.BranchDto;
import com.bank.publicinfo.service.BranchService;
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
 * Контроллер для {@link BranchDto}
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/branch")
// TODO добавь джавадоки для методов, без описание просто @param и @return.
public class BranchController {
    // TODO branchService переименуй service.
    private final BranchService branchService;

    @GetMapping("/{id}")
    private ResponseEntity<BranchDto> readById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(branchService.findById(id));
    }

    @GetMapping("/read/all")
    private ResponseEntity<List<BranchDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok().body(branchService.findAllById(ids));
    }

    @PostMapping("/create")
    private ResponseEntity<BranchDto> create(@RequestBody BranchDto branch) {
        return ResponseEntity.ok().body(branchService.create(branch));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<BranchDto> update(@PathVariable("id") Long id,
                                             @RequestBody BranchDto branch) {
        return ResponseEntity.ok().body(branchService.update(id, branch));
    }
}

// TODO удали пустую строку.