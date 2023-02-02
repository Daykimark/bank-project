package com.bank.account.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * Entity для таблицы audit.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "audit", schema = "account")
public class AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Size(max = 40)
    @Column(name = "entity_type", nullable = false, length = 40)
    String entityType;

    @Size(max = 255)
    @Column(name = "operation_type", nullable = false)
    String operationType;

    @Size(max = 255)
    @Column(name = "created_by", nullable = false)
    String createdBy;

    @Size(max = 255)
    @Column(name = "modified_by")
    String modifiedBy;

    @Column(name = "created_at", nullable = false)
    Timestamp createdAt;

    @Column(name = "modified_at")
    Timestamp modifiedAt;

    @Column(name = "new_entity_json")
    String newEntityJson;

    @Column(name = "entity_json", nullable = false)
    String entityJson;
}
