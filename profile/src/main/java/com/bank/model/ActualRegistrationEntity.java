package com.bank.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * TODO Entity для таблицы actual_registration.
 * Сущность которая представляет таблицу actual_registration
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// TODO @AllArgsConstructor и @NoArgsConstructor, поменяй местами с @Setter и @Entity.
@Entity
@Table(name = "actual_registration", schema = "profile")
public class ActualRegistrationEntity {
    // TODO туду удали и оставь пустую строку.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // TODO поменяй @Size(max = 40) и @NotNull местами.
    @Size(max = 40)
    @NotNull
    @Column(name = "country", nullable = false, length = 40)
    private String country;

    @Size(max = 160)
    @Column(name = "region", length = 160)
    private String region;

    @Size(max = 160)
    @Column(name = "city", length = 160)
    private String city;

    @Size(max = 160)
    @Column(name = "district", length = 160)
    private String district;

    @Size(max = 230)
    @Column(name = "locality", length = 230)
    private String locality;

    @Size(max = 230)
    @Column(name = "street", length = 230)
    private String street;

    @Size(max = 20)
    @Column(name = "house_number", length = 20)
    private String houseNumber;

    @Size(max = 20)
    @Column(name = "house_block", length = 20)
    private String houseBlock;

    @Size(max = 40)
    @Column(name = "flat_number", length = 40)
    private String flatNumber;

    @NotNull
    @Column(name = "index", nullable = false)
    private Long index;
}
