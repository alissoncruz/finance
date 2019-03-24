package com.api.orchestrator.finance.document;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "paymentId")
public class Payment implements Serializable {

    private static final long serialVersionUID = -2026283261220757162L;

    private String paymentId;
    private String paymentMethod;
    private BigDecimal paymentAmount;
    private String installments;
    private String paymentEventStatus;
    private CardPaymentDetails cardPaymentDetails;
}
