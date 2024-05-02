package com.example.demo.entities;

import java.util.Date; 

import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "expenses") 
public class Expense {
    @Id
    private ObjectId id;
    private Decimal128 amount;
    private String comment;
    private Date date_entered;
    private ObjectId category_id;

    /* CONSTRUCTORS */
    
    public Expense()
    {
        setID(null);
        setAmount(null);
        setComment("");
        setDateEntered(null);
        setCategoryID(null);
    }

    @JsonCreator
    public Expense(@JsonProperty("amount") Decimal128 amount, @JsonProperty("comment") String comment, @JsonProperty("date_entered") Date date_entered, @JsonProperty("category_id") ObjectId category_id)
    {
        setAmount(amount);
        setComment(comment);
        setDateEntered(date_entered);
        setCategoryID(category_id);
    }

    /* GETTERS */
    public ObjectId getID()
    {
        return id;
    }

    public Decimal128 getAmount()
    {
        return amount;
    }

    public String getComment()
    {
        return comment;
    }

    public Date getDateEntered()
    {
        return date_entered;
    }

    public ObjectId getCategoryID()
    {
        return category_id;
    }

    /* SETTERS */
    public void setID(ObjectId id) {
        this.id = id;
    }
    public void setAmount(Decimal128 amount)
    {
        this.amount = amount;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public void setDateEntered(Date date_entered)
    {
        this.date_entered = date_entered;
    }

    public void setCategoryID(ObjectId category_id)
    {
        this.category_id = category_id;
    }

}
