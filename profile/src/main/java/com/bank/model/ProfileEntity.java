package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

/**
 * Сущность, которая представляет таблицу profile
 */
@Getter
@Setter
@Entity
@Table(name = "profile", schema = "profile")
@AllArgsConstructor
@NoArgsConstructor
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "phone_number", nullable = false)
    private Long phoneNumber;

    @Size(max = 264)
    @Column(name = "email", length = 264)
    private String email;

    @Size(max = 370)
    @Column(name = "name_on_card", length = 370)
    private String nameOnCard;

    @Column(name = "inn", unique = true)
    private Long inn;

    @Column(name = "snils", unique = true)
    private Long snils;

    @NotNull
    @OneToOne(optional = false,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "passport_id", nullable = false)
    private PassportEntity passport;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "actual_registration_id")
    private ActualRegistrationEntity actualRegistration;
}
