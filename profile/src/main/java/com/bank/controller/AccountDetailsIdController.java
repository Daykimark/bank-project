package com.bank.controller;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.service.AccountDetailsIdService;
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
 * Контроллер для {@link com.bank.model.AccountDetailsIdEntity}*/

@RestController
@RequestMapping("/accountId")
@RequiredArgsConstructor
public class AccountDetailsIdController {

    private final AccountDetailsIdService accountDetailsIdService;

    /**
     * Метод отдает одну сущность из БД по айди в пути и возвращает ее
     * @param id - айди пользователя которого нужно вернуть*/
    @GetMapping("/get/{id}")
    public ResponseEntity<AccountDetailsIdDto> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(accountDetailsIdService.findById(id));
    }

    /**
     * Метод сохраняет в БД одну сущность и возвращает ее
     * @param dto - сущность для сохранения в виде ДТО*/
    @PostMapping("/save")
    public ResponseEntity<AccountDetailsIdDto> save(@RequestBody AccountDetailsIdDto dto) {
        return ResponseEntity.ok(accountDetailsIdService.save(dto));
    }

    /**
     * Метод обновляет одну сущность из БД и возвращает ее
     * @param dto - сущность для обновления в виде ДТО*/
    @PutMapping("/update")
    public ResponseEntity<AccountDetailsIdDto> update(@RequestBody AccountDetailsIdDto dto) {
        return ResponseEntity.ok(accountDetailsIdService.save(dto));
    }

    /**
     * Метод возвращает одну или несколько записей в таблице по листу айди
     * @param ids - айди сущностей, которые вернет метод*/
    @GetMapping("/getAllById")
    public ResponseEntity<List<AccountDetailsIdDto>> getAllById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(accountDetailsIdService.findAllById(ids));
    }

    /**
     * Метод возвращает все записи из таблицы*/
    @GetMapping("/getAll")
    public ResponseEntity<List<AccountDetailsIdDto>> getAll() {
        return ResponseEntity.ok(accountDetailsIdService.findAll());
    }
}
