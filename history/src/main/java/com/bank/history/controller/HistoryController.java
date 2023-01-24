package com.bank.history.controller;

import com.bank.history.dto.HistoryDto;
import com.bank.history.entity.HistoryEntity;
import com.bank.history.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * контроллер для {@link HistoryEntity}.
 */
@RestController
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService service;

    /**
     * @param ids технические идентификаторы {@link HistoryEntity}.
     * @return {@link ResponseEntity} с листом {@link HistoryDto}.
     */
    @GetMapping
    public ResponseEntity<List<HistoryDto>> readAll(@RequestParam("ids") List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }

    /**
     * @param id технический идентификатор {@link HistoryEntity}.
     * @return {@link ResponseEntity} c {@link HistoryDto}.
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<HistoryDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * @param history {@link HistoryDto}.
     * @return {@link ResponseEntity} c {@link HistoryDto}.
     */
    @PostMapping(path = "/create")
    public ResponseEntity<HistoryDto> create(@RequestBody HistoryDto history) {
        return ResponseEntity.ok(service.create(history));
    }

    /**
     * @param id технический идентификатор {@link HistoryDto}.
     * @param history {@link HistoryDto}.
     * @return {@link ResponseEntity} с {@link HistoryDto}.
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<HistoryDto> update(@PathVariable("id") Long id, @RequestBody HistoryDto history) {
        return ResponseEntity.ok(service.update(id, history));
    }
}
