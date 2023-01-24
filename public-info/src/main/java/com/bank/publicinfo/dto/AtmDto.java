package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.AtmEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * DTO для {@link AtmEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtmDto implements Serializable {
    private Long id;
    private String address;
    private LocalTime startOfWork;
    private LocalTime endOfWork;
    private Boolean allHours;
    private BranchDto branch;
}
