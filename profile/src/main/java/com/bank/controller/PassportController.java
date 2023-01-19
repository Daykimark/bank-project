package com.bank.controller;

import com.bank.dto.PassportDto;
import com.bank.service.PassportService;
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
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private PassportService passportService;

    /**
     * Метод сохраняет в БД одну сущность и возвращает ее
     * @param dto - сущность для сохранения в виде ДТО*/
    @PostMapping("/save")
    public ResponseEntity<PassportDto> save(@RequestBody PassportDto dto) {
        return ResponseEntity.ok(passportService.save(dto));
    }

    /**
     * Метод отдает одну сущность из БД по айди в пути и возвращает ее
     * @param id - айди пользователя которого нужно вернуть*/
    @GetMapping("/get/{id}")
    public ResponseEntity<PassportDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(passportService.findById(id));
    }

    /**
     * Метод возвращает одну или несколько записей в таблице по листу айди
     * @param ids - айди сущностей, которые вернет метод*/
    @GetMapping("/getAllById")
    public ResponseEntity<List<PassportDto>> getAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(passportService.findAllById(ids));
    }

    /**
     * Метод обновляет одну сущность из БД и возвращает ее
     * @param dto - сущность для обновления в виде ДТО*/
    @PutMapping("/update")
    public ResponseEntity<PassportDto> update(@RequestBody PassportDto dto) {
        return ResponseEntity.ok(passportService.save(dto));
    }

    /**
     * Метод возвращает все записи из таблицы*/
    @GetMapping("/getAll")
    public ResponseEntity<List<PassportDto>> getAll() {
        return ResponseEntity.ok(passportService.findAll());
    }
}
