package com.bank.dto;

import com.bank.model.AccountDetailsIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO переписать на русском языке.
 * A DTO for the {@link AccountDetailsIdEntity} entity
 */
@Getter
@Setter
@NoArgsConstructor
// TODO добавить @AllArgsConstructor.
public class AccountDetailsIdDto implements Serializable {
    // TODO удали пустую строку.
    private Long id;
    // TODO тут почему Integer, когда Long. На будущее int8 в парадигме это Long.
    private Integer accountId;
    private ProfileDto profile;
}
