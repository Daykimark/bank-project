package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Сущность которая представляет passport_entity*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "passport", schema = "profile")
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "series", nullable = false)
    private Integer series;

    @NotNull
    @Column(name = "number", nullable = false)
    private Long number;

    @Size(max = 255)
    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Size(max = 255)
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(max = 255)
    @Column(name = "middle_name")
    private String middleName;

    @Size(max = 3)
    @NotNull
    @Column(name = "gender", nullable = false, length = 3)
    private String gender;


    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Size(max = 480)
    @NotNull
    @Column(name = "birth_place", nullable = false, length = 480)
    private String birthPlace;

    @NotNull
    @Column(name = "issued_by", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String issuedBy;


    @NotNull
    @Column(name = "date_of_issue", nullable = false)
    private LocalDate dateOfIssue;

    @NotNull
    @Column(name = "division_code", nullable = false)
    private Integer divisionCode;


    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "registration_id", nullable = false)
    private RegistrationEntity registration;

}
