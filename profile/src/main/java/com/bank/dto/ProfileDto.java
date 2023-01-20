package com.bank.dto;

import com.bank.model.ProfileEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link ProfileEntity} entity
 */
@Data
public class ProfileDto implements Serializable {
    private Long id;
    @NotNull
    private Long phoneNumber;
    @Size(max = 264)
    private String email;
    @Size(max = 370)
    private String nameOnCard;
    private Long inn;
    private Long snils;
    @NotNull
    private PassportDto passport;
    private ActualRegistrationDto actualRegistration;
}