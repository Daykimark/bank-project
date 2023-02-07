package com.bank.supplier;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.dto.ActualRegistrationDto;
import com.bank.dto.PassportDto;
import com.bank.dto.ProfileDto;
import com.bank.dto.RegistrationDto;

import java.time.LocalDate;

public class ControllerTestSupplier {

    public void setUpRegistrationController(RegistrationDto testDto1, RegistrationDto testDto2) {
        testDto1.setId(1L);
        testDto2.setId(2L);
    }

    public void setUpProfileController(ProfileDto testDto1, ProfileDto testDto2) {
        testDto1.setId(1L);
        PassportDto passportDto = new PassportDto();
        passportDto.setId(1L);
        passportDto.setSeries(89);
        passportDto.setDateOfIssue(LocalDate.now());
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setId(1L);
        registrationDto.setCountry("Russia");
        passportDto.setRegistration(registrationDto);
        testDto1.setPassport(passportDto);
        ActualRegistrationDto actualRegistrationDto = new ActualRegistrationDto();
        actualRegistrationDto.setId(1L);
        testDto1.setActualRegistration(actualRegistrationDto);

        testDto2.setId(2L);
        PassportDto passportDto1 = new PassportDto();
        passportDto1.setId(2L);
        passportDto1.setSeries(33);
        passportDto1.setDateOfIssue(LocalDate.now());
        RegistrationDto registrationDto1 = new RegistrationDto();
        registrationDto1.setId(2L);
        registrationDto1.setCountry("NOTRussia");
        passportDto1.setRegistration(registrationDto1);
        testDto2.setPassport(passportDto1);
        ActualRegistrationDto actualRegistrationDto1 = new ActualRegistrationDto();
        actualRegistrationDto1.setId(2L);
        testDto2.setActualRegistration(actualRegistrationDto1);
    }

    public void setUpPassportController(PassportDto testDto1, PassportDto testDto2) {
        testDto1.setId(1L);
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setId(1L);
        registrationDto.setCountry("Russia");
        testDto1.setRegistration(registrationDto);

        testDto2.setId(2L);
        RegistrationDto registrationDto2 = new RegistrationDto();
        registrationDto2.setId(2L);
        registrationDto2.setCountry("NOTRussia");
        testDto2.setRegistration(registrationDto2);
    }

    public void setUpActualRegistrationController(ActualRegistrationDto testDto1, ActualRegistrationDto testDto2) {
        testDto1.setId(1L);
        testDto2.setId(2L);
    }

    public void setUpAccountDetailsIdController(AccountDetailsIdDto testDto1, AccountDetailsIdDto testDto2) {
        ProfileDto profileDto1 = new ProfileDto();
        profileDto1.setId(1L);
        PassportDto passportDto = new PassportDto();
        passportDto.setId(1L);
        passportDto.setSeries(89);
        passportDto.setDateOfIssue(LocalDate.now());
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setId(1L);
        registrationDto.setCountry("Russia");
        passportDto.setRegistration(registrationDto);
        profileDto1.setPassport(passportDto);
        ActualRegistrationDto actualRegistrationDto = new ActualRegistrationDto();
        actualRegistrationDto.setId(1L);
        profileDto1.setActualRegistration(actualRegistrationDto);

        ProfileDto profileDto2 = new ProfileDto();
        profileDto2.setId(2L);
        PassportDto passportDto2 = new PassportDto();
        passportDto2.setId(2L);
        passportDto2.setSeries(33);
        passportDto2.setDateOfIssue(LocalDate.now());
        RegistrationDto registrationDto2 = new RegistrationDto();
        registrationDto2.setId(2L);
        registrationDto2.setCountry("Eng");
        passportDto2.setRegistration(registrationDto2);
        profileDto2.setPassport(passportDto2);
        ActualRegistrationDto actualRegistrationDto2 = new ActualRegistrationDto();
        actualRegistrationDto2.setId(2L);
        profileDto2.setActualRegistration(actualRegistrationDto2);

        testDto1.setId(1L);
        testDto2.setId(2L);
        testDto1.setProfile(profileDto1);
        testDto2.setProfile(profileDto2);
    }
}
