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
public class CardData implements Serializable {

    private static final long serialVersionUID = 527812660214411304L;

    private String paymentToken;
    private boolean saveCard;
    private String paymentHashData;
    private boolean alreadySaved;
    private String cvv;

}
