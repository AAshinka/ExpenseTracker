package com.example.codeengine.expense.Payloads;

public class Response {
    Long id;
    String name;
    Double income;
    Double expense;
    Double total;

    public Response(Long id, String name, Double income, Double expense, Double total) {
        this.id = id;
        this.name = name;
        this.income = income;
        this.expense = expense;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
