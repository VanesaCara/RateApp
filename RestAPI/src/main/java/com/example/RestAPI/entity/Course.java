package com.example.RestAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "course")
public class Course {


    @Id
    @GeneratedValue
    private int courseid;

    private String name;
    private String description;
    private String lecturer;
    private String time;
    private String location;
    private Integer numberofstudents;
    private Float rating;

    public Course() {
    }

    public Course(int courseid, String name, String description, String lecturer, String time, String location, Integer numberofstudents, Float rating) {
        this.courseid = courseid;
        this.name = name;
        this.description = description;
        this.lecturer = lecturer;
        this.time = time;
        this.location = location;
        this.numberofstudents = numberofstudents;
        this.rating = rating;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getNumberofstudents() {
        return numberofstudents;
    }

    public void setNumberofstudents(Integer numberofstudents) {
        this.numberofstudents = numberofstudents;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
