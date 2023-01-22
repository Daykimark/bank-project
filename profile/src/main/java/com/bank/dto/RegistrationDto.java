package com.bank.dto;

import com.bank.model.RegistrationEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * TODO переписать на русском языке.
 * A DTO for the {@link RegistrationEntity} entity
 */
@Getter
@Setter
@NoArgsConstructor
// TODO добавить @AllArgsConstructor.
public class RegistrationDto implements Serializable {
    private Long id;
    // TODO @Size(max = 166) и @NotNull поменяй местами.
    @Size(max = 166)
    @NotNull
    private String country;

    @Size(max = 160)
    private String region;

    @Size(max = 160)
    private String city;

    @Size(max = 160)
    private String district;

    @Size(max = 230)
    private String locality;

    @Size(max = 230)
    private String street;

    @Size(max = 20)
    private String houseNumber;

    @Size(max = 20)
    private String houseBlock;

    @Size(max = 40)
    private String flatNumber;

    @NotNull
    private Long index;
}
