package com.example.demo.entities;

import java.sql.Date;
import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "budgets")
public class Budget {
    @Id
    private ObjectId id;
    private Date reset_deadline;
    private ObjectId user_id;
    private ArrayList<Category> categories;

    /* CONSTRUCTORS */
    public Budget(ObjectId id, Date reset_deadline, ObjectId user_id, ArrayList<Category> catagories)
    {
        this.id = id;
        setResetDeadline(reset_deadline);
        this.user_id = user_id;
        setCatagories(catagories);
    }

    public Budget()
    {
        this(null, null, null, null);
    }

    /* GETTERS */
    public ObjectId getID()
    {
        return id;
    }

    public Date getResetDeadline()
    {
        return reset_deadline;
    }

    public ObjectId getUserID()
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
