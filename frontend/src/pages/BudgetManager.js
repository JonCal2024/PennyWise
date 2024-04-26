import React, { useState } from 'react';

const BudgetManager = () => {
    const [budgets, setBudgets] = useState([]);

    const addBudget = () => {
      const budgetName = prompt("Enter budget name: ");
      const budgetTotal = prompt("Enter the amount for the budget: ");
      if (budgetName && budgetTotal) {
          setBudgets([...budgets, { name: budgetName, budgetTotal: parseFloat(budgetTotal), categories: []}]);
      }
  };

  return (
      <div className="budget-manager-container">
          <h1>Personal Budget Manager</h1>
          <button className="add-button" onClick={addBudget}>Add Budget</button>
          <div className="budgets-container">
              {budgets.map((budget, index) => (
                  <Category key={index} index={index} budget={budget} budgets={budgets} setBudgets={setBudgets} />
              ))}
          </div>
      </div>
  );
}

const Category = ({ budget, index, budgets, setBudgets }) => {
    const [categories, setCategories] = useState([]);
    const [originalBudget, setOriginalBudget] = useState(budget.budgetTotal);

    const addCategory = () => {
        const categoryNameInput = prompt("Enter category name: ");
        const amount = prompt("Enter the amount of budget allocated for the category: ");
        const categoryAmountInput = parseFloat(amount);
        const categoryDescription = prompt("Enter a description for the category: ");
        
        if (categoryNameInput && !isNaN(categoryAmountInput) && categoryAmountInput > 0) {
        
            if (budget.budgetTotal - categoryAmountInput < 0) {
                alert("Adding this category would exceed the original budget!");
                return;
            }

            const updatedBudget = budget.budgetTotal - categoryAmountInput;

            setBudgets(budgets.map((bud, i) => {
                if (i === index) {
                    return { ...bud, budgetTotal: updatedBudget, categories: [...bud.categories, { name: categoryNameInput, amount: categoryAmountInput }] };
                }
                return bud;
            }));
      
            setCategories([...categories, { name: categoryNameInput, amount: categoryAmountInput, description: categoryDescription }]);
        } else {
            alert("Invalid category input!");
        }
    };
  

    return (
        <div className="budget-container">
            <h3>{budget.name}</h3>
            <p>Original Budget: ${originalBudget}</p>
            <p>Remaining Budget: ${budget.budgetTotal}</p>

            <button onClick={addCategory}>Add Category</button>
            <div className="categories-container">
                {categories.map((category, index) => (
                    <Expense key={index} index={index} category={category} categories={categories} setCategories={setCategories} />
                ))}
            </div>
        </div>
  );
}

const Expense = ({ category, index, categories, setCategories }) => {
    const [expenses, setExpenses] = useState(category.expenses || []); // Initialize expenses as an empty array if it's not defined

    const addExpense = () => {
        const expenseNameInput = prompt("Enter expense name: ");
        const amount = prompt("Enter the cost of this expense: ");
        const expenseAmountInput = parseFloat(amount);
        const expenseComment = prompt("Enter a comment for this expense: ");

        if (expenseNameInput && !isNaN(expenseAmountInput) && expenseAmountInput > 0) {

            if (category.amount - expenseAmountInput < 0) {
                alert("Adding this expense would exceed the allocated amount for the category and will put the category into the negative.");
                return;
            }

            const updatedCategoryAmount = category.amount - expenseAmountInput;
            const dateAdded = new Date();

            const updatedCategories = categories.map((cat, i) => {
                if (i === index) {
                    return { ...cat, amount: updatedCategoryAmount, expenses: [...(cat.expenses || []), { name: expenseNameInput, amount: expenseAmountInput, comment: expenseComment, dateAdded }] }; // Initialize expenses as an empty array if it's not defined
                }
                return cat;
            });

            setCategories(updatedCategories);

            setExpenses([...expenses, { name: expenseNameInput, amount: expenseAmountInput, comment: expenseComment, dateAdded }]);
        } else {
            alert("Invalid expense input!");
        }
    };

    return (
        <div className="category-container">
            <h4>{category.name}</h4>
            <p>Amount allocated: ${category.amount}</p>
            {expenses.map((expense, expenseIndex) => (
                <div className="expense-container" key={expenseIndex}>
                    <p>{expense.name} - ${expense.amount}</p>
                </div>
            ))}
            <button onClick={addExpense}>Add Expense</button>
        </div>
    );
};
export default BudgetManager;