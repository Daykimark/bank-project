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
import java.sql.Timestamp;

/**
 * Entity для таблицы audit
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "audit", schema = "profile")
public class AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(max = 40)
    @Column(name = "entity_type")
    private String entityType;
    @NotNull
    @Size(max = 255)
    @Column(name = "operation_type")
    private String operationType;
    @NotNull
    @Size(max = 255)
    @Column(name = "created_by")
    private String createdBy;
    @Size(max = 255)
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
}
