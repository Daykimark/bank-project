package com.bank.antifraud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * entity для таблицы suspicious_account_transfer
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "suspicious_account_transfer", schema = "anti_fraud")
public class SuspiciousAccountTransferEntity {
    // TODO удали и оставь пустую строку.
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_transfer_id")
    private Long accountTransferId;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "is_suspicious")
    private Boolean isSuspicious;

    @Column(name = "blocked_reason")
    private String blockedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final SuspiciousAccountTransferEntity transfer = (SuspiciousAccountTransferEntity) o;
        return Objects.equals(id, transfer.id) &&
                Objects.equals(accountTransferId, transfer.accountTransferId) &&
                Objects.equals(isBlocked, transfer.isBlocked) &&
                Objects.equals(isSuspicious, transfer.isSuspicious) &&
                Objects.equals(blockedReason, transfer.blockedReason) &&
                Objects.equals(suspiciousReason, transfer.suspiciousReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountTransferId, isBlocked, isSuspicious, blockedReason, suspiciousReason);
    }
}
