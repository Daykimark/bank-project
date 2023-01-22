package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * TODO Entity для таблицы passport.
 * Сущность, которая представляет passport
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// TODO @AllArgsConstructor и @NoArgsConstructor, поменяй местами с @Setter и @Entity.
@Entity
@Table(name = "passport", schema = "profile")
public class PassportEntity {
    // TODO туду удали и оставь пустую строку.
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
    // TODO поменяй @Size(max = 255) и @NotNull местами.
    @Size(max = 255)
    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;
    // TODO поменяй @Size(max = 255) и @NotNull местами.
    @Size(max = 255)
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(max = 255)
    @Column(name = "middle_name")
    private String middleName;
    // TODO поменяй @Size(max = 3) и @NotNull местами.
    @Size(max = 3)
    @NotNull
    @Column(name = "gender", nullable = false, length = 3)
    private String gender;

    // TODO удали пустую строку.
    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    // TODO поменяй @Size(max = 400) и @NotNull местами.
    @Size(max = 480)
    @NotNull
    @Column(name = "birth_place", nullable = false, length = 480)
    private String birthPlace;

    @NotNull
    @Column(name = "issued_by", nullable = false)
    // TODO удали 80 строку.
    @Type(type = "org.hibernate.type.TextType")
    private String issuedBy;

    // TODO удали пустую строку.
    @NotNull
    @Column(name = "date_of_issue", nullable = false)
    private LocalDate dateOfIssue;

    @NotNull
    @Column(name = "division_code", nullable = false)
    private Integer divisionCode;

    // TODO удали пустую строку.
    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @NotNull
    @OneToOne(optional = false,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "registration_id", nullable = false)
    private RegistrationEntity registration;
    // TODO удали пустую строку.
}
