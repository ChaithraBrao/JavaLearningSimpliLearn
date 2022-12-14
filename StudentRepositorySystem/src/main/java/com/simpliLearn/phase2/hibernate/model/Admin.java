package com.simpliLearn.phase2.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int admin_id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
