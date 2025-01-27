package com.jpahibernatexample.student_management.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // it refers that it is model or entity class which directly represents the database table
@Table(name="student") // it creates the database named student
public class Student {

    @Id // it is the primary key of the table and cannot contain duplicate value
    @Column(name="student_id")    // it creates a column inside database table
    private int studentId;

    @Column(name="name", nullable=false) // nullable=false - it is mandatory field and cannot be null
    private String name;

    @Column(name="email", nullable=false, unique=true)//unique=true - it does not allow duplicate values
    private String email;

    @Column(name="age", nullable=false)
    private int age;

    @Column(name="gender", nullable=false)
    private String gender;

    @Column(name="mobile", nullable=false)
    private String mobile;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
