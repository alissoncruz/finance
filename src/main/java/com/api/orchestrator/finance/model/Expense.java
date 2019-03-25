package com.api.orchestrator.finance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Expense")
public class Expense {

    @Id
    private String id;
    private String description;
    private BigDecimal value;
    private String user;
    private String category;
    private DateTime date;

    private PaymentMethods paymentMethods;
}
