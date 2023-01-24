package com.bank.dto;

import com.bank.model.ActualRegistrationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * ДТО для сущности {@link ActualRegistrationEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActualRegistrationDto implements Serializable {
    private Long id;
    // TODO удали и оставь пустую строку.
    @NotNull
    @Size(max = 40)
    private String country;
    // TODO удали и оставь пустую строку.
    @Size(max = 160)
    private String region;
    // TODO удали и оставь пустую строку.
    @Size(max = 160)
    private String city;
    // TODO удали и оставь пустую строку.
    @Size(max = 160)
    private String district;
    // TODO удали и оставь пустую строку.
    @Size(max = 230)
    private String locality;
    // TODO удали и оставь пустую строку.
    @Size(max = 230)
    private String street;
    // TODO удали и оставь пустую строку.
    @Size(max = 20)
    private String houseNumber;
    // TODO удали и оставь пустую строку.
    @Size(max = 20)
    private String houseBlock;
    // TODO удали и оставь пустую строку.
    @Size(max = 40)
    private String flatNumber;
    // TODO удали и оставь пустую строку.
    @NotNull
    private Long index;
}
