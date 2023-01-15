package com.bank.dto;

import com.bank.model.AccountDetailsIdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link AccountDetailsIdEntity} entity
 */
@Data
@AllArgsConstructor
public class AccountDetailsIdDto implements Serializable {

    private Long id;
    private Integer accountId;
    private ProfileDto profile;
}
