package com.bank.dto;

import com.bank.model.PassportEntity;
import lombok.AllArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public class PassportDto implements Serializable {
    private Long id;
    // TODO удали и оставь пустую строку.
    @NotNull
    private Integer series;
    // TODO удали и оставь пустую строку.
    @NotNull
    private Long number;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Size(max = 255)
    private String lastName;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Size(max = 255)
    private String firstName;
    // TODO удали и оставь пустую строку.
    @Size(max = 255)
    private String middleName;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Size(max = 3)
    private String gender;
    // TODO удали и оставь пустую строку.
    @NotNull
    private LocalDate birthDate;
    // TODO удали и оставь пустую строку.
    @Size(max = 480)
    // TODO @Size(max = 480) и @NotNull поменяй местами.
    @NotNull
    private String birthPlace;
    // TODO удали и оставь пустую строку.
    @NotNull
    private String issuedBy;
    // TODO удали и оставь пустую строку.
    @NotNull
    private LocalDate dateOfIssue;
    // TODO удали и оставь пустую строку.
    @NotNull
    private Integer divisionCode;
    // TODO удали и оставь пустую строку.
    private LocalDate expirationDate;
    // TODO удали и оставь пустую строку.
    @NotNull
    private RegistrationDto registration;
}
