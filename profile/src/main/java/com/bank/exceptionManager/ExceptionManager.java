package com.bank.exceptionManager;

import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

/**
 * Класс, который возвращает нужные исключения
 */
@Component
public class ExceptionManager {

    /**
     * @param expectedSize*
     * @param actualSize*
     * @param message*
     * @return {@link EntityNotFoundException}
     */
    public static void getEntityNotFoundException(int expectedSize, int actualSize, String message) {
        if (actualSize != expectedSize) {
            throw new EntityNotFoundException(message);
        }
    }

    /**
     * @param message*
     * @return {@link EntityNotFoundException}
     */
    public static EntityNotFoundException getEntityNotFoundException(String message) {
        return new EntityNotFoundException(message);
    }
}
