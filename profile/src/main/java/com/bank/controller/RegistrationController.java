package com.bank.controller;


import com.bank.dto.RegistrationDto;
import com.bank.service.RegistrationService;
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
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    /**
     * Метод сохраняет в БД одну сущность и возвращает ее
     * @param dto - сущность для сохранения в виде ДТО*/
    @PostMapping("/save")
    public ResponseEntity<RegistrationDto> save(@RequestBody RegistrationDto dto) {
        return ResponseEntity.ok(registrationService.save(dto));
    }

    /**
     * Метод отдает одну сущность из БД по айди в пути и возвращает ее
     * @param id - айди пользователя которого нужно вернуть*/
    @GetMapping("/get/{id}")
    public ResponseEntity<RegistrationDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(registrationService.findById(id));
    }

    /**
     * Метод возвращает одну или несколько записей в таблице по листу айди
     * @param ids - айди сущностей, которые вернет метод*/
    @GetMapping("/getAllById")
    public ResponseEntity<List<RegistrationDto>> getAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(registrationService.findAllById(ids));
    }

    /**
     * Метод обновляет одну сущность из БД и возвращает ее
     * @param dto - сущность для обновления в виде ДТО*/
    @PutMapping("/update")
    public ResponseEntity<RegistrationDto> update(@RequestBody RegistrationDto dto) {
        return ResponseEntity.ok(registrationService.save(dto));
    }

    /**
     * Метод возвращает все записи из таблицы*/
    @GetMapping("/getAll")
    public ResponseEntity<List<RegistrationDto>> getAll() {
        return ResponseEntity.ok(registrationService.findAll());
    }
}
