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
@Table(name = "profile", schema = "profile")
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

    @Column(name = "inn")
    private Long inn;

    @Column(name = "snils")
    private Long snils;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "passport_id", nullable = false)
    private PassportEntity passportEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actual_registration_id")
    private ActualRegistrationEntity actualRegistrationEntity;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private Set<AccountDetailsIdEntity> accountDetails = new LinkedHashSet<>();

}