package com.example.michelledussault.taskmanager;

import java.io.Serializable;


/**
 * Created by michelledussault on 2017-11-24.
 */

public class Task implements Serializable {


    private String title;
    private String description;
    private String deadline;
    private Enum status;
    private String points;
    private String id;

    public Task(){}

    public Task(String id,String title, String description, String deadline, Enum status, String points){
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.points = points;
    }

    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getDeadline(){
        return deadline;
    }
    public void setDeadline(String deadline){
        this.deadline = deadline;
    }

    public Enum getStatus(){
        return status;
    }
    public void setStatus(Enum status){
        this.status = status;
    }

    public String getPoints(){
        return points;
    }

    public void setPoints(String points){
        this.points = points;
    }

}
