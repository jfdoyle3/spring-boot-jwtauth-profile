package com.example.springjwtauth.payloads.response;

import com.example.springjwtauth.entities.Profile;
import com.example.springjwtauth.entities.User;

import java.util.HashSet;
import java.util.Set;

public class SelfProfile {

    private Long id;
    private String fName;
    private String lName;
    private String title;
    private int age;
    private String bio;
    private String role;
    private User user;

    public SelfProfile(Long id, String fName, String lName, String title, int age, String bio, String role, User user) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.title = title;
        this.age = age;
        this.bio = bio;
        this.role = role;
        this.user = user;
    }

    public static SelfProfile build(Profile profile) {
        Set<Profile> empty = new HashSet<>();
        return new SelfProfile(
                profile.getId(),
                profile.getfName(),
                profile.getlName(),
                profile.getTitle(),
                profile.getAge(),
                profile.getBio(),
                profile.getRole(),
                profile.getUser()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}