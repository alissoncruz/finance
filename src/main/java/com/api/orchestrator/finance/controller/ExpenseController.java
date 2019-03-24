package com.api.orchestrator.finance.controller;

import com.api.orchestrator.finance.api.v1.ExpenseApi;
import com.api.orchestrator.finance.model.v1.ExpenseExpenseCodeTO;
import com.api.orchestrator.finance.model.v1.ExpenseExpenseResponseTO;
import com.api.orchestrator.finance.model.v1.ExpenseExpenseTO;
import com.api.orchestrator.finance.model.v1.ExpenseUpdateExpenseTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ExpenseController extends BaseRestController implements ExpenseApi {

    @Override
    public ResponseEntity<ExpenseExpenseCodeTO> createExpense(@Valid ExpenseExpenseTO newExpense) {
        return null;
    }

    @Override
    public ResponseEntity<ExpenseExpenseResponseTO> getExpense(String code) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateExpense(String code, @Valid ExpenseUpdateExpenseTO expense) {
        return null;
    }
}
