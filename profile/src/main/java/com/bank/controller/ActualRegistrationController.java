package com.bank.controller;

import com.bank.dto.ActualRegistrationDto;
import com.bank.service.ActualRegistrationService;
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
 * Контроллер для {@link com.bank.model.ActualRegistrationEntity}*/

@RestController
@RequestMapping("actualRegistration")
@RequiredArgsConstructor
public class ActualRegistrationController {

    private final ActualRegistrationService actualRegistrationService;

    /**
     * Метод сохраняет в БД одну сущность и возвращает ее
     * @param dto - сущность для сохранения в виде ДТО*/
    @PostMapping("/save")
    public ResponseEntity<ActualRegistrationDto> save(@RequestBody ActualRegistrationDto dto) {
        return ResponseEntity.ok(actualRegistrationService.save(dto));
    }

    /**
     * Метод отдает одну сущность из БД по айди в пути и возвращает ее
     * @param id - айди пользователя которого нужно вернуть*/
    @GetMapping("/get/{id}")
    public ResponseEntity<ActualRegistrationDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(actualRegistrationService.findById(id));
    }

    /**
     * Метод возвращает одну или несколько записей в таблице по листу айди
     * @param ids - айди сущностей, которые вернет метод*/
    @GetMapping("/getAllById")
    public ResponseEntity<List<ActualRegistrationDto>> getAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(actualRegistrationService.findAllById(ids));
    }

    /**
     * Метод обновляет одну сущность из БД и возвращает ее
     * @param dto - сущность для обновления в виде ДТО*/
    @PutMapping("/update")
    public ResponseEntity<ActualRegistrationDto> update(@RequestBody ActualRegistrationDto dto) {
        return ResponseEntity.ok(actualRegistrationService.save(dto));
    }

    /**
     * Метод возвращает все записи из таблицы*/
    @GetMapping("/getAll")
    public ResponseEntity<List<ActualRegistrationDto>> getAll() {
        return ResponseEntity.ok(actualRegistrationService.findAll());
    }
}
