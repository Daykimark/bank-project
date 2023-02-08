package com.bank.publicinfo.supplier;

public class ControllerSupplier {

    public String createAtm() {
        return "{\"id\": 1, " +
                "\"address\": \"test\", " +
                "\"startOfWork\": \"12:00:00\", " +
                "\"endOfWork\": \"14:00:00\", " +
                "\"allHours\": true, " +
                "\"branch\": " +
                "{\"id\": 1, " +
                "\"address\": \"test\", " +
                "\"phoneNumber\": 89094747489, " +
                "\"city\": \"test\", " +
                "\"startOfWork\": \"12:00:00\", " +
                "\"endOfWork\": \"12:00:00\"}}";
    }

    public String[] readAtmById() {
        return new String[]{"2", "test", "12:00:00", "14:00:00", "true",
                "branch", "2", "test", "890945496578", "test", "12:00:00", "14:00:00"};
    }

    public String[] readAtmAllById() {
        return new String[]{"3", "test", "12:00:00", "14:00:00", "true",
                "branch", "3", "test", "85054649895", "test", "12:00:00", "12:00:00",
                "4", "test", "12:00:00", "14:00:00", "true",
                "branch", "3", "test", "85054649895", "test", "12:00:00", "12:00:00"};
    }

    public String updateAtm() {
        return "{\"id\": 5, " +
                "\"address\": \"test\", " +
                "\"startOfWork\": \"12:00:00\", " +
                "\"endOfWork\": \"14:00:00\", " +
                "\"allHours\": true, " +
                "\"branch\": " +
                "{\"id\": 4, " +
                "\"address\": \"test\", " +
                "\"phoneNumber\": 8555646567, " +
                "\"city\": \"test\", " +
                "\"startOfWork\": \"12:00:00\", " +
                "\"endOfWork\": \"12:00:00\"}}";
    }

    public String[] updatedAtm() {
        return new String[]{"5", "test", "12:00:00", "14:00:00", "true",
                "branch", "4", "test", "8555646567", "test", "12:00:00", "14:00:00"};
    }

    public String createBankDetails() {
        return "{\"id\": 1, " +
                "\"bik\": 1413235, " +
                "\"inn\": 14115252, " +
                "\"kpp\": 42342342, " +
                "\"corAccount\": 6234234, " +
                "\"city\": \"moscow\", " +
                "\"jointStockCompany\": \"sber\", " +
                "\"name\": \"test\"}";
    }

    public String[] readBankDetailsById() {
        return new String[]{"2", "11111", "22222", "33333", "4444444", "sochi", "vtb", "test"};
    }

    public String[] readAllBankDetailsById() {
        return new String[]{"3", "131231", "1231313", "1231411", "4155151", "sochi", "vtb", "test",
                "4", "5634634", "12313", "123133", "123131", "sochi", "vtb", "test"};
    }

    public String updateBankDetails() {
        return "{\"id\": 5, " +
                "\"bik\": 3133131, " +
                "\"inn\": 525252, " +
                "\"kpp\": 1312314, " +
                "\"corAccount\": 1231445, " +
                "\"city\": \"samara\", " +
                "\"jointStockCompany\": \"vtb\", " +
                "\"name\": \"test\"}";
    }

    public String[] updatedBankDetails() {
        return new String[]{"5", "3133131", "525252", "1312314", "1231445", "samara", "vtb", "test"};
    }

    public String createBranch() {
        return "{\"id\": 2, " +
                "\"address\": \"test\", " +
                "\"phoneNumber\": 1231231, " +
                "\"city\": \"moscow\", " +
                "\"startOfWork\": \"12:00:00\", " +
                "\"endOfWork\": \"13:00:00\"}";
    }

    public String[] readBranchById() {
        return new String[]{"2", "test", "890945496578", "test", "12:00:00", "14:00:00"};
    }

    public String[] readAllBranchesById() {
        return new String[]{"2", "test", "890945496578", "test", "12:00:00", "14:00:00",
                "3", "test", "85054649895", "test", "12:00:00", "12:00:00"};
    }

