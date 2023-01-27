package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.BankDetailsEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

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
}
