package com.bank.publicinfo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Supplier для {@link EntityNotFoundException}
 */
@Slf4j
@Component
// TODO Supplier переименовать EntityNotFoundSupplier. Опять же класс не относиться к impl, вынести в отдельный пакет.
public class Supplier {

    public EntityNotFoundException loggingAndGet(String message, Long id) {
        final var entityNotFound = new EntityNotFoundException(id + message);
        log.error(entityNotFound.getMessage(), entityNotFound);
        return entityNotFound;
    }

    // TODO entityList переименовать entities. И можно абстрактный класс сделать AbstractEntity
    //  и вместо E принимать его.
    public <E> void checkForSizeAndLogging(String message, List<Long> ids, List<E> entityList) {
        if (entityList.size() < ids.size()) {
            final var entityNotFound = new EntityNotFoundException(message + entityList + ids);
            log.error(entityNotFound.getMessage(), entityNotFound);
            throw entityNotFound;
        }
    }
}
