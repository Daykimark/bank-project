package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.AtmEntity;
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
 * DTO для {@link AtmEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AtmDto implements Serializable {
    Long id;
    String address;
    LocalTime startOfWork;
    LocalTime endOfWork;
    Boolean allHours;
    BranchDto branch;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AtmDto atm = (AtmDto) o;
        return id.equals(atm.id) && address.equals(atm.address) &&
                startOfWork.equals(atm.startOfWork) && endOfWork.equals(atm.endOfWork) &&
                allHours.equals(atm.allHours) && branch.equals(atm.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, startOfWork, endOfWork, allHours, branch);
    }
}
