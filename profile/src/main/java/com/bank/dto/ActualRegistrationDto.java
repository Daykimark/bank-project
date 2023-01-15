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
 * A DTO for the {@link ActualRegistrationEntity} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActualRegistrationDto implements Serializable {
    private Long id;
    @Size(max = 40)
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
