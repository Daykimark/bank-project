package com.bank.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;


/**
 * Класс для отлова исключений
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerProfile {

    /**
     * @param ex {@link EntityNotFoundException}
     * @param request - Запрос, при котором возникло исключение {@link WebRequest}
     * @return {@link ResponseEntity} тут лежит сообщение исключения, и HttpStatus.NOT_FOUND
     */
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<String> entityNotFound(EntityNotFoundException ex, WebRequest request) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
