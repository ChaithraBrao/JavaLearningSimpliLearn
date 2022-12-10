package com.simpliLearn.phase2.hibernate.model;

public class Student {
    private int id;
    private String fname;
    private String lname;
    private int age;
    private int aclass;

    public Student(int id, String fname, String lname, int age, int aclass) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.aclass = aclass;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAclass() {
        return this.aclass;
    }

    public void setAclass(int aclass) {
        this.aclass = aclass;
    }

    public String toString() {
        return "Student [id=" + this.id + ", fname=" + this.fname + ", lname=" + this.lname + ", age=" + this.age + ", aclass=" + this.aclass + "]";
    }
}
