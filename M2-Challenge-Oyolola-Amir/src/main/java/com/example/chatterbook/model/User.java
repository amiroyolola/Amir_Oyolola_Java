package com.example.chatterbook.model;
import java.util.List;
public class User {
    private String name;

    public List<ChatterPost> getChatterPosts() {
        return chatterPosts;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }

    private List<ChatterPost> chatterPosts;
    public void setName(String name) {
        this.name = name;
    }
    public User(String name){
        this.setName(name);
    }
    public String getName() {
        return name;
    }





}
