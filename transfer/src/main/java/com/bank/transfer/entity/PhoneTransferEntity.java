package com.bank.transfer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Entity для таблицы phone_transfer
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phone_transfer", schema = "transfer")
public class PhoneTransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "phone_number")
    private Long phoneNumber;

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
        if (!(o instanceof PhoneTransferEntity phoneTransfer)) {
            return false;
        }
        return Objects.equals(getId(), phoneTransfer.getId()) && Objects.equals(getPhoneNumber(),
                phoneTransfer.getPhoneNumber()) && Objects.equals(getAmount(),
                phoneTransfer.getAmount()) && Objects.equals(getPurpose(),
                phoneTransfer.getPurpose()) && Objects.equals(getAccountDetailsId(),
                phoneTransfer.getAccountDetailsId()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhoneNumber(), getAmount(), getPurpose(), getAccountDetailsId());
    }
}
