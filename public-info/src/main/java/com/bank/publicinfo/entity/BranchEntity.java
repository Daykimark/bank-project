package com.bank.publicinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.Objects;

/**
 * TODO исправь энтити на entity.
 * энтити для таблицы "branch"
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "branch", schema = "public_bank_information")
public class BranchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number", unique = true)
    private Long phoneNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "start_of_work")
    private LocalTime startOfWork;

    @Column(name = "end_of_work")
    private LocalTime endOfWork;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final BranchEntity branch = (BranchEntity) o;
        return id.equals(branch.id) &&
                address.equals(branch.address) &&
                phoneNumber.equals(branch.phoneNumber) &&
                city.equals(branch.city) &&
                startOfWork.equals(branch.startOfWork) &&
                endOfWork.equals(branch.endOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, phoneNumber, city, startOfWork, endOfWork);
    }
}
