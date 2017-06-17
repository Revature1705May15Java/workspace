package com.revature.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_T")
public class User {
  @Id
  @Column(name="U_ID")
  @SequenceGenerator(name="USER_SEQ", sequenceName="USER_SEQ")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ")
  private int id;
  
  @Column(name="u_username")
  private String username;
  
  @Column(name="u_password")
  private String password;
  
  @Column(name="u_image")
  private byte[] image;
  
  @Column(name="u_s3_image")
  private String s3Image;
  
  public User() {
    super();
    username = "";
    password = "";
    image = new byte[1];
    s3Image = "";
    
  }

  public User(int id, String username, String password, byte[] image, String s3Image) {
    super();
    this.id = id;
    this.username = username;
    this.password = password;
    this.image = image;
    this.s3Image = s3Image;
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
    return "User [id=" + id + ", username=" + username + ", password=" + password + ", image=" + Arrays.toString(image)
        + ", s3Image=" + s3Image + "]";
  }
  
}
