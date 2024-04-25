package com.example.demo.entities;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "budgets")
public class Budget {
    @Id
    private ObjectId id;
    private Date reset_deadline;
    private ObjectId user_id;

    /* CONSTRUCTORS */
    public Budget()
    {
        setID(null);
        setResetDeadline(null);
        setUserID(null);
    }

    @JsonCreator
    public Budget(@JsonProperty("reset_deadline") Date resetDeadline, @JsonProperty("user_id") ObjectId userId) {
        this.reset_deadline = resetDeadline;
        this.user_id = userId;
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

    /* SETTERS */
    public void setID(ObjectId id) {
        this.id = id;
    }
    public void setResetDeadline(Date reset_deadline)
    {
        this.reset_deadline = reset_deadline;
    }

    public void setUserID(ObjectId user_id)
    {
        this.user_id = user_id;
    }

}
