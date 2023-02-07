package com.bank.supplier;

import com.bank.dto.AccountDetailsIdDto;
import com.bank.dto.ActualRegistrationDto;
import com.bank.dto.PassportDto;
import com.bank.dto.ProfileDto;
import com.bank.dto.RegistrationDto;
import com.bank.entity.AccountDetailsIdEntity;
import com.bank.entity.ActualRegistrationEntity;
import com.bank.entity.PassportEntity;
import com.bank.entity.ProfileEntity;
import com.bank.entity.RegistrationEntity;

public class MapperTestSupplier {

    public void setUpRegistrationMapper(RegistrationEntity testEntity, RegistrationDto testDto) {
        testEntity.setId(1L);
        testEntity.setCity("London");

        testDto.setId(1L);
        testDto.setCity("London");
    }

    public void setUpProfileMapper(ProfileEntity testEntity, ProfileDto testDto) {
        testEntity.setPhoneNumber(283992L);
        testEntity.setId(1L);
        PassportEntity passportEntity = new PassportEntity();
        passportEntity.setId(1L);
        passportEntity.setBirthPlace("Russia");
        passportEntity.setSeries(89);
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setId(1L);
        registrationEntity.setCountry("Russia");
        passportEntity.setRegistration(registrationEntity);
        testEntity.setPassport(passportEntity);
        ActualRegistrationEntity actualRegistrationEntity = new ActualRegistrationEntity();
        actualRegistrationEntity.setId(1L);
        testEntity.setActualRegistration(actualRegistrationEntity);

        testDto.setPhoneNumber(283992L);
        testDto.setId(1L);
        PassportDto passportDto = new PassportDto();
        passportDto.setId(1L);
        passportDto.setBirthPlace("Russia");
        passportDto.setSeries(89);
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setId(1L);
        registrationDto.setCountry("Russia");
        passportDto.setRegistration(registrationDto);
        testDto.setPassport(passportDto);
        ActualRegistrationDto actualRegistrationDto = new ActualRegistrationDto();
        actualRegistrationDto.setId(1L);
        testDto.setActualRegistration(actualRegistrationDto);
    }

    public void setUpPassportMapper(PassportEntity testEntity, PassportDto testDto) {
        testEntity.setGender("MUZ");
        testEntity.setId(1L);
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setId(1L);
        registrationEntity.setCountry("Russia");
        testEntity.setRegistration(registrationEntity);

        testDto.setGender("MUZ");
        testDto.setId(1L);
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setId(1L);
        registrationDto.setCountry("Russia");
        testDto.setRegistration(registrationDto);
    }

    public void setUpActualRegistrationMapper(ActualRegistrationEntity testEntity, ActualRegistrationDto testDto) {
        testEntity.setId(1L);
        testEntity.setIndex(23L);
        testEntity.setCity("Gorod");

        testDto.setId(1L);
        testDto.setIndex(23L);
        testDto.setCity("Gorod");
    }

    public void setUpAccountDetailsIdMapper(AccountDetailsIdEntity testEntity, AccountDetailsIdDto testDto) {
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setId(1L);
        PassportEntity passportEntity = new PassportEntity();
        passportEntity.setId(1L);
        passportEntity.setBirthPlace("Russia");
        passportEntity.setSeries(89);
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setId(1L);
        registrationEntity.setCountry("Russia");
        passportEntity.setRegistration(registrationEntity);
        profileEntity.setPassport(passportEntity);
        ActualRegistrationEntity actualRegistrationEntity = new ActualRegistrationEntity();
        actualRegistrationEntity.setId(1L);
        profileEntity.setActualRegistration(actualRegistrationEntity);

        testEntity.setId(1L);
        testEntity.setProfile(profileEntity);

        ProfileDto profileDto = new ProfileDto();
        profileDto.setId(1L);
        PassportDto passportDto = new PassportDto();
        passportDto.setId(1L);
        passportDto.setBirthPlace("Russia");
        passportDto.setSeries(89);
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setId(1L);
        registrationDto.setCountry("Russia");
        passportDto.setRegistration(registrationDto);
        profileDto.setPassport(passportDto);
        ActualRegistrationDto actualRegistrationDto = new ActualRegistrationDto();
        actualRegistrationDto.setId(1L);
        profileDto.setActualRegistration(actualRegistrationDto);

        testDto.setId(1L);
        testDto.setProfile(profileDto);
    }
}