    public String updateBranch() {
        return "{\"id\": 3, " +
                "\"address\": \"test\", " +
                "\"phoneNumber\": 85054649895, " +
                "\"city\": \"krasnodar\", " +
                "\"startOfWork\": \"12:00:00\", " +
                "\"endOfWork\": \"13:00:00\"}";
    }

    public String[] updatedBranch() {
        return new String[]{"3", "test", "85054649895", "krasnodar", "12:00:00", "13:00:00"};
    }

    public String createCertificate() {
        return "{\"id\": 1, " +
                "\"photoCertificate\": [1,3,4,5,6,7,8,9,0,0], " +
                "\"bankDetails\": " +
                "{\"id\": 2, " +
                "\"bik\": 11111, " +
                "\"inn\": 22222, " +
                "\"kpp\": 33333, " +
                "\"corAccount\": 4444444," +
                "\"city\": \"sochi\", " +
                "\"jointStockCompany\": \"vtb\", " +
                "\"name\":  \"test\"}}";
    }

    public String[] readCertificateById() {
        return new String[]{"2", "-34,-83,-66,-17", "bankDetails",
                "2", "11111", "22222", "33333", "4444444", "sochi", "vtb", "test"};
    }

    public String[] readAllCertificatesById() {
        return new String[]{"2", "-34,-83,-66,-17", "bankDetails",
                "2", "11111", "22222", "33333", "4444444", "sochi", "vtb", "test",
                "3", "-34,-83,-66,-17", "bankDetails",
                "2", "11111", "22222", "33333", "4444444", "sochi", "vtb", "test"};
    }

    public String updateCertificate() {
        return "{\"id\": 2, " +
                "\"photoCertificate\": [-34,-83,-66,-52], " +
                "\"bankDetails\": " +
                "{\"id\": 2, " +
                "\"bik\": 11111, " +
                "\"inn\": 22222, " +
                "\"kpp\": 33333, " +
                "\"corAccount\": 4444444," +
                "\"city\": \"sochi\", " +
                "\"jointStockCompany\": \"vtb\", " +
                "\"name\":  \"test\"}}";
    }

    public String[] updatedCertificate() {
        return new String[]{"2", "-34,-83,-66,-52", "bankDetails",
                "2", "11111", "22222", "33333", "4444444", "sochi", "vtb", "test"};
    }

    public String createLicense() {
        return "{\"id\": 1, " +
                "\"photoLicense\": [1,3,4,5,6,7,8,9,0,0], " +
                "\"bankDetails\": " +
                "{\"id\": 2, " +
                "\"bik\": 11111, " +
                "\"inn\": 22222, " +
                "\"kpp\": 33333, " +
                "\"corAccount\": 4444444," +
                "\"city\": \"sochi\", " +
                "\"jointStockCompany\": \"vtb\", " +
                "\"name\":  \"test\"}}";
    }

    public String[] readLicenseById() {
        return new String[]{"2", "-34,-83,-66,-17", "bankDetails",
                "2", "11111", "22222", "33333", "4444444", "sochi", "vtb", "test"};
    }

    public String[] readAllLicensesById() {
        return new String[]{"2", "-34,-83,-66,-17", "bankDetails",
                "2", "11111", "22222", "33333", "4444444", "sochi", "vtb", "test",
                "3", "-34,-83,-66,-17", "bankDetails",
                "2", "11111", "22222", "33333", "4444444", "sochi", "vtb", "test"};
    }

    public String updateLicense() {
        return "{\"id\": 2, " +
                "\"photoLicense\": [-34,-83,-66,-52], " +
                "\"bankDetails\": " +
                "{\"id\": 2, " +
                "\"bik\": 11111, " +
                "\"inn\": 22222, " +
                "\"kpp\": 33333, " +
                "\"corAccount\": 4444444," +
                "\"city\": \"sochi\", " +
                "\"jointStockCompany\": \"vtb\", " +
                "\"name\":  \"test\"}}";
    }

    public String[] updatedLicense() {
        return new String[]{"2", "-34,-83,-66,-52", "bankDetails",
                "2", "11111", "22222", "33333", "4444444", "sochi", "vtb", "test"};
    }
}
