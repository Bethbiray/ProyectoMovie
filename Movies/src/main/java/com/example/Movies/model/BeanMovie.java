package com.example.Movies.model;

public class BeanMovie {
    private int id;
    private String name;
    private String description;
    private String date_premiere;
    private double  collection;
    private int status;

    public BeanMovie() {
    }

    public BeanMovie(int id, String name, String description, String date_premiere, double collection, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date_premiere = date_premiere;
        this.collection = collection;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDate_premiere() {
        return date_premiere;
    }

    public void setDate_premiere(String date_premiere) {
        this.date_premiere = date_premiere;
    }

    public double getCollection() {
        return collection;
    }

    public void setCollection(double collection) {
        this.collection = collection;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
