package com.bootrestuser.bootrestuser.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserScore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String subjectScore;
    private int finalScore;

    @OneToOne
    @JoinColumn(name = "user_id") 
    @JsonBackReference
    private User user;

    public UserScore() {

    }

    public UserScore(long id, String subjectScore, int finalScore, User user) {
        this.id = id;
        this.subjectScore = subjectScore;
        this.finalScore = finalScore;
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserScore [id=" + id + ", subjectScore=" + subjectScore + ", finalScore=" + finalScore + ", user="
                + user + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(String subjectScore) {
        this.subjectScore = subjectScore;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
