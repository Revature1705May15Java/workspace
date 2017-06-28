package com.ex.testpojo;

import java.io.Serializable;

public class UserStatus implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    public UserStatus() {
    }

    public UserStatus(String name) {
        super();
        this.name = name;
    }

    public UserStatus(int id, String name) {
        super();
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserStatus [id=" + id + ", name=" + name + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}