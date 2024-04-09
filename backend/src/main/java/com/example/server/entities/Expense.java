package com.example.server.entities;

import java.sql.Date;

import org.bson.types.Decimal128;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "expenses")
public class Expense {
    @Id
    private String id;
    private Decimal128 amount;
    private String comment;
    private Date date_entered;
    private String category_id;

    /* CONSTRUCTORS */
    public Expense(String id, Decimal128 amount, String comment, Date date_entered, String category_id)
    {
        this.id = id;
        setAmount(amount);
        setComment(comment);
        setDateEntered(date_entered);
        setCatagoryID(category_id);
    }
    
    public Expense()
    {
        this("", Decimal128.NaN, "", null, "");
    }

    /* GETTERS */
    public String getID()
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

    public String getCategoryID()
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

    public void setCatagoryID(String category_id)
    {
        this.category_id = category_id;
    }

}
