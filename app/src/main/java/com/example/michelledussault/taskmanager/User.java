package com.example.michelledussault.taskmanager;

/**
 * Created by michelledussault on 2017-11-24.
 */

public class User {

    private String username;
    private String profileIcon;


    public User(){}

    public User(String username, String profileIcon){
        this.username = username;
        this.profileIcon = profileIcon;
    }


    public String getUsername(){
        return username;
    }

    public String getProfileIcon(){
        return profileIcon;
    }

    public void setProfileIcon(String profileIcon){
        this.profileIcon = profileIcon;
    }


}
