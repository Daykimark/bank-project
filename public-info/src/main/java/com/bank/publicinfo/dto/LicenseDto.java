package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.LicenseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO для {@link LicenseEntity}
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LicenseDto implements Serializable {
    private Long id;
    private Byte[] photoLicense;
    private BankDetailsDto bankDetails;
}
