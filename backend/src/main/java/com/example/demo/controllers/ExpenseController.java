package com.example.demo.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Expense;
import com.example.demo.services.ExpenseService;

//MAY ADD getByDate(Date), getAmountsLessThan(Decimal), getAmountsGreaterThan(Decimal), etc. IF NEEDED

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService)
    {
        this.expenseService = expenseService;
    }

    @PostMapping("/addExpense")
    public void addExpense(@RequestBody Expense expense)
    {
        expenseService.addExpense(expense);
    }

    @GetMapping("/{id}")
    public Expense getExpenseByID(@PathVariable ObjectId id)
    {
        return expenseService.findByID(id);
    }

    @DeleteMapping("/deleteExpense")
    public void deleteExpense(@RequestBody Expense expense)
    {
        expenseService.deleteExpense(expense);
    }

}
