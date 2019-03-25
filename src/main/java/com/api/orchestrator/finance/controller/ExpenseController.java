package com.api.orchestrator.finance.controller;

import com.api.orchestrator.finance.api.v1.ExpenseApi;
import com.api.orchestrator.finance.model.v1.*;
import io.swagger.annotations.ApiParam;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.owasp.esapi.Logger.EVENT_UNSPECIFIED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class ExpenseController extends BaseRestController implements ExpenseApi {

    private final Logger log = ESAPI.getLogger(getClass());

    @Override
    public ResponseEntity<ExpenseExpenseCodeTO> createExpense(@Valid @RequestBody ExpenseExpenseTO newExpense) {
        log.info(EVENT_UNSPECIFIED, "Start method createExpense");

        log.info(EVENT_UNSPECIFIED, "Finish method createExpense");
        ExpenseExpenseCodeTO response = new ExpenseExpenseCodeTO();

        response.setCode("0001");
        return new ResponseEntity<>(response, CREATED);
    }

    @Override
    public ResponseEntity<ExpenseResponseExpensesTO> getExpense(@PathVariable("code") String code) {

        log.info(EVENT_UNSPECIFIED, "Start method getExpense");

        log.info(EVENT_UNSPECIFIED, "Finish method getExpense");
        ExpenseResponseExpensesTO response = new ExpenseResponseExpensesTO();

        return new ResponseEntity<>(response, OK);
    }


    @Override
    public ResponseEntity<Void> updateExpense(@PathVariable("code") String code,
                                              @Valid @RequestBody ExpenseUpdateExpenseTO expense) {
        log.info(EVENT_UNSPECIFIED, "Start method updateExpense");

        log.info(EVENT_UNSPECIFIED, "Finish method updateExpense");
        return new ResponseEntity<>(OK);
    }
}
