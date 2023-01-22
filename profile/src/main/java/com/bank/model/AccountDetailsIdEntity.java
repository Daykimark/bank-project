// TODO почему пакет назван model, если model, то там дто должны лежат, переименуй в entity.
package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TODO Entity для таблицы account_details_id.
 * Сущность которая представляет таблицу account_details_id
 */
// TODO удали пустую строку.
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// TODO @AllArgsConstructor и @NoArgsConstructor, поменяй местами с @Setter и @Entity.
@Entity
@Table(name = "account_details_id", schema = "profile")
public class AccountDetailsIdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // TODO Integer заменить на Long
    @Column(name = "account_id")
    private Integer accountId;

    @ManyToOne
    private ProfileEntity profile;
}
