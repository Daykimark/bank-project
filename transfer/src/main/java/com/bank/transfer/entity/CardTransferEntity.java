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
 * Entity для таблицы card_transfer
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card_transfer", schema = "transfer")
public class CardTransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "card_number", unique = true)
    private Long cardNumber;

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
        if (!(o instanceof CardTransferEntity cardTransfer)) {
            return false;
        }
        return Objects.equals(getId(), cardTransfer.getId()) && Objects.equals(getCardNumber(),
                cardTransfer.getCardNumber()) && Objects.equals(getAmount(),
                cardTransfer.getAmount()) && Objects.equals(getPurpose(),
                cardTransfer.getPurpose()) && Objects.equals(getAccountDetailsId(),
                cardTransfer.getAccountDetailsId()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCardNumber(), getAmount(), getPurpose(), getAccountDetailsId());
    }
}
