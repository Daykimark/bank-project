package com.bank.dto;

import com.bank.model.ProfileEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * TODO переписать на русском языке.
 * A DTO for the {@link ProfileEntity} entity
 */
@Getter
@Setter
@NoArgsConstructor
// TODO добавить @AllArgsConstructor.
public class ProfileDto implements Serializable {
    private Long id;
    // TODO удали туду и оставь пустую строку.
    @NotNull
    private Long phoneNumber;
    // TODO удали туду и оставь пустую строку.
    @Size(max = 264)
    private String email;
    // TODO удали туду и оставь пустую строку.
    @Size(max = 370)
    private String nameOnCard;
    // TODO удали туду и оставь пустую строку.
    private Long inn;
    private Long snils;
    // TODO удали туду и оставь пустую строку.
    @NotNull
    private PassportDto passport;
    // TODO удали туду и оставь пустую строку.
    private ActualRegistrationDto actualRegistration;
}
