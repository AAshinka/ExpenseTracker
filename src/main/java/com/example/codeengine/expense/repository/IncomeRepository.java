package com.example.codeengine.expense.repository;

import com.example.codeengine.expense.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface IncomeRepository extends JpaRepository<Income,Long> {
	Set<Income> findByUserId(Long user_id);
}
