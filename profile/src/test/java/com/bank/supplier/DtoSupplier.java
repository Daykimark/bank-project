package com.bank.supplier;


import com.bank.dto.AccountDetailsIdDto;
import com.bank.dto.ActualRegistrationDto;
import com.bank.dto.PassportDto;
import com.bank.dto.ProfileDto;
import com.bank.dto.RegistrationDto;

import java.time.LocalDate;

public class DtoSupplier {

    public ProfileDto getProfile(Long id, Long phoneNumber, String email,
                                 String nameOnCard, Long inn, Long snils,
                                 PassportDto passport, ActualRegistrationDto actualRegistration) {
        return new ProfileDto(id, phoneNumber, email, nameOnCard, inn, snils, passport, actualRegistration);
    }

    public AccountDetailsIdDto getAccountDetailsId(Long id, Long accountId, ProfileDto profile) {
        return new AccountDetailsIdDto(id, accountId, profile);
    }

    public ActualRegistrationDto getActualRegistration(Long id, String country, String region, String city,
                                                       String district, String locality, String street,
                                                       String houseNumber, String houseBlock, String flatNumber,
                                                       Long index) {
        return new ActualRegistrationDto(id, country, region, city, district, locality, street, houseNumber,
                houseBlock, flatNumber, index);
    }

    public PassportDto getPassport(Long id, Integer series, Long number, String lastName, String firstName,
                                   String middleName, String gender, LocalDate birthDate,
                                   String birthPlace, String issuedBy, LocalDate dateOfIssue,
                                   Integer divisionCode, LocalDate expirationDate,
                                   RegistrationDto registration) {
        return new PassportDto(id, series, number, lastName, firstName, middleName, gender, birthDate, birthPlace,
                issuedBy, dateOfIssue, divisionCode, expirationDate, registration);
    }

    public RegistrationDto getRegistration(Long id, String country, String region, String city, String district,
                                           String locality, String street, String houseNumber, String houseBlock,
                                           String flatNumber, Long index) {
        return new RegistrationDto(id, country, region, city, district, locality, street, houseNumber, houseBlock,
                flatNumber, index);
    }
}
