package com.bank.transfer.dto;

import com.bank.transfer.entity.CardTransferEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ДТО {@link CardTransferEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardTransferDto implements Serializable {
    private Long id;
    private Long cardNumber;
    private BigDecimal amount;
    private String purpose;
    private Long accountDetailsId;
}
