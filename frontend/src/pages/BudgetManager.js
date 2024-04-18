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
    <div>
      <h3>{budget.name}</h3>
      <p>Original Budget: ${originalBudget}</p>
      <p>Remaining Budget: ${budget.budgetTotal}</p>
      <input
        type="text"
        placeholder="Category Name"
        value={categoryName}
        onChange={(e) => setCategoryName(e.target.value)}
      />
      <input
        type="number"
        placeholder="Category Amount"
        value={categoryAmount}
        onChange={(e) => setCategoryAmount(e.target.value)}
      />
      <button onClick={addCategory}>Add Category</button>
      <ul>
        {categories.map((cat, i) => (
          <li key={i}>
            {cat.name} - ${cat.amount}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BudgetManager;