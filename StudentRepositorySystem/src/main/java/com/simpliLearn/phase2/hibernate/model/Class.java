package com.simpliLearn.phase2.hibernate.model;

public class Class {
    private int id;
    private int section;
    private String teacher;
    private String subject;
    private String time;

	public Class(int id, int section, String teacher_name, String name, String time2) {
		 this.id = id;
	     this.section = section;
	     this.teacher = teacher_name;
	     this.subject = name;
	     this.time = time2;
	}

	public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSection() {
        return this.section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
