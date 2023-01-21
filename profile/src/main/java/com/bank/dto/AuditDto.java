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
 * A DTO for the {@link AuditEntity} entity
 */
@Getter
@Setter
@NoArgsConstructor
public class AuditDto implements Serializable {
    private Long id;
    @Size(max = 40)
    @NotNull
    private String entityType;
    @Size(max = 255)
    @NotNull
    private String operationType;
    @Size(max = 255)
    @NotNull
    private String createdBy;
    @Size(max = 255)
    private String modifiedBy;
    @NotNull
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;
    private String newEntityJson;
    @NotNull
    private String entityJson;
}
