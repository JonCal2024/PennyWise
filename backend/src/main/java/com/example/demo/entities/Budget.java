package com.example.demo.entities;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "budgets")
public class Budget {
    enum Period
    {
        NONE,
        DAILY,
        WEEKLY,
        MONTHLY,
        YEARLY
    }
    
    @Id
    private ObjectId id;
    private Period reset_period_type;
    private Date reset_deadline;
    private ObjectId user_id;
    private String name;

    /* CONSTRUCTORS */
    public Budget()
    {
        setID(null);
        setResetPeriodType(Period.NONE);
        setResetDeadline(null);
        setUserID(null);
        setName("");
    }

    @JsonCreator
    public Budget( String name, @JsonProperty("reset_period_type") Period resetPeriodType, @JsonProperty("reset_deadline") Date resetDeadline, @JsonProperty("user_id") ObjectId userId) {
        setResetPeriodType(resetPeriodType);
        setResetDeadline(resetDeadline);
        setUserID(userId);
        setName(name);
    }

    /* GETTERS */
    public ObjectId getID()
    {
        return id;
    }

    public Period getResetPeriodType()
    {
        return reset_period_type;
    }

    public Date getResetDeadline()
    {
        return reset_deadline;
    }

    public ObjectId getUserID()
    {
        return user_id; 
    }

    public String getName()
    {
        return name; 
    }

    /* SETTERS */
    public void setID(ObjectId id) {
        this.id = id;
    }

    public void setResetPeriodType(Period reset_period_type)
    {
        this.reset_period_type = reset_period_type;
    }

    public void setResetDeadline(Date reset_deadline)
    {
        this.reset_deadline = reset_deadline;
    }

    public void setUserID(ObjectId user_id)
    {
        this.user_id = user_id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
