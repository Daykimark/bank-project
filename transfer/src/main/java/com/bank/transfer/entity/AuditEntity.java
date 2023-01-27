package com.bank.transfer.entity;

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
 * Entity для таблицы audit
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "audit", schema = "transfer")
public class AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "entity_type")
    private String entityType;

    @NotNull
    @Column(name = "operation_type")
    private String operationType;

    @NotNull
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @NotNull
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    @Column(name = "new_entity_json")
    private String newEntityJson;

    @NotNull
    @Column(name = "entity_json")
    private String entityJson;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AuditEntity audit)) {
            return false;
        }
        return Objects.equals(getId(), audit.getId()) && Objects.equals(getEntityType(),
                audit.getEntityType()) && Objects.equals(getOperationType(),
                audit.getOperationType()) && Objects.equals(getCreatedBy(),
                audit.getCreatedBy()) && Objects.equals(getModifiedBy(),
                audit.getModifiedBy()) && Objects.equals(getCreatedAt(),
                audit.getCreatedAt()) && Objects.equals(getModifiedAt(),
                audit.getModifiedAt()) && Objects.equals(getNewEntityJson(),
                audit.getNewEntityJson()) && Objects.equals(getEntityJson(),
                audit.getEntityJson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEntityType(), getOperationType(), getCreatedBy(), getModifiedBy(),
                getCreatedAt(), getModifiedAt(), getNewEntityJson(), getEntityJson()
        );
    }
}
