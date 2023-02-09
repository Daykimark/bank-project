package com.bank.supplier;

import com.bank.entity.AccountDetailsIdEntity;
import com.bank.entity.ActualRegistrationEntity;
import com.bank.entity.PassportEntity;
import com.bank.entity.ProfileEntity;
import com.bank.entity.RegistrationEntity;

import java.time.LocalDate;

public class EntitySupplier {

    public ProfileEntity getProfile(Long id, Long phoneNumber, String email,
                                    String nameOnCard, Long inn, Long snils,
                                    PassportEntity passport, ActualRegistrationEntity actualRegistration) {
        return new ProfileEntity(id, phoneNumber, email, nameOnCard, inn, snils, passport, actualRegistration);
    }

    public AccountDetailsIdEntity getAccountDetailsId(Long id, Long accountId, ProfileEntity profile) {
        return new AccountDetailsIdEntity(id, accountId, profile);
    }

    public ActualRegistrationEntity getActualRegistration(Long id, String country, String region, String city,
                                                          String district, String locality, String street,
                                                          String houseNumber, String houseBlock, String flatNumber,
                                                          Long index) {
        return new ActualRegistrationEntity(id, country, region, city, district, locality, street, houseNumber,
                houseBlock, flatNumber, index);
    }

    public PassportEntity getPassport(Long id, Integer series, Long number, String lastName, String firstName,
                                      String middleName, String gender, LocalDate birthDate,
                                      String birthPlace, String issuedBy, LocalDate dateOfIssue,
                                      Integer divisionCode, LocalDate expirationDate,
                                      RegistrationEntity registration) {
        return new PassportEntity(id, series, number, lastName, firstName, middleName, gender, birthDate, birthPlace,
                issuedBy, dateOfIssue, divisionCode, expirationDate, registration);
    }

    public RegistrationEntity getRegistration(Long id, String country, String region, String city, String district,
                                              String locality, String street, String houseNumber, String houseBlock,
                                              String flatNumber, Long index) {
        return new RegistrationEntity(id, country, region, city, district, locality, street, houseNumber, houseBlock,
                flatNumber, index);
    }
}
