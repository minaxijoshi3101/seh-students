package com.seh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // now matches getId()

    @Column(name="student_name")
    private String student_name;

    @Column(name="student_password")
    private String student_password;

    @Column(name="student_mobile")
    private String student_mobile;

    @Column(name="student_email")
    private String student_email;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    public String getStudent_mobile() {
        return student_mobile;
    }

    public void setStudent_mobile(String student_mobile) {
        this.student_mobile = student_mobile;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    // Constructor
    public Student(Long id, String student_name, String student_password, String student_mobile, String student_email) {
        this.id = id;
        this.student_name = student_name;
        this.student_password = student_password;
        this.student_mobile = student_mobile;
        this.student_email = student_email;
    }

    public Student() {
        // default constructor
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", student_name=" + student_name + ", student_password=" + student_password
                + ", student_mobile=" + student_mobile + ", student_email=" + student_email + "]";
    }
}