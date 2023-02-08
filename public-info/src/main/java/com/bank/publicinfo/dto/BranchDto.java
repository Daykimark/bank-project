package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.BranchEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

/**
 * DTO для {@link BranchEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchDto implements Serializable {
    Long id;
    String address;
    Long phoneNumber;
    String city;
    LocalTime startOfWork;
    LocalTime endOfWork;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BranchDto branch = (BranchDto) o;
        return id.equals(branch.id) && address.equals(branch.address) &&
                phoneNumber.equals(branch.phoneNumber) && city.equals(branch.city) &&
                startOfWork.equals(branch.startOfWork) && endOfWork.equals(branch.endOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, phoneNumber, city, startOfWork, endOfWork);
    }
}
