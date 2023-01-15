package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.bank.model.AccountDetailsIdEntity;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link AccountDetailsIdEntity} entity
 */
@Data
@AllArgsConstructor
public class AccountDetailsIdDto implements Serializable {
    private Integer accountId;
    private ProfileDto profile;
}