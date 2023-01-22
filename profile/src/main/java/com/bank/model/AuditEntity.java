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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;

/**
 * TODO Entity для таблицы audit.
 * Сущность, которая представляет таблицу audit
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// TODO @AllArgsConstructor и @NoArgsConstructor, поменяй местами с @Setter и @Entity.
@Entity
@Table(name = "audit", schema = "profile")
public class AuditEntity {
    // TODO туду удали и оставь пустую строку.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    // TODO поменяй @Size(max = 40) и @NotNull местами.
    @Size(max = 40)
    @NotNull
    @Column(name = "entity_type", nullable = false, length = 40)
    private String entityType;
    // TODO поменяй @Size(max = 255) и @NotNull местами.
    @Size(max = 255)
    @NotNull
    @Column(name = "operation_type", nullable = false)
    private String operationType;
    // TODO поменяй @Size(max = 255) и @NotNull местами.
    @Size(max = 255)
    @NotNull
    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Size(max = 255)
    @Column(name = "modified_by")
    private String modifiedBy;
    // TODO не OffsetDateTime, java.sql.Timestamp
    @NotNull
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;
    // TODO не OffsetDateTime, java.sql.Timestamp
    @Column(name = "modified_at")
    private OffsetDateTime modifiedAt;

    @Column(name = "new_entity_json")
    private String newEntityJson;

    @NotNull
    @Column(name = "entity_json", nullable = false)
    private String entityJson;
}
