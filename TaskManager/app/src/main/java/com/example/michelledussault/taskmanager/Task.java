package com.example.michelledussault.taskmanager;

import java.util.Date;

/**
 * Created by michelledussault on 2017-11-24.
 */

public class Task {


    private String title;
    private String description;
    private Date deadline;
    private Enum status;
    private double points;

    public Task(){}

    public Task(String title, String description, Date deadline, Enum status, double points){
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.points = points;
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

    public Date getDeadline(){
        return deadline;
    }
    public void setDeadline(Date deadline){
        this.deadline = deadline;
    }

    public Enum getStatus(){
        return status;
    }
    public void setStatus(Enum status){
        this.status = status;
    }

    public double getPoints(){
        return points;
    }

    public void setPoints(double points){
        this.points = points;
    }

}
