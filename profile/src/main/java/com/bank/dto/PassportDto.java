package com.bank.dto;

import com.bank.entity.PassportEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * ДТО для сущности {@link PassportEntity}
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PassportDto implements Serializable {
    private Long id;
    
    @NotNull
    private Integer series;
    
    @NotNull
    private Long number;
    
    @NotNull
    @Size(max = 255)
    private String lastName;
    
    @NotNull
    @Size(max = 255)
    private String firstName;
    
    @Size(max = 255)
    private String middleName;
    
    @NotNull
    @Size(max = 3)
    private String gender;
    
    @NotNull
    private LocalDate birthDate;

    @NotNull
    @Size(max = 480)
    private String birthPlace;
    
    @NotNull
    private String issuedBy;
    
    @NotNull
    private LocalDate dateOfIssue;
    
    @NotNull
    private Integer divisionCode;
    
    private LocalDate expirationDate;
    
    @NotNull
    private RegistrationDto registration;
}
