package com.bank.controller;

import com.bank.dto.ProfileDto;
import com.bank.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    /**
     * Метод сохраняет в БД одну сущность и возвращает ее
     * @param dto - сущность для сохранения в виде ДТО*/
    @PostMapping("/save")
    public ResponseEntity<ProfileDto> save(@RequestBody ProfileDto dto) {
        return ResponseEntity.ok(profileService.save(dto));
    }

    /**
     * Метод отдает одну сущность из БД по айди в пути и возвращает ее
     * @param id - айди пользователя которого нужно вернуть*/
    @GetMapping("/get/{id}")
    public ResponseEntity<ProfileDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(profileService.findById(id));
    }

    /**
     * Метод возвращает одну или несколько записей в таблице по листу айди
     * @param ids - айди сущностей, которые вернет метод*/
    @GetMapping("/getAllById")
    public ResponseEntity<List<ProfileDto>> getAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(profileService.findAllById(ids));
    }

    /**
     * Метод обновляет одну сущность из БД и возвращает ее
     * @param dto - сущность для обновления в виде ДТО*/
    @PutMapping("/update")
    public ResponseEntity<ProfileDto> update(@RequestBody ProfileDto dto) {
        return ResponseEntity.ok(profileService.save(dto));
    }

    /**
     * Метод возвращает все записи из таблицы*/
    @GetMapping("/getAll")
    public ResponseEntity<List<ProfileDto>> getAll() {
        return ResponseEntity.ok(profileService.findAll());
    }
}
