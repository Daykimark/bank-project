package com.bank.publicinfo.supplier;

import com.bank.publicinfo.dto.AtmDto;
import com.bank.publicinfo.dto.BankDetailsDto;
import com.bank.publicinfo.dto.BranchDto;
import com.bank.publicinfo.dto.CertificateDto;
import com.bank.publicinfo.dto.LicenseDto;
import com.bank.publicinfo.entity.AtmEntity;
import com.bank.publicinfo.entity.BankDetailsEntity;
import com.bank.publicinfo.entity.BranchEntity;
import com.bank.publicinfo.entity.CertificateEntity;
import com.bank.publicinfo.entity.LicenseEntity;

import java.time.LocalTime;

public class MapperSupplier {
    public AtmEntity supplyAtm(Long id, String address, LocalTime startOfWork,
                               LocalTime endOfWork, Boolean allHours, BranchEntity branch) {
        return new AtmEntity(id, address, startOfWork, endOfWork, allHours, branch);
    }

    public AtmDto supplyAtmDto(Long id, String address, LocalTime startOfWork,
                               LocalTime endOfWork, Boolean allHours, BranchDto branch) {
        return new AtmDto(id, address, startOfWork, endOfWork, allHours, branch);
    }

    public BankDetailsEntity supplyBankDetails(Long id, Long bik, Long inn, Long kpp, Integer corAccount,
                                               String city, String jointStockCompany, String name){
        return new BankDetailsEntity(id, bik, inn, kpp, corAccount, city, jointStockCompany, name);
    }

    public BankDetailsDto supplyBankDetailsDto(Long id, Long bik, Long inn, Long kpp, Integer corAccount,
                                               String city, String jointStockCompany, String name){
        return new BankDetailsDto(id, bik, inn, kpp, corAccount, city, jointStockCompany, name);
    }

    public BranchEntity supplyBranch(Long id, String address, Long phoneNumber, String city,
                                     LocalTime startOfWork, LocalTime endOfWork){
        return new BranchEntity(id, address, phoneNumber, city, startOfWork, endOfWork);
    }

    public BranchDto supplyBranchDto(Long id, String address, Long phoneNumber, String city,
                                     LocalTime startOfWork, LocalTime endOfWork){
        return new BranchDto(id, address, phoneNumber, city, startOfWork, endOfWork);
    }

    public CertificateEntity supplyCertificate(Long id, Byte[] photoCertificate, BankDetailsEntity bankDetails){
        return new CertificateEntity(id, photoCertificate, bankDetails);
    }

    public CertificateDto supplyCertificateDto(Long id, Byte[] photoCertificate, BankDetailsDto dto){
        return new CertificateDto(id, photoCertificate, dto);
    }

    public LicenseEntity supplyLicense(Long id, Byte[] photoLicense, BankDetailsEntity bankDetails){
        return new LicenseEntity(id, photoLicense, bankDetails);
    }

    public LicenseDto supplyLicenseDto(Long id, Byte[] photoLicense, BankDetailsDto dto){
        return new LicenseDto(id, photoLicense, dto);
    }
}
