package com.bank.publicinfo.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Entity для таблицы "atm"
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "atm", schema = "public_bank_information")
public class AtmEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "address")
    String address;

    @NotNull
    @Column(name = "start_of_work")
    LocalTime startOfWork;

    @NotNull
    @Column(name = "end_of_work")
    LocalTime endOfWork;

    @Column(name = "all_hours")
    Boolean allHours;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "branch_id")
    BranchEntity branch;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final AtmEntity atm = (AtmEntity) o;
        return id.equals(atm.id) &&
                address.equals(atm.address) &&
                startOfWork.equals(atm.startOfWork) &&
                endOfWork.equals(atm.endOfWork) &&
                allHours.equals(atm.allHours) &&
                branch.equals(atm.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, startOfWork, endOfWork, allHours, branch);
    }
}
