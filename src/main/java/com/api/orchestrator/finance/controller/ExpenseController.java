package com.api.orchestrator.finance.controller;

import com.api.orchestrator.finance.api.v1.ExpenseApi;
import com.api.orchestrator.finance.model.Expense;
import com.api.orchestrator.finance.model.v1.ExpenseExpenseCodeTO;
import com.api.orchestrator.finance.model.v1.ExpenseExpenseTO;
import com.api.orchestrator.finance.model.v1.ExpenseResponseExpensesTO;
import com.api.orchestrator.finance.model.v1.ExpenseUpdateExpenseTO;
import com.api.orchestrator.finance.service.ExpenseService;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.api.orchestrator.finance.utils.ParserUtil.convertValue;
import static org.owasp.esapi.Logger.EVENT_UNSPECIFIED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class ExpenseController extends BaseRestController implements ExpenseApi {

    private final Logger log = ESAPI.getLogger(getClass());

    @Autowired
    private ExpenseService expenseService;

    @Override
    public ResponseEntity<ExpenseExpenseCodeTO> createExpense(@Valid @RequestBody ExpenseExpenseTO newExpense) {
        log.info(EVENT_UNSPECIFIED, "Start method createExpense");

        Expense expense = convertValue(newExpense, Expense.class);
        ExpenseExpenseCodeTO response = convertValue(expenseService.createExpense(expense), ExpenseExpenseCodeTO.class);

        log.info(EVENT_UNSPECIFIED, "Finish method createExpense");
        return new ResponseEntity<>(response, CREATED);
    }

    @Override
    public ResponseEntity<ExpenseResponseExpensesTO> getExpense(@PathVariable("user") String user) {

        log.info(EVENT_UNSPECIFIED, "Start method getExpense");

        ExpenseResponseExpensesTO response = convertValue(expenseService.findExpense(user), ExpenseResponseExpensesTO.class);

        log.info(EVENT_UNSPECIFIED, "Finish method getExpense");
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
