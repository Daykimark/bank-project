package com.bank.controller;


import com.bank.dto.ProfileDto;
import com.bank.model.ProfileEntity;
import com.bank.service.ProfileService;
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
 * Контроллер для {@link ProfileEntity}
 */

@RestController
@RequestMapping("/profile/")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService service;

    /**
     * @param id технический идентификатор {@link ProfileEntity}
     * @return сущность в виде {@link ResponseEntity<ProfileDto>}
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<ProfileDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * @param dto - сущность для сохранения в виде {@link ProfileDto}
     * @return сохраненная сущность в виде {@link ResponseEntity<ProfileDto>}
     */
    @PostMapping("/save")
    public ResponseEntity<ProfileDto> save(@RequestBody ProfileDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param dto - сущность для обновления в виде {@link ProfileDto}
     * @return обновленная сущность в виде {@link ResponseEntity<ProfileDto>}
     */
    @PutMapping("/update")
    public ResponseEntity<ProfileDto> update(@RequestBody ProfileDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * @param ids лист технических идентификаторов {@link com.bank.model.ProfileEntity}
     * @return сущности в виде {@link ResponseEntity<List<ProfileDto>>}
     */
    @GetMapping("readAllById")
    public ResponseEntity<List<ProfileDto>> readAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }
}
