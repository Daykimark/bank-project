package com.bank.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "passport", schema = "profile")
public class PassportEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name = "series")
    private Integer series;
    
    @NotNull
    @Column(name = "number")
    private Long number;
    
    @NotNull
    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;
    
    @NotNull
    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;
    
    @Size(max = 255)
    @Column(name = "middle_name")
    private String middleName;
    
    @NotNull
    @Size(max = 3)
    @Column(name = "gender")
    private String gender;
    
    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;
    
    @NotNull
    @Size(max = 480)
    @Column(name = "birth_place")
    private String birthPlace;
    
    @NotNull
    @Column(name = "issued_by")
    private String issuedBy;
    
    @NotNull
    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;
    
    @NotNull
    @Column(name = "division_code")
    private Integer divisionCode;
    
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    
    @NotNull
    @OneToOne(optional = false,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "registration_id")
    private RegistrationEntity registration;
}
