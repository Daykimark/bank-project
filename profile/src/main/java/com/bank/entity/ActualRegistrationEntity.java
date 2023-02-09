package com.bank.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity для таблицы actual_registration
 */
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actual_registration", schema = "profile")
public class ActualRegistrationEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(max = 40)
    @Column(name = "country")
    private String country;

    @Size(max = 160)
    @Column(name = "region")
    private String region;
    
    @Size(max = 160)
    @Column(name = "city")
    private String city;
    
    @Size(max = 160)
    @Column(name = "district")
    private String district;
    
    @Size(max = 230)
    @Column(name = "locality")
    private String locality;
    
    @Size(max = 230)
    @Column(name = "street")
    private String street;
    
    @Size(max = 20)
    @Column(name = "house_number")
    private String houseNumber;
    
    @Size(max = 20)
    @Column(name = "house_block")
    private String houseBlock;
    
    @Size(max = 40)
    @Column(name = "flat_number")
    private String flatNumber;
    
    @NotNull
    @Column(name = "index")
    private Long index;
}
