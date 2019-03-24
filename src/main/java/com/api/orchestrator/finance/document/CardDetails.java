package com.api.orchestrator.finance.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDetails implements Serializable {

    private static final long serialVersionUID = -3534136397948977916L;

    private String cardHolderName;
    private String brand;
    private String cardType;
    private String maskedCardNumber;
    private String expirationDate;
    private String bin;
}
