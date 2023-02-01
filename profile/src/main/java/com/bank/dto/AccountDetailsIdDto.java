package com.bank.dto;

import com.bank.entity.AccountDetailsIdEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * ДТО для сущности {@link AccountDetailsIdEntity}
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetailsIdDto implements Serializable {
    private Long id;
    private Long accountId;
    private ProfileDto profile;
}
