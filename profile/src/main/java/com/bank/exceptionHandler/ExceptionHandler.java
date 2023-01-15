package com.bank.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;


/**
 * Класс для отлова исключений*/
@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    /**
     * Метод ловит исключения типа {@link EntityNotFoundException}
     * @param ex - Исключение
     * @param request - Запрос, при котором возникло исключение
     * @return {@link ResponseEntity} тут лежит сообщение исключение, и http статус*/
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<String> entityNotFound(EntityNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
