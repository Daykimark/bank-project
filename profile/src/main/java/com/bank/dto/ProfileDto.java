package com.bank.dto;

import com.bank.model.ProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * ДТО для сущности {@link ProfileEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto implements Serializable {
    private Long id;
    // TODO удали и оставь пустую строку.
    @NotNull
    private Long phoneNumber;
    // TODO удали и оставь пустую строку.
    @Size(max = 264)
    private String email;
    // TODO удали и оставь пустую строку.
    @Size(max = 370)
    private String nameOnCard;
    // TODO удали и оставь пустую строку.
    private Long inn;
    private Long snils;
    // TODO удали и оставь пустую строку.
    @NotNull
    private PassportDto passport;
    // TODO удали и оставь пустую строку.
    private ActualRegistrationDto actualRegistration;
}
