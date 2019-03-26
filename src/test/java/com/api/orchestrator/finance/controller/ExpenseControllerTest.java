package com.api.orchestrator.finance.controller;

import com.api.orchestrator.finance.model.Expense;
import com.api.orchestrator.finance.model.PaymentMethods;
import com.api.orchestrator.finance.service.ExpenseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.math.BigDecimal;

import static org.joda.time.DateTime.now;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ExpenseControllerTest extends BaseRestControllerTest {

    private final static String PATH = "http://test";
    private final static String CREATE_EXPENSE = PATH+"/expense";

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ExpenseService expenseService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void createExpense() throws Exception{

        when(expenseService.createExpense(any())).thenReturn(mockExpense());

        mockMvc.perform(post(CREATE_EXPENSE)
                .content(objectMapper.writeValueAsString(mockExpense()))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("Authorization", "Bearer JWT"))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    private Expense mockExpense(){
        return Expense
                .builder()
                .id("id")
                .category("category")
                .date(now())
                .user("user")
                .value(BigDecimal.TEN)
                .paymentMethods(
                        PaymentMethods
                                .builder()
                                .paymentAmount(BigDecimal.TEN)
                                .paymentMethod("CREDIT_CARD")
                                .build())
                .build();
    }
}
