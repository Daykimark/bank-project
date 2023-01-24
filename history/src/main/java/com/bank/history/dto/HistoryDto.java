package com.bank.history.dto;

import com.bank.history.entity.HistoryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * ДТО {@link HistoryEntity}.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoryDto implements Serializable {
    private Long id;
    private Long transferAuditId;
    private Long profileAuditId;
    private Long accountAuditId;
    private Long antiFraudAuditId;
    private Long publicBankInfoAuditId;
    private Long authorizationAuditId;
}
