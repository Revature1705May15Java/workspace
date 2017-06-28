package com.ex.testpojo;

import java.sql.Date;
import java.util.Calendar;

public class User {
   private static final long serialVersionUID = 2L;
   int id;

   String email;

   String password;

   String firstname;

   String lastname;

   String Avatar = ""; // user profile image blob.

   int isBaby = 1; // Mature language filter setting. Default 1 for true.


   UserStatus status; // User's restriction settings (normal, shadow ban, etc)


   int votesCast = 0; // total number of votes cast from the beginning of time. Default zero because a new user would not have any votes.

   Date lastLoggedIn = new Date(Calendar.getInstance().getTimeInMillis());// last date time that the user logged in.

   public User() {
   }

   public User(int id, UserStatus status, int votesCast, boolean isBaby, String avatar, String email, String password,
           String firstname, String lastname, Date lastLoggedIn) {
	   super();
	   this.id = id;
	   this.status = status;
	   this.votesCast = votesCast;
	   setBaby(isBaby);
	   Avatar = avatar;
	   this.email = email;
	   this.password = password;
	   this.firstname = firstname;
	   this.lastname = lastname;
	   this.lastLoggedIn = lastLoggedIn;
	}
   public User(String email, String password, String firstname, String lastname) {
	   super();
	   this.email = email;
	   this.password = password;
	   this.firstname = firstname;
	   this.lastname = lastname;
	}

   @Override
   public String toString() {
       return "User [id=" + id + ", status=" + status + ", votesCast=" + votesCast + ", isBaby=" + isBaby() + ", Avatar="
               + Avatar + ", email=" + email + ", password=" + password + ", firstname=" + firstname + ", lastname="
               + lastname + ", lastLoggedIn=" + lastLoggedIn + "]";
   }

   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   /**
    * Returns the UserStatus object. NOT IMPLEMENTED: Returning a dummy UserStatus object as a placeholder.
    *
    * @author: Darrin McIntyre
    * @since 2017-06-23
    **/
   public UserStatus getStatus() {
       return status;
   }

   /**
    * Sets the user's status. NOT IMPLEMENTED: Returning -1 as a placeholder.
    *
    * @author: Darrin McIntyre
    * @since 2017-06-23
    **/
   public int setStatus(UserStatus newStatus) {
       status = newStatus;
       return -1;//dao.setUserStatus(id);
   }

   public int getVotesCast() {
       return votesCast;
   }

   public void setVotesCast(int votesCast) {
       this.votesCast = votesCast;
   }

   public boolean isBaby() {
       if (this.isBaby == 1) return true;
       return false;
   }
   
   public int isIntBaby(){
   	return isBaby;
   }

   public void setBaby(boolean isBaby) {
       if (isBaby) this.isBaby = 1;
       else this.isBaby = 0;
   }

   public String getAvatar() {
       return Avatar;
   }

   public void setAvatar(String avatar) {
       Avatar = avatar;
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

   public String getFirstName() {
       return firstname;
   }

   public void setFirstName(String firstname) {
       this.firstname = firstname;
   }

   public String getLastName() {
       return lastname;
   }

   public void setLastName(String lastname) {
       this.lastname = lastname;
   }

   public Date getLastLoggedIn() {
       return lastLoggedIn;
   }

   public void setLastLoggedIn(Date lastLoggedIn) {
       this.lastLoggedIn = lastLoggedIn;
   }

}

