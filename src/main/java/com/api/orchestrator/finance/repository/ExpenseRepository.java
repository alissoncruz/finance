package com.api.orchestrator.finance.repository;

import com.api.orchestrator.finance.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense,String> {

    Optional<Expense> findByUser(String user);
    Optional<Expense> findOneById(String user);

}
