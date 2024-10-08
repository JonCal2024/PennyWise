package com.example.demo.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Expense;
import com.example.demo.interfaces.ExpenseRepository;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository)
    {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense)
    {
        expenseRepository.save(expense);
    }

    public Expense findByID(ObjectId id)
    {
        return expenseRepository.findByID(id).orElse(null);
    }

    public void deleteExpense(Expense expense)
    {
        expenseRepository.deleteById(expense.getID());
    }

    public List<Expense> findAllExpensesByCategoryID(ObjectId categoryID)
    {
        return expenseRepository.findByCategoryID(categoryID);
    }
}
