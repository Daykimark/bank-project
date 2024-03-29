package com.bank.account.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Entity для таблицы account_details.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_details", schema = "account")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "passport_id", nullable = false)
    Long passportId;

    @Column(name = "account_number", nullable = false)
    Long accountNumber;

    @Column(name = "bank_details_id", nullable = false)
    Long bankDetailsId;

    @Column(name = "money", nullable = false, precision = 20, scale = 2)
    BigDecimal money;

    @Column(name = "negative_balance", nullable = false)
    Boolean negativeBalance;

    @Column(name = "profile_id", nullable = false)
    Long profileId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AccountDetailsEntity accountDetail = (AccountDetailsEntity) o;
        return id.equals(accountDetail.id) &&
                passportId.equals(accountDetail.passportId) &&
                accountNumber.equals(accountDetail.accountNumber) &&
                bankDetailsId.equals(accountDetail.bankDetailsId) &&
                money.equals(accountDetail.money) &&
                negativeBalance.equals(accountDetail.negativeBalance) &&
                profileId.equals(accountDetail.profileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passportId, accountNumber, bankDetailsId, money, negativeBalance, profileId);
    }
}
