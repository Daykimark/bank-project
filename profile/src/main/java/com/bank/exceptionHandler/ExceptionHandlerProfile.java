package com.bank.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
// TODO удали пустую строку.

/**
 * Класс для отлова исключений
 */
// TODO @ControllerAdvice и @Slf4j поменяй местами.
@ControllerAdvice
@Slf4j
public class ExceptionHandlerProfile {

    /**
     * @param ex {@link EntityNotFoundException}
     * TODO удали request и его описание.
     * @param request - Запрос, при котором возникло исключение {@link WebRequest}
     * TODO исправить на "{@link ResponseEntity} с сообщением и HttpStatus.NOT_FOUND".
     * @return {@link ResponseEntity} тут лежит сообщение исключения, и HttpStatus.NOT_FOUND
     */
    @ExceptionHandler(value = {EntityNotFoundException.class})
    // TODO удали request и переименуй "entityNotFound" на "handle".
    public ResponseEntity<String> entityNotFound(EntityNotFoundException ex, WebRequest request) {
        // TODO "log.error(ex.getMessage(), ex);"
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
