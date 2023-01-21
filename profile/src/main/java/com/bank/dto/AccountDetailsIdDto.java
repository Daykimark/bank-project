package com.bank.dto;

import com.bank.model.AccountDetailsIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link AccountDetailsIdEntity} entity
 */
@Getter
@Setter
@NoArgsConstructor
public class AccountDetailsIdDto implements Serializable {

    private Long id;
    private Integer accountId;
    private ProfileDto profile;
}
