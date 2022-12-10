package com.simpliLearn.phase2.hibernate.model;

public class Subject {
    private int id;
    private String name;
    private String shortcut;

    public Subject(int id, String name, String shortcut) {
        this.id = id;
        this.name = name;
        this.shortcut = shortcut;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortcut() {
        return this.shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
