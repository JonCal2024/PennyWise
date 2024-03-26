import React, { useState } from 'react';

const BudgetManager = () => {
  const [budgets, setBudgets] = useState([]);

  // Function to add a new category (change to budget)
  const addBudget = () => {
    const budgetName = prompt("Enter budget name:");
    const budgetTotal = prompt("Enter the amount for the budget:");
    if (budgetName && budgetTotal) {
      setBudgets([...budgets, { name: budgetName, budgetTotal: parseFloat(budgetTotal)}]);
    }
  };

  return (
    <div className="budgetContainer">
      <h1>Personal Budget Manager</h1>
      <button onClick={addBudget}>Add Budget</button>
      {budgets.map((budget, index) => (
        <Budget key={index} index={index} budget={budget} budgets={budgets} setBudgets={setBudgets} />
      ))}
    </div>
  );
}

const Budget = ({ budget, index, budgets, setBudgets }) => {
  const [categories, setCategories] = useState([]);
  const [categoryName, setCategoryName] = useState("");
  const [categoryAmount, setCategoryAmount] = useState("");
  const [originalBudget, setOriginalBudget] = useState(budget.budgetTotal);

  const addCategory = () => {
    const newCategoryAmount = parseFloat(categoryAmount);
    if (!isNaN(newCategoryAmount) && newCategoryAmount > 0) {
      // Subtract item amount from category budget
      const updatedBudget = budget.budgetTotal - newCategoryAmount;
      //update the budget
      setBudgets(budgets.map((bud, i) => {
        if (i === index) {
          return { ...bud, budgetTotal: updatedBudget };
        }
        return bud;
      }));

      setCategories([...categories, { name: categoryName, amount: newCategoryAmount }]);
      setCategoryName("")
      setCategoryAmount("")
    } else {
      alert("Invalid item amount!");
    }
    console.log(categories);
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
