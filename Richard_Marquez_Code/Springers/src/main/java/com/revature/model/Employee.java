package com.revature.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    @Id
    @Column(name = "employeeID")
    @SequenceGenerator(name = "EMPLOYEEID_SEQ", sequenceName = "EMPLOYEEID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEEID_SEQ")
    int id;

    @Column(name = "email", unique = true, length=100, nullable = false)
    String email;

    @Column(name = "password", length=100, nullable = false)
    String password;

    @Column(name = "firstname", length=100, nullable = false)
    String firstname;

    @Column(name = "lastname", length=100, nullable = false)
    String lastname;

    @Column(name = "isManager", nullable = false)
    int isManager;

    public Employee() {
    }

    public Employee(String email, String password, String firstname, String lastname, int isManager) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.isManager = isManager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getIsManager() {
        return isManager;
    }

    public void setIsManager(int isManager) {
        this.isManager = isManager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", isManager=" + isManager +
                '}';
    }
}
