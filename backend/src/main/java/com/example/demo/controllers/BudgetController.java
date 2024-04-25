package com.example.demo.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Budget;
import com.example.demo.services.BudgetService;

@RestController
@RequestMapping("/budgets")
public class BudgetController {
    private BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService)
    {
        this.budgetService = budgetService;
    }

    @PostMapping("/addBudget")
    public void addBudget(@RequestBody Budget budget)
    {
        budgetService.addBudget(budget);
    }

    @GetMapping("/{id}")
    public Budget getBudgetByID(@PathVariable ObjectId id)
    {
        return budgetService.findByID(id);
    }

    @GetMapping("/getAllBudgets")
    public List<Budget> getAllBudgets(String userID)
    {
        ObjectId registeredUser = new ObjectId(userID);
        return budgetService.findAllBudgetsByUserID(registeredUser);
    }

    @PatchMapping("/updateBudget")
    public Budget updateBudget(@RequestBody Budget budget)
    {
        return budgetService.updateBudget(budget.getID(), budget);
    } 

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable ObjectId id)
    {
        budgetService.deleteBudget(id);
    }
}
