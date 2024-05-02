package com.example.demo.entities;

import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "categories")
public class Category {
    @Id
    private ObjectId id;
    private Decimal128 amount_allocated;
    private String name;
    private String description;
    private ObjectId budget_id;

    /* CONSTRUCTORS */

    public Category()
    {
        setID(null);
        setAmountAllocated(null);
        setName("");
        setDescription("");
        setBudgetID(null);
    }

    @JsonCreator
    public Category(@JsonProperty("amount_allocated") Decimal128 amount_allocated, @JsonProperty("name") String name, @JsonProperty("description") String description, @JsonProperty("budget_id") ObjectId budget_id)
    {
        setAmountAllocated(amount_allocated);
        setName(name);
        setDescription(description);
        setBudgetID(budget_id);
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
    public void setID(ObjectId id) {
        this.id = id;
    }

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
