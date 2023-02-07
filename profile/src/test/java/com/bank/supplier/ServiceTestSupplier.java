package com.bank.supplier;

import com.bank.entity.AccountDetailsIdEntity;
import com.bank.entity.ActualRegistrationEntity;
import com.bank.entity.PassportEntity;
import com.bank.entity.ProfileEntity;
import com.bank.entity.RegistrationEntity;

import java.time.LocalDate;

public class ServiceTestSupplier {

    public void setUpRegistrationService(RegistrationEntity registration1, RegistrationEntity registration2) {
        registration1.setId(1L);
        registration1.setId(2L);
    }

    public void setUpProfileService(ProfileEntity profile1, ProfileEntity profile2) {
        profile1.setId(1L);
        PassportEntity passport = new PassportEntity();
        passport.setId(1L);
        passport.setSeries(89);
        passport.setDateOfIssue(LocalDate.now());
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setId(1L);
        registrationEntity.setCountry("Russia");
        passport.setRegistration(registrationEntity);
        profile1.setPassport(passport);
        ActualRegistrationEntity actualRegistrationEntity = new ActualRegistrationEntity();
        actualRegistrationEntity.setId(1L);
        profile1.setActualRegistration(actualRegistrationEntity);

        profile2.setId(2L);
        PassportEntity passport2 = new PassportEntity();
        passport2.setId(2L);
        passport2.setSeries(33);
        passport2.setDateOfIssue(LocalDate.now());
        RegistrationEntity registrationEntity2 = new RegistrationEntity();
        registrationEntity2.setId(2L);
        registrationEntity2.setCountry("NOTRussia");
        passport2.setRegistration(registrationEntity2);
        profile2.setPassport(passport2);
        ActualRegistrationEntity actualRegistrationEntity2 = new ActualRegistrationEntity();
        actualRegistrationEntity2.setId(2L);
        profile2.setActualRegistration(actualRegistrationEntity2);
    }

    public void setUpPassportService(PassportEntity passport1, PassportEntity passport2) {
        passport1.setId(1L);
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setId(1L);
        registrationEntity.setCountry("Russia");
        passport1.setRegistration(registrationEntity);

        passport2.setId(2L);
        RegistrationEntity registrationEntity2 = new RegistrationEntity();
        registrationEntity2.setId(2L);
        registrationEntity2.setCountry("NOTRussia");
        passport2.setRegistration(registrationEntity2);
    }

    public void setUpActualRegistrationService(ActualRegistrationEntity actualRegistration1,
                                               ActualRegistrationEntity actualRegistration2) {
        actualRegistration1.setId(1L);
        actualRegistration2.setId(2L);
    }

    public void setUpAccountDetailsId(AccountDetailsIdEntity accountDetailsId1,
                                      AccountDetailsIdEntity accountDetailsId2) {

        ProfileEntity profile1 = new ProfileEntity();
        profile1.setId(1L);
        PassportEntity passportEntity = new PassportEntity();
        passportEntity.setId(1L);
        passportEntity.setSeries(89);
        passportEntity.setDateOfIssue(LocalDate.now());
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setId(1L);
        registrationEntity.setCountry("Russia");
        passportEntity.setRegistration(registrationEntity);
        profile1.setPassport(passportEntity);
        ActualRegistrationEntity actualRegistrationEntity = new ActualRegistrationEntity();
        actualRegistrationEntity.setId(1L);
        profile1.setActualRegistration(actualRegistrationEntity);

        ProfileEntity profile2 = new ProfileEntity();
        profile2.setId(2L);
        PassportEntity passport2 = new PassportEntity();
        passport2.setId(2L);
        passport2.setSeries(33);
        passport2.setDateOfIssue(LocalDate.now());
        RegistrationEntity registrationEntity2 = new RegistrationEntity();
        registrationEntity2.setId(2L);
        registrationEntity2.setCountry("NOTRussia");
        passport2.setRegistration(registrationEntity2);
        profile2.setPassport(passport2);
        ActualRegistrationEntity actualRegistrationEntity2 = new ActualRegistrationEntity();
        actualRegistrationEntity2.setId(2L);
        profile2.setActualRegistration(actualRegistrationEntity2);

        accountDetailsId1.setAccountId(1L);
        accountDetailsId2.setAccountId(2L);
        accountDetailsId1.setProfile(profile1);
        accountDetailsId2.setProfile(profile2);
    }
}
