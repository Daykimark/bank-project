package com.bank.transfer.dto;

import com.bank.transfer.entity.PhoneTransferEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ДТО {@link PhoneTransferEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneTransferDto implements Serializable {
    private Long id;
    private Long phoneNumber;
    private BigDecimal amount;
    private String purpose;
    private Long accountDetailsId;
}
