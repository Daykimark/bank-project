package com.bank.transfer.service.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

/**
 * возвращает {@link EntityNotFoundException}.
 */
@Slf4j
@Component
public class EntityNotFoundReturner {

    /**
     * @param id {@link String}
     * @return {@link EntityNotFoundException}
     */
    public EntityNotFoundException loggingAndGet(Long id, String message) {

        final EntityNotFoundException ex = new EntityNotFoundException(message + id);
        //  TODO как только общий рест хандлер будет готов, выпилить строку.
        log.error(ex.getMessage(), ex);
        return ex;
    }
}
