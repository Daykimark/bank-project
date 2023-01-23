package com.bank.antifraud.dto;

import com.bank.antifraud.entity.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Dto для {@link AuditEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditEntityDto implements Serializable {
    private Long id;
    private String entityType;
    private String operationType;
    private String createdBy;
    private String modifiedBy;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private String newEntityJson;
    private String entityJson;
}
