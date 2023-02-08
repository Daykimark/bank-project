package com.bank.publicinfo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Supplier для {@link EntityNotFoundException}
 */
@Slf4j
@Component
public class EntityNotFoundSupplier {

    public EntityNotFoundException loggingAndGet(String message, Long id) {
        final var entityNotFound = new EntityNotFoundException(id + message);
        log.error(entityNotFound.getMessage(), entityNotFound);
        return entityNotFound;
    }

    public <T> void checkForSizeAndLogging(String message, List<Long> ids, List<T> entities) {
        if (entities.size() < ids.size()) {
            final var entityNotFound = new EntityNotFoundException(message + entities + ids);
            log.error(entityNotFound.getMessage(), entityNotFound);
            throw entityNotFound;
        }
    }
}
