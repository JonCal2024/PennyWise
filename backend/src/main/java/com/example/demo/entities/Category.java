package com.example.demo.entities;

import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
public class Category {
    @Id
    private ObjectId id;
    private Decimal128 amount_allocated;
    private String name;
    private String description;
    private ObjectId budget_id;

    /* CONSTRUCTORS */

    public Category(ObjectId id, Decimal128 amount_allocated, String name, String description, ObjectId budget_id)
    {
        this.id = id;
        setAmountAllocated(amount_allocated);
        setName(name);
        setDescription(description);
        setBudgetID(budget_id);
    }

    public Category()
    {
        this(null, Decimal128.NaN, "", "", null);
    }

    /* GETTERS */
    public ObjectId getID()
    {
        return id;
    }

    public Decimal128 getAmountAllocated()
    {
        return amount_allocated;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public ObjectId getBudgetID()
    {
        return budget_id;
    }

    /* SETTERS */
    public void setAmountAllocated(Decimal128 amount_allocated)
    {
        this.amount_allocated = amount_allocated;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setBudgetID(ObjectId budget_id)
    {
        this.budget_id = budget_id;
    }

}
