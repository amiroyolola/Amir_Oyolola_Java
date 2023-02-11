package com.company.summative.model;

import java.util.Random;

public class Definition {
    private int id;
    private String word;
    private String definition;

    public Definition(String word, String definition){
        this.setDefinition(definition);
        this.setWord(word);
        Random rand = new Random();
        this.id = rand.nextInt(10);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }


}
