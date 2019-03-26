package com.api.orchestrator.finance.service.impl;

import com.api.orchestrator.finance.model.Expense;
import com.api.orchestrator.finance.repository.ExpenseRepository;
import com.api.orchestrator.finance.service.ExpenseService;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.api.orchestrator.finance.utils.ErrorMessages.singleError;
import static java.util.Objects.isNull;
import static org.owasp.esapi.Logger.EVENT_UNSPECIFIED;

public class ExpenseServiceImpl implements ExpenseService {

    private final Logger log = ESAPI.getLogger(getClass());

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense createExpense(final Expense expense) {
        log.info(EVENT_UNSPECIFIED, "Start method createExpense");

        validateExpense(expense);
        Expense response = expenseRepository.save(expense);

        log.info(EVENT_UNSPECIFIED, "Finish method createExpense");

        return response;
    }

    @Override
    public List<Expense> findExpense(final String user) {
        log.info(EVENT_UNSPECIFIED, "Start method createExpense");
        if (isNull(user))
            throw new InvalidParameterException(singleError("3"));

        Optional<Expense> expense = expenseRepository.findByUser(user);

        if (!expense.isPresent())
            throw new RuntimeException("Not Found");

        List<Expense> collection = expense.stream()
                .collect(Collectors.toList());
        log.info(EVENT_UNSPECIFIED, "Finish method createExpense");

        return collection;
    }

    @Override
    public void updateExpense(final String user, final Expense expense) {
        Optional<Expense> expenseUpdate = expenseRepository.findByUser(user);
       // if(expenseUpdate.isPresent())
            //expenseUpdate.get().setCategory(expense.getCategory()) ;
       //else
        //throw new RuntimeException("Not Found");
        //expenseRepository.save(expenseUpdate.stream().filter(e -> e.getDate().equals(expense.getDate())).findFirst().get());
    }

    private void validateExpense(Expense expense) {
       /* if(isNull(expense.getDescription()))
            throw new InvalidParameterException(singleError("1"));
        if(isNull(expense.getValue()))
            throw new InvalidParameterException(singleError("2"));
        if(isNull(expense.getUser()))
            throw new InvalidParameterException(singleError("3"));*/
    }
}
