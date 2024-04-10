package com.example.demo.entities;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "budgets")
public class Budget {
    @Id
    private String id;
    private Date reset_deadline;
    private String user_id;
    private ArrayList<Category> categories;

    /* CONSTRUCTORS */
    public Budget(String id, Date reset_deadline, String user_id, ArrayList<Category> catagories)
    {
        this.id = id;
        setResetDeadline(reset_deadline);
        this.user_id = user_id;
        setCatagories(catagories);
    }

    public Budget()
    {
        this("", null, "", null);
    }

    /* GETTERS */
    public String getID()
    {
        return id;
    }

    public Date getResetDeadline()
    {
        return reset_deadline;
    }

    public String getUserID()
    {
        return user_id;
    }

    public ArrayList<Category> getCategories()
    {
        return categories;
    }

    /* SETTERS */
    public void setResetDeadline(Date reset_deadline)
    {
        this.reset_deadline = reset_deadline;
    }

    public void setCatagories(ArrayList<Category> categories)
    {
        this.categories = new ArrayList<Category>(categories);
    }

}
