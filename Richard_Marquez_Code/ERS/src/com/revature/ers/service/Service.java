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
import java.security.*;

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

    public User getUser(int id) {
        return dao.getUser(id);
    }

//    public static void main(String[] args) {
//        Service.getInstance().addUser("richard92m@me.com", "password", "Richard", "Marquez", true);
//    }

    public User addUser(String email, String password, String fName, String lName, boolean isManager) {
        User newUser = null;

        try {
            String hashedPassword = PasswordStorage.createHash(password);
            if (dao.addUser(email, hashedPassword, fName, lName, isManager)) {
                newUser = dao.getUser(email);

                String emailSubject = "New Revature ERS account";
                String emailBody = "Greetings, " + fName + " " + lName + "!\n\n" +
                        "You have been successfully registered for a Revature reimbursement account.\n" +
                        "Your temporary password is: " + password + "\n" +
                        "Please log in NOW to update your password.\n\n" +
                        "Many thanks,\nSuch regards,\nGood times,\nRevature ERS (May15Java)";
                Mailer.sendMail(email, emailSubject, emailBody);
            }
        } catch (Exception e) {
            Logger.log(e.getStackTrace().toString());
        }

        return newUser;
    }

    public User addUser(String email, String fName, String lName, boolean isManager) {
        String randomPass = randomString(8);
        return addUser(email, randomPass, fName, lName, isManager);
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

    public List<ReimbursementRequest> getAllPendingRequests() {
        List<ReimbursementRequest> result = new ArrayList<>();
        List<ReimbursementRequest> allReqs = dao.getAllRequests();

        for (ReimbursementRequest r : allReqs) {
            if (r.getState() == ReimbursementRequest.StateType.PENDING) {
                result.add(r);
            }
        }

        return result;
    }

    public List<ReimbursementRequest> getRequestArchive() {
        List<ReimbursementRequest> result = new ArrayList<>();
        List<ReimbursementRequest> allReqs = dao.getAllRequests();

        for (ReimbursementRequest r : allReqs) {
            if (r.getState() != ReimbursementRequest.StateType.PENDING) {
                result.add(r);
            }
        }

        return result;
    }

    public List<User> getAllEmployees() {
        List<User> result = new ArrayList<>();
        List<User> allUsers = dao.getAllUsers();

        for (User u : allUsers) {
            if (!u.isManager()) {
                result.add(u);
            }
        }

        return result;
    }

    public boolean approveRequest(int reqId, User handler, String note) {
        ReimbursementRequest req = dao.getRequest(reqId);

        req.setState(ReimbursementRequest.StateType.APPROVED);
        req.setHandlerEmail(handler.getEmail());
        req.setNote(note);
        req.setDateResolved(LocalDate.now());

        boolean updateResult = dao.updateRequest(req);

        if (updateResult) {
            String emailSubject = "Revature ERS request - Approved";
            String emailBody = "Greetings!\n\n" +
                    "Your request for a reimbursement of $" + req.getAmount() + " has been APPROVED.\n" +
                    "Please log in to view the details of this request.\n\n" +
                    "Many thanks,\nSuch regards,\nGood times,\nRevature ERS (May15Java)";
            Mailer.sendMail(req.getRequesterEmail(), emailSubject, emailBody);
        }

        return updateResult;
    }

    public boolean denyRequest(int reqId, User handler, String note) {
        ReimbursementRequest req = dao.getRequest(reqId);

        req.setState(ReimbursementRequest.StateType.DENIED);
        req.setHandlerEmail(handler.getEmail());
        req.setNote(note);
        req.setDateResolved(LocalDate.now());

        boolean updateResult = dao.updateRequest(req);
        if (updateResult) {
            String emailSubject = "Revature ERS request - Denied";
            String emailBody = "Greetings!\n\n" +
                    "Your request for a reimbursement of $" + req.getAmount() + " has been DENIED.\n" +
                    "Please log in to view the details of this request.\n\n" +
                    "Many thanks,\nSuch regards,\nGood times,\nRevature ERS (May15Java)";
            Mailer.sendMail(req.getRequesterEmail(), emailSubject, emailBody);
        }

        return updateResult;
    }

    public boolean resetPassword(String email) {
        User u = dao.getUser(email);
        boolean result = u != null;

        if (result) {
            String randomPass = randomString(8);
            User updatedUser = updateUser(u, u.getEmail(), randomPass, u.getFirstName(), u.getLastName());
            if (updatedUser != null) {
                result = true;

                String emailSubject = "Revature ERS password reset";
                String emailBody = "Greetings!\n\n" +
                        "Your request to reset your password has been received..\n" +
                        "Your new temporary password is: " + randomPass + "\n" +
                        "Please log in NOW to change your password.\n\n" +
                        "Many thanks,\nSuch regards,\nGood times,\nRevature ERS (May15Java)";
                Mailer.sendMail(email, emailSubject, emailBody);
            }
        }

        return result;
    }


    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    String randomString(int len){
        StringBuilder sb = new StringBuilder(len);
        for( int i = 0; i < len; i++ ) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
}
