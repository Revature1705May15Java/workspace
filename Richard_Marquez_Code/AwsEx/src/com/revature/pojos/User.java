package com.revature.pojos;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "USER_T")
public class User {

    @Id
    @Column(name = "U_ID")
    private int id;

    @Column(name = "U_USERNAME")
    private String username;

    @Column(name = "U_PASSWORD")
    private String password;

    @Column(name = "U_IMAGE")
    private byte[] image;

    @Column(name = "U_S3_IMAGE")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getS3Image() {
        return s3Image;
    }

    public void setS3Image(String s3Image) {
        this.s3Image = s3Image;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", image=" + Arrays.toString(image) +
                ", s3Image='" + s3Image + '\'' +
                '}';
    }
}
