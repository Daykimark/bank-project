package com.bank.account.dto;

import com.bank.account.entity.AccountDetailsEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO сущности  {@link AccountDetailsEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDetailsDto implements Serializable {
    Long id;
    Long passportId;
    Long accountNumber;
    Long bankDetailsId;
    BigDecimal money;
    Boolean negativeBalance;
    Long profileId;
}
