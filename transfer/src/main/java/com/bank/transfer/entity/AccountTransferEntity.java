package com.bank.transfer.entity;

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
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Entity для таблицы account_transfer
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_transfer", schema = "transfer")
public class AccountTransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "account_number", unique = true)
    private Long accountNumber;

    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "purpose")
    private String purpose;

    @NotNull
    @Column(name = "account_details_id")
    private Long accountDetailsId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccountTransferEntity accountTransfer)) {
            return false;
        }
        return Objects.equals(getId(), accountTransfer.getId()) && Objects.equals(getAccountNumber(),
                accountTransfer.getAccountNumber()) && Objects.equals(getAmount(),
                accountTransfer.getAmount()) && Objects.equals(getPurpose(),
                accountTransfer.getPurpose()) && Objects.equals(getAccountDetailsId(),
                accountTransfer.getAccountDetailsId()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountNumber(), getAmount(), getPurpose(), getAccountDetailsId());
    }
}
