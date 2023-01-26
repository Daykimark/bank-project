package com.bank.account.dto;

import com.bank.account.entity.AccountDetailsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO сущности  {@link AccountDetailsEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// TODO используй аннотацию @FieldDefaults(level = AccessLevel.PRIVATE) и в полях "private" удали.
public class AccountDetailsDto implements Serializable {
    private Long id;
    private Long passportId;
    private Long accountNumber;
    private Long bankDetailsId;
    private BigDecimal money;
    private Boolean negativeBalance;
    private Long profileId;
}
