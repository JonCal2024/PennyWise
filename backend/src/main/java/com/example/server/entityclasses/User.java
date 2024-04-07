package com.example.server.entityclasses;

public class User {
    private String username;
    private String password;
    private String email;
    private long id;    //MAY CHANGE DATATYPE TO SOMETHING MORE SUITABLE

    /* CONSTRUCTORS */
    public User() 
    {
        setUsername("");
        setPassword("");
        setEmail("");
        this.id = -1;
    }

    public User(String username, String password, String email, long id)
    {
        setUsername(username);
        setPassword(password);
        setEmail(email);
        this.id = id;
    }

    /* GETTERS */
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

    public long getID()
    {
        return id;
    }

    /* SETTERS */
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
