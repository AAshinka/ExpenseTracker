package com.example.codeengine.expense.controller;

import com.example.codeengine.expense.Payloads.Response;
import com.example.codeengine.expense.model.Expense;
import com.example.codeengine.expense.model.Income;
import com.example.codeengine.expense.model.User;
import com.example.codeengine.expense.repository.ExpenseRepository;
import com.example.codeengine.expense.repository.IncomeRepository;
import com.example.codeengine.expense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired private UserRepository userRepository;
    @Autowired private IncomeRepository incomeRepository;
    @Autowired private ExpenseRepository expenseRepository;

    @GetMapping("/user/{id}")
    Response getUser(@PathVariable Long id) {
        User user = userRepository.getOne(id);
        Set<Income> incomes = incomeRepository.findByUserId(id);
        Set<Expense> expenses = expenseRepository.findByUserId(id);

        Double totalIncome = 0.0;
        for (Income income : incomes) {
            totalIncome += income.getAmount();
        }

        Double totalExpense = 0.0;
        for (Expense expense : expenses) {
            totalExpense += expense.getAmount();
        }
        return new Response(user.getId(), user.getName(), totalIncome, totalExpense, totalIncome - totalExpense);
    }

    @PostMapping("/user/new")
    ResponseEntity<User> createExpense(@Valid @RequestBody User user) throws URISyntaxException {
        User result= userRepository.save(user);
        return ResponseEntity.created(new URI("/api/user" + result.getId())).body(result);
    }
}
