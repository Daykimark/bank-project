package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.LicenseEntity;
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
 * DTO для {@link LicenseEntity}
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LicenseDto implements Serializable {
    Long id;
    Byte[] photoLicense;
    BankDetailsDto bankDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LicenseDto license = (LicenseDto) o;
        return id.equals(license.id) &&
                Arrays.equals(photoLicense, license.photoLicense) &&
                bankDetails.equals(license.bankDetails);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, bankDetails);
        result = 31 * result + Arrays.hashCode(photoLicense);
        return result;
    }
}
