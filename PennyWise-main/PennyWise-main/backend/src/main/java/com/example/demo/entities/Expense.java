package com.example.demo.entities;

import java.sql.Date; 

import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "expenses") 
public class Expense {
    @Id
    private ObjectId id;
    private Decimal128 amount;
    private String comment;
    private Date date_entered;
    private ObjectId category_id;

    /* CONSTRUCTORS */
    public Expense(Decimal128 amount, String comment, Date date_entered, ObjectId category_id)
    {
        setAmount(amount);
        setComment(comment);
        setDateEntered(date_entered);
        setCatagoryID(category_id);
    }
    
    public Expense()
    {
        this(null, "", null, null);
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

    public void setCatagoryID(ObjectId category_id)
    {
        this.category_id = category_id;
    }

}
