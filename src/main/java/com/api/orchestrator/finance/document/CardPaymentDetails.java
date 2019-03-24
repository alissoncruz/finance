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
public class CardPaymentDetails implements Serializable {

    private static final long serialVersionUID = 8183075196151363238L;

    private CardDetails cardDetails;
    private CardData cardData;


}
