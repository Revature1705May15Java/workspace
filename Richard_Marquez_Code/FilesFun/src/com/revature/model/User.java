package com.revature.model;

import javax.persistence.*;

@Entity
@Table(name="USER_T")
public class User {

    @Id
    @Column(name="U_ID")
    private int id;

    @Column(name="U_USERNAME")
    private String username;

    @Column(name="U_PASSWORD")
    private String password;

    @Column(name="U_IMAGE")
    private byte[] image;

    @Column(name="U_S3_IMAGE")
    private String s3Image;

    public User() {
        username = "";
        password = "";
        image = new byte[1];
        s3Image = "";
    }

    public User(int id, String username, String password, byte[] image, String s3Image) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.image = image;
        this.s3Image = s3Image;
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}