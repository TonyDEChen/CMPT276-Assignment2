package com.cmpt276.as2.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private int weight;
    private int height;
    private String hair;
    private double gpa;
    private String alive;
    public User() {
    }
    public User(String name, int weight, int height, String hair, double gpa, String alive) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.hair = hair;
        this.gpa = gpa;
        this.alive = alive;
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
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) { 
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getHair() {
        return hair;
    }
    public void setHair(String hair) {
        this.hair = hair;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String getAlive() {
        return alive;
    }
    public void setAlive(String alive) {
        this.alive = alive;
    }
    
}
