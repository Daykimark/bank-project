package com.bank.antifraud.dto;

import com.bank.antifraud.entity.SuspiciousPhoneTransferEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Dto для {@link SuspiciousPhoneTransferEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuspiciousPhoneTransferDto implements Serializable {
    private Long id;
    private Long phoneTransferId;
    private Boolean isBlocked;
    private Boolean isSuspicious;
    private String blockedReason;
    private String suspiciousReason;
}
