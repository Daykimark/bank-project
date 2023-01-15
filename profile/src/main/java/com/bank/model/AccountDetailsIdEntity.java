package com.bank.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account_details_id", schema = "profile")
public class AccountDetailsIdEntity {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;


    @ManyToOne()

    private ProfileEntity profile;
}
