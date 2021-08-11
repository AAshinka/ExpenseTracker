package com.example.codeengine.expense.repository;

import com.example.codeengine.expense.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.codeengine.expense.model.Expense;

import java.util.Set;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    Set<Expense> findByUserId(Long user_id);
}
