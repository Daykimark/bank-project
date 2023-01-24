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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity для таблицы profile
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile", schema = "profile")
public class ProfileEntity {
    // TODO удали и оставь пустую строку.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Column(name = "phone_number")
    private Long phoneNumber;
    // TODO удали и оставь пустую строку.
    @Email
    @Size(max = 264)
    @Column(name = "email")
    private String email;
    // TODO удали и оставь пустую строку.
    @Size(max = 370)
    @Column(name = "name_on_card")
    private String nameOnCard;
    // TODO удали и оставь пустую строку.
    @Column(name = "inn", unique = true)
    private Long inn;
    // TODO удали и оставь пустую строку.
    @Column(name = "snils", unique = true)
    private Long snils;
    // TODO удали и оставь пустую строку.
    @NotNull
    @OneToOne(optional = false,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "passport_id")
    private PassportEntity passport;
    // TODO удали и оставь пустую строку.
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "actual_registration_id")
    private ActualRegistrationEntity actualRegistration;
}
