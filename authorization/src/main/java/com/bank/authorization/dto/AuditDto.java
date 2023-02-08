package com.bank.authorization.dto;

import com.bank.authorization.entity.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO для {@link AuditEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// TODO добавь @FieldDefaults(level = AccessLevel.PRIVATE) и модификатор private удали в полях
public class AuditDto implements Serializable {

    private Long id;

    @NotNull
    private String entityType;

    @NotNull
    private String operationType;

    @NotNull
    private String createdBy;

    private String modifiedBy;

    @NotNull
    private Timestamp createdAt;

    private Timestamp modifiedAt;

    private String newEntityJson;

    @NotNull
    private String entityJson;
}
