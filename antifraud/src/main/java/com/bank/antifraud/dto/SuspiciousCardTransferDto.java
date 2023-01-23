package com.bank.antifraud.dto;

import com.bank.antifraud.entity.SuspiciousCardTransferEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Dto для {@link SuspiciousCardTransferEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuspiciousCardTransferDto implements Serializable {
    private Long id;
    private Long cardTransferId;
    private Boolean isBlocked;
    private Boolean isSuspicious;
    private String blockedReason;
    private String suspiciousReason;
}
