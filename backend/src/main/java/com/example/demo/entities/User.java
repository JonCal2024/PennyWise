package com.example.demo.entities;
 
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        setID(null);
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
    public boolean setID(ObjectId id)
    {
        if(Objects.isNull(id))
        {
            return false;
        }
        this.id = id;
        return true;
    }

    public boolean setUsername(String username)
    {
        if(Objects.isNull(username) || username.isBlank())
        {
            return false;
        }
        this.username = username;
        return true;
    }

    public boolean setPassword(String password)
    {
        if(Objects.isNull(password))
        {
            return false;
        }

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        if(password.length() < 8 || !m.matches())
        {
            return false;
        }
        this.password = password;
        return true;
    }

    public boolean setEmail(String email)
    {
        if(Objects.isNull(email))
        {
            return false;
        }

        String regex = "^(?=.*[a-z])(?=."
                       + "*[A-Z])(?=.*\\d)"
                       + "(?=.*[-+_!@#$%^&*., ?]).+$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        if(!m.matches())
        {
            return false;
        }
        this.email = email;
        return true;
    }

}
