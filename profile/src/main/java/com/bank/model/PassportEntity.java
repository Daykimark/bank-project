package com.bank.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Entity для таблицы passport
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "passport", schema = "profile")
public class PassportEntity {
    // TODO удали и оставь пустую строку.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Column(name = "series")
    private Integer series;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Column(name = "number")
    private Long number;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;
    // TODO удали и оставь пустую строку.
    @Size(max = 255)
    @Column(name = "middle_name")
    private String middleName;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Size(max = 3)
    @Column(name = "gender")
    private String gender;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Size(max = 480)
    @Column(name = "birth_place")
    private String birthPlace;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Column(name = "issued_by")
    private String issuedBy;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Column(name = "division_code")
    private Integer divisionCode;
    // TODO удали и оставь пустую строку.
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    // TODO удали и оставь пустую строку.
    @NotNull
    @OneToOne(optional = false,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "registration_id")
    private RegistrationEntity registration;
}
