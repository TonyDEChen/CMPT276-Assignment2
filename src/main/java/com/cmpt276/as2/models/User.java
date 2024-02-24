package com.cmpt276.as2.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

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

    // private String password;
    // private int size;
    // public User() {
    // }
    // public User(String name, String password, int size) {
    //     this.name = name;
    //     this.password = password;
    //     this.size = size;
    // }
    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    // public String getPassword() {
    //     return password;
    // }
    // public void setPassword(String password) {
    //     this.password = password;
    // }
    // public int getSize() {
    //     return size;
    // }
    // public void setSize(int size) {
    //     this.size = size;
    // }
    // public int getUid() {
    //     return uid;
    // }
    // public void setUid(int uid) {
    //     this.uid = uid;
    // }
    
}
