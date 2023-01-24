package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.CertificateEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO для {@link CertificateEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDto implements Serializable {
    private  Long id;
    private  Byte[] photoCertificate;
    private  BankDetailsDto bankDetails;
}
