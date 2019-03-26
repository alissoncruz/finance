package com.api.orchestrator.finance.service;

import com.api.orchestrator.finance.model.Expense;

import java.util.List;

public interface ExpenseService {

    Expense createExpense(Expense expense);
    List<Expense> findExpense(String user);
    void updateExpense(String user, Expense expense);

}
