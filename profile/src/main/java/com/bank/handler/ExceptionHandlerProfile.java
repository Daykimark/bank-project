package com.bank.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

/**
 * Класс для отлова исключений
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlerProfile {

    /**
     * @param ex {@link EntityNotFoundException}
     * @return {@link ResponseEntity} с сообщением и HttpStatus.NOT_FOUND
     */
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<String> handle(EntityNotFoundException ex) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
