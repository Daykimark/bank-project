package com.bank.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import com.bank.model.PassportEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * A DTO for the {@link PassportEntity} entity
 */
@Data
public class PassportDto implements Serializable {
    private Long id;
    @NotNull
    private Integer series;
    @NotNull
    private Long number;
    @Size(max = 255)
    @NotNull
    private String lastName;
    @Size(max = 255)
    @NotNull
    private String firstName;
    @Size(max = 255)
    private String middleName;
    @Size(max = 3)
    @NotNull
    private String gender;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")      private LocalDate birthDate;
    @Size(max = 480)
    @NotNull
    private String birthPlace;
    @NotNull
    private String issuedBy;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfIssue;
    @NotNull
    private Integer divisionCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate expirationDate;
    @NotNull
    private RegistrationDto registration;
    @NotNull
    private Set<ProfileDto> profiles;
}