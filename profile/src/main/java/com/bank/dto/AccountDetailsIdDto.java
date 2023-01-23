package com.bank.dto;

import com.bank.model.AccountDetailsIdEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * ДТО для сущности {@link AccountDetailsIdEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetailsIdDto implements Serializable {
    private Long id;
    private Long accountId;
    private ProfileDto profile;
}
