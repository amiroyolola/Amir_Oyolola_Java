package com.company.summative.model;

import java.util.Random;

public class Quote {
    private int id;
    private String author;
    private String quote;

    public Quote(String author, String quote){
        this.setAuthor(author);
        this.setQuote(quote);
        Random rand = new Random();
        this.id = rand.nextInt(10);

    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



}
