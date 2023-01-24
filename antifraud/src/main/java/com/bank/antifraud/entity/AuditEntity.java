package com.bank.antifraud.entity;

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
import java.sql.Timestamp;
import java.util.Objects;

/**
 * entity для таблицы audit
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "audit", schema = "anti_fraud")
public class AuditEntity {

    @Id
    // TODO поменяй местами @Column(name = "id") и @GeneratedValue(strategy = GenerationType.IDENTITY).
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_type")
    private String entityType;

    @Column(name = "operation_type")
    private String operationType;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    @Column(name = "new_entity_json")
    private String newEntityJson;

    @Column(name = "entity_json")
    private String entityJson;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AuditEntity audit = (AuditEntity) o;
        return Objects.equals(id, audit.id) &&
                Objects.equals(entityType, audit.entityType) &&
                Objects.equals(operationType, audit.operationType) &&
                Objects.equals(createdBy, audit.createdBy) &&
                Objects.equals(modifiedBy, audit.modifiedBy) &&
                Objects.equals(createdAt, audit.createdAt) &&
                Objects.equals(modifiedAt, audit.modifiedAt) &&
                Objects.equals(newEntityJson, audit.newEntityJson) &&
                Objects.equals(entityJson, audit.entityJson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entityType, operationType, createdBy, modifiedBy,
                createdAt, modifiedAt, newEntityJson, entityJson);
    }
}
