package com.database;

import java.io.Serializable;

/**
 * information about user
 */
public class UserInformationPackage implements Serializable {
    private String login;
    private String password;

    /**
     * creates information
     * 
     * @param login    users login
     * @param password users password
     */
    public UserInformationPackage(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * return login
     * 
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * sets login
     * 
     * @param login login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * returns password
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets password
     * 
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}