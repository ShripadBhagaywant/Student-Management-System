package com.StudentManagementSystem.entity;

import jakarta.persistence.*;

@Entity
@Table (name="Students")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    @Column(name = "first_name")
    private  String firstName;

    @Column(name="last_name")
    private  String lastName;

    @Column(name = "email")
    private String email;

    public Student() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
