package com.bank.controller;

import com.bank.dto.RegistrationDto;
import com.bank.model.RegistrationEntity;
import com.bank.service.RegistrationService;
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
 * Контроллер для {@link RegistrationEntity}
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService service;

    /**
     * @param id технический идентификатор {@link RegistrationEntity}
     * @return {@link ResponseEntity<RegistrationDto>}
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<RegistrationDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * @param registration {@link RegistrationDto}
     * @return {@link ResponseEntity<RegistrationDto>}
     */
    //TODO save переименуй в create.
    @PostMapping("/save")
    //TODO save переименуй в create.
    public ResponseEntity<RegistrationDto> save(@RequestBody RegistrationDto registration) {
        return ResponseEntity.ok(service.save(registration));
    }

    /**
     * @param registration {@link RegistrationDto}
     * @param id технический идентификатор {@link RegistrationEntity}
     * @return {@link ResponseEntity<RegistrationDto>}
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<RegistrationDto> update(@PathVariable Long id, @RequestBody RegistrationDto registration) {
        return ResponseEntity.ok(service.update(id, registration));
    }

    /**
     * @param ids лист технических идентификаторов {@link RegistrationEntity}
     * TODO удали "листом".
     * @return {@link ResponseEntity} с листом {@link List<RegistrationDto>}
     */
    @GetMapping("read/all")
    public ResponseEntity<List<RegistrationDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }
}
