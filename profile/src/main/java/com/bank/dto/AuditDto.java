package com.bank.dto;

import com.bank.model.AuditEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * TODO переписать на русском языке.
 * A DTO for the {@link AuditEntity} entity
 */
@Getter
@Setter
@NoArgsConstructor
// TODO добавить @AllArgsConstructor.
public class AuditDto implements Serializable {
    private Long id;
    // TODO @Size(max = 40) и @NotNull поменяй местами.
    @Size(max = 40)
    @NotNull
    private String entityType;
    // TODO @Size(max = 255) и @NotNull поменяй местами.
    @Size(max = 255)
    @NotNull
    private String operationType;
    // TODO @Size(max = 255) и @NotNull поменяй местами.
    @Size(max = 255)
    @NotNull
    private String createdBy;
    @Size(max = 255)
    private String modifiedBy;
    @NotNull
    // TODO не OffsetDateTime, java.sql.Timestamp
    private OffsetDateTime createdAt;
    // TODO не OffsetDateTime, java.sql.Timestamp
    private OffsetDateTime modifiedAt;
    private String newEntityJson;
    @NotNull
    private String entityJson;
}
