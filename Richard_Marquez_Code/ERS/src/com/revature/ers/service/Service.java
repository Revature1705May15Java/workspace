package com.revature.ers.service;

import com.revature.ers.dao.Dao;
import com.revature.ers.dao.DaoImpl;
import com.revature.ers.pojos.ReimbursementRequest;
import com.revature.ers.pojos.User;
import com.revature.ers.util.Logger;
import com.revature.ers.util.Mailer;
import com.revature.ers.util.PasswordStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private static Service INSTANCE = new Service();
    private Dao dao = new DaoImpl();

    private Service() {
        dao = new DaoImpl();
    }

    public static Service getInstance() {
        return INSTANCE;
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

    public User addUser(String email, String password, String fName, String lName, boolean isManager) {
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

    public User updateUser(User user, String email, String password, String fName, String lName) {
        User updatedUser = null;

        try {
            String hashedPassword = PasswordStorage.createHash(password);

            user.setEmail(email);
            user.setPassword(hashedPassword);
            user.setFirstName(fName);
            user.setLastName(lName);

            if (dao.updateUser(user) != null) {
                updatedUser = dao.getUser(email);
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            Logger.log(e.getStackTrace().toString());
        }

        return updatedUser;
    }

    public ReimbursementRequest addRequest(User user, double amount, String purpose) {
        ReimbursementRequest result = null;

        ReimbursementRequest newReq = new ReimbursementRequest();
        newReq.setRequesterId(user.getId());
        newReq.setState(ReimbursementRequest.StateType.PENDING);
        newReq.setAmount(amount);
        newReq.setPurpose(purpose);
        newReq.setDateRequested(LocalDate.now());

        try {
            int newReqId = dao.addRequest(newReq);
            if (newReqId != 0) {
                result = dao.getRequest(newReqId);
                user.getRequests().add(result);
            }
        } catch (Exception e) {
            Logger.log(e.getStackTrace().toString());
        }

        return result;
    }

    public List<ReimbursementRequest> getAllRequests() {
        return dao.getAllRequests();
    }
}
