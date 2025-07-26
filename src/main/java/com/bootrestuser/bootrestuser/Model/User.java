package com.bootrestuser.bootrestuser.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_Id")
    private long id;

    @Column(name = "User_Name")
    private String name;
    @Column(name = "User_City")
    private String city;
    @Column(name = "User_Age")
    private int age;

    // Setter
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    // Parameterized Constructor
    public User(long id, String name, String city, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    // default Constructor
    public User() {
    }

    // ToString
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", city=" + city + ", age=" + age + "]";
    }

}
