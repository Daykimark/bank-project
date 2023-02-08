package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.BankDetailsEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO для {@link BankDetailsEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BankDetailsDto implements Serializable {
    Long id;
    Long bik;
    Long inn;
    Long kpp;
    Integer corAccount;
    String city;
    String jointStockCompany;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BankDetailsDto bankDetails = (BankDetailsDto) o;
        return id.equals(bankDetails.id) && bik.equals(bankDetails.bik) &&
                inn.equals(bankDetails.inn) && kpp.equals(bankDetails.kpp) &&
                corAccount.equals(bankDetails.corAccount) && city.equals(bankDetails.city) &&
                jointStockCompany.equals(bankDetails.jointStockCompany) && name.equals(bankDetails.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bik, inn, kpp, corAccount, city, jointStockCompany, name);
    }

}
