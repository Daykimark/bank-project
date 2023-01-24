package com.bank.publicinfo.entity;

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
import java.sql.Timestamp;
import java.util.Objects;

/**
 * TODO исправь энтити на entity.
 * энтити для таблицы "audit"
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "audit", schema = "public_bank_information")
public class AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "entity_type")
    private String entityType;

    @Column(name = "operation_type")
    private String operationType;

    @Column(name = "created_by")
    private String createdBy;

    @NotNull
    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @NotNull
    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    @NotNull
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
        return id.equals(audit.id) &&
                entityType.equals(audit.entityType) &&
                operationType.equals(audit.operationType) &&
                createdBy.equals(audit.createdBy) &&
                modifiedBy.equals(audit.modifiedBy) &&
                createdAt.equals(audit.createdAt) &&
                modifiedAt.equals(audit.modifiedAt) &&
                newEntityJson.equals(audit.newEntityJson) &&
                entityJson.equals(audit.entityJson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entityType, operationType, createdBy, modifiedBy, createdAt,
                modifiedAt, newEntityJson, entityJson);
    }
}
