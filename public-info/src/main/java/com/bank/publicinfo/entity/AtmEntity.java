package com.bank.publicinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
 * TODO исправь энтити на entity.
 * энтити для таблицы "atm"
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "atm", schema = "public_bank_information")
public class AtmEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "start_of_work")
    private LocalTime startOfWork;

    @NotNull
    @Column(name = "end_of_work")
    private LocalTime endOfWork;

    @Column(name = "all_hours")
    private Boolean allHours;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "branch_id")
    private BranchEntity branch;

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
