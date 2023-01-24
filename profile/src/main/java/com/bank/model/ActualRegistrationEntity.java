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
 * Entity для таблицы actual_registration
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actual_registration", schema = "profile")
public class ActualRegistrationEntity {
    // TODO удали и оставь пустую строку.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // TODO удали пустую строку.
    private Long id;
    // TODO удали и оставь пустую строку. И @NotNull и @Size(max = 40) поменяй местами.
    @NotNull
    @Size(max = 40)
    @Column(name = "country")
    private String country;
    // TODO удали и оставь пустую строку.
    @Size(max = 160)
    @Column(name = "region")
    private String region;
    // TODO удали и оставь пустую строку.
    @Size(max = 160)
    @Column(name = "city")
    private String city;
    // TODO удали и оставь пустую строку.
    @Size(max = 160)
    @Column(name = "district")
    private String district;
    // TODO удали и оставь пустую строку.
    @Size(max = 230)
    @Column(name = "locality")
    private String locality;
    // TODO удали и оставь пустую строку.
    @Size(max = 230)
    @Column(name = "street")
    private String street;
    // TODO удали и оставь пустую строку.
    @Size(max = 20)
    @Column(name = "house_number")
    private String houseNumber;
    // TODO удали и оставь пустую строку.
    @Size(max = 20)
    @Column(name = "house_block")
    private String houseBlock;
    // TODO удали и оставь пустую строку.
    @Size(max = 40)
    @Column(name = "flat_number")
    private String flatNumber;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Column(name = "index")
    private Long index;
}
