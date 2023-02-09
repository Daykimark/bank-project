package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.CertificateEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * DTO для {@link CertificateEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CertificateDto implements Serializable {
    Long id;
    Byte[] photoCertificate;
    BankDetailsDto bankDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CertificateDto certificate = (CertificateDto) o;
        return id.equals(certificate.id) &&
                Arrays.equals(photoCertificate, certificate.photoCertificate) &&
                bankDetails.equals(certificate.bankDetails);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, bankDetails);
        result = 31 * result + Arrays.hashCode(photoCertificate);
        return result;
    }
}
