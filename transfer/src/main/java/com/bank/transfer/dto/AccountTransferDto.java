package com.bank.transfer.dto;

import com.bank.transfer.entity.AccountTransferEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ДТО {@link AccountTransferEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransferDto implements Serializable {
    private Long id;
    private Long accountNumber;
    private BigDecimal amount;
    private String purpose;
    private Long accountDetailsId;
}
