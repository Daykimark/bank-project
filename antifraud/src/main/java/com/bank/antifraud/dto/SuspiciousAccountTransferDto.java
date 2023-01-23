package com.bank.antifraud.dto;

import com.bank.antifraud.entity.SuspiciousAccountTransferEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Dto для {@link SuspiciousAccountTransferEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuspiciousAccountTransferDto implements Serializable {
    private Long id;
    private Long accountTransferId;
    private Boolean isBlocked;
    private Boolean isSuspicious;
    private String blockedReason;
    private String suspiciousReason;
}
