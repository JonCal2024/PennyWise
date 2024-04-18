package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Budget;
import com.example.demo.interfaces.BudgetRepository;

@Service
public class BudgetService {
    private BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository)
    {
        this.budgetRepository = budgetRepository;
    }

    //Do budgets need names? If so, do we need to check if a named budget already exists?
    public void addBudget(Budget budget)
    {
        budgetRepository.save(budget);
    }
}
