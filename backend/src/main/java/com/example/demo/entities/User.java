package com.example.demo.entities;
 
import org.bson.types.ObjectId; 
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")  
public class User {
    @Id
    private ObjectId id;    //MAY CHANGE DATATYPE TO SOMETHING MORE SUITABLE
    private String username;
    private String password;
    private String email;


    /* CONSTRUCTORS */
    public User() 
    { 
        setUsername("");
        setPassword("");
        setEmail("");
        this.id = null; 
    }

    public User(String username, String password, String email)
    {
        setUsername(username);
        setPassword(password);
        setEmail(email);
    }

    /* GETTERS */
    public ObjectId getID()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }

    /* SETTERS */
    public void setID(ObjectId id)
    {
        this.id = id;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

}
