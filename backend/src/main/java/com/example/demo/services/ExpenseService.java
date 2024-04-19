package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.interfaces.ExpenseRepository;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository)
    {
        this.expenseRepository = expenseRepository;
    }
}
