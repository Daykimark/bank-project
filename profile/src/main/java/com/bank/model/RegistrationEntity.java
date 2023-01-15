package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "registration", schema = "profile")
public class RegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 166)
    @NotNull
    @Column(name = "country", nullable = false, length = 166)
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

    @Column(name = "\"Column\"")
    private Integer column;

    @OneToMany(mappedBy = "registrationEntity")
    private Set<PassportEntity> passportEntities = new LinkedHashSet<>();

}