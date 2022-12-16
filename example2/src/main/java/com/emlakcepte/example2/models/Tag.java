package com.emlakcepte.example2.models;

public class Tag {
    private final String name;
    private final String category;

    public Tag(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
