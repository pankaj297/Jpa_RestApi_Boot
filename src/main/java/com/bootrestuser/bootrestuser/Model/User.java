package com.bootrestuser.bootrestuser.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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

    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private UserScore userScore;

   

    public User(long id, String name, String city, int age, UserScore userScore) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
        this.userScore = userScore;
    }

    public UserScore getUserScore() {
        return userScore;
    }

    public void setUserScore(UserScore userScore) {
        this.userScore = userScore;
    }

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

   
    // default Constructor
    public User() {
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", city=" + city + ", age=" + age + ", userScore=" + userScore
                + "]";
    }
   
}
