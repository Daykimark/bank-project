package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.BankDetailsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO для {@link BankDetailsEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankDetailsDto implements Serializable {
    private Long id;
    private Long bik;
    private Long inn;
    private Long kpp;
    private Integer corAccount;
    private String city;
    private String jointStockCompany;
    private String name;
}
