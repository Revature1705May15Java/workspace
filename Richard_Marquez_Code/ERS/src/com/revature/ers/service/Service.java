package com.revature.ers.service;

import com.revature.ers.dao.Dao;
import com.revature.ers.dao.DaoImpl;
import com.revature.ers.pojos.User;
import com.revature.ers.util.Logger;
import com.revature.ers.util.Mailer;
import com.revature.ers.util.PasswordStorage;

public class Service {

    private static Dao dao = new DaoImpl();

    public static void main(String[] args) {
        addUser("eric.clapton@me.com", "password", "eric", "clapton", false);
    }

    private static User addUser(String email, String password, String fName, String lName, boolean isManager) {
        User newUser = null;

        try {
            String hashedPassword = PasswordStorage.createHash(password);
            if (dao.addUser(email, hashedPassword, fName, lName, isManager)) {
                newUser = dao.getUser(email);

                Mailer.sendMail(email, "New Revature ERS account", "You successfully created an account.");
            }
        } catch (Exception e) {
            Logger.log(e.getStackTrace().toString());
        }

        return newUser;
    }

    public User login(String email, String password) {
        User possibleUser = dao.getUser(email);
        User result = null;

        try {
            boolean correctPassword = PasswordStorage.verifyPassword(password, possibleUser.getPassword());

            if (possibleUser != null && correctPassword && possibleUser.getEmail().equals(email)) {
                result = possibleUser;
            }
        } catch (Exception e) {
            Logger.log(e.getMessage());
        }

        return result;
    }

}
