package com.bank.dto;

import com.bank.model.PassportEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * TODO переписать на русском языке.
 * A DTO for the {@link PassportEntity} entity
 */
@Getter
@Setter
@NoArgsConstructor
// TODO добавить @AllArgsConstructor.
public class PassportDto implements Serializable {
    // TODO удали туду и оставь пустую строку.
    private Long id;
    // TODO удали туду и оставь пустую строку.
    @NotNull
    private Integer series;
    // TODO удали туду и оставь пустую строку.
    @NotNull
    private Long number;
    // TODO удали туду и оставь пустую строку.
    // TODO @Size(max = 255) и @NotNull поменяй местами.
    @Size(max = 255)
    @NotNull
    private String lastName;
    // TODO удали туду и оставь пустую строку.
    // TODO @Size(max = 255) и @NotNull поменяй местами.
    @Size(max = 255)
    @NotNull
    private String firstName;
    // TODO удали туду и оставь пустую строку.
    @Size(max = 255)
    private String middleName;
    // TODO удали туду и оставь пустую строку.
    // TODO @Size(max = 3) и @NotNull поменяй местами и пустую строку оставь.
    @Size(max = 3)
    @NotNull
    private String gender;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    // TODO удали туду и оставь пустую строку.
    @Size(max = 480)
    @NotNull
    private String birthPlace;
    // TODO удали туду и оставь пустую строку.
    @NotNull
    private String issuedBy;
    // TODO удали туду и оставь пустую строку.
    @NotNull
    // TODO что за @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy"), сделай без него.
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfIssue;
    // TODO удали туду и оставь пустую строку.
    @NotNull
    private Integer divisionCode;
    // TODO удали туду и оставь пустую строку.
    // TODO что за @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy"), сделай без него.
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate expirationDate;
    // TODO удали туду и оставь пустую строку.
    @NotNull
    private RegistrationDto registration;
}
