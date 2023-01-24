package com.bank.dto;

import com.bank.model.RegistrationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * ДТО для сущности {@link RegistrationEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto implements Serializable {
    private Long id;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Size(max = 166)
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
