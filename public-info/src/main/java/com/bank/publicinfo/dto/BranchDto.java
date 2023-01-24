package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.BranchEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * DTO для {@link BranchEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchDto implements Serializable {
    private Long id;
    private String address;
    private Long phoneNumber;
    private String city;
    private LocalTime startOfWork;
    private LocalTime endOfWork;
}
