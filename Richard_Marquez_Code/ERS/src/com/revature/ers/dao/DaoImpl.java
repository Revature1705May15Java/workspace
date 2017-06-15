package com.revature.ers.dao;

import com.revature.ers.pojos.ReimbursementRequest;
import com.revature.ers.pojos.User;
import com.revature.ers.util.ConnectionFactory;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

public class DaoImpl implements Dao {

    @Override
    public boolean addUser(String email, String password, String fName, String lName, boolean isManager) {
        boolean result = false;

//        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
        try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO users(email, password, fName, lName, isManager) VALUES(?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, fName);
            ps.setString(4, lName);
            ps.setInt(5, (isManager==true?1:0));

            if (ps.executeUpdate() == 1) {
                result = true;
            }

            Logger.getLogger(DaoImpl.class).info("Added user w/ email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(DaoImpl.class).error("Failed to add user");
        }

        return result;
    }

    @Override
    public User updateUser(User u) {
        User result = null;

        try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "UPDATE users SET email=?, password=?, fName=?, lName=? WHERE userId=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getEmail());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getFirstName());
            ps.setString(4, u.getLastName());
            ps.setInt(5, u.getId());

            int count = ps.executeUpdate();

            if (count == 1) {
                result = u;
            }

            Logger.getLogger(DaoImpl.class).info("Updated user: " + u);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(DaoImpl.class).error("Failed to update user: " + u);
        }

        return result;
    }

    @Override
    public User getUser(String email) {
        User result = null;

        try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM users WHERE email=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        (rs.getInt(6) == 1 ? true : false)
                );
                if (!result.isManager()) {
                    result.setRequests(getRequestsForUser(result));
                }
            }

            Logger.getLogger(DaoImpl.class).info("Retrieved user: " + result);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(DaoImpl.class).error("Failed to get user: " + email);
        }

        return result;
    }

    @Override
    public User getUser(int id) {
        User result = null;

        try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM users WHERE userId=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        (rs.getInt(6) == 1 ? true : false)
                );
                if (!result.isManager()) {
                    result.setRequests(getRequestsForUser(result));
                }
            }

            Logger.getLogger(DaoImpl.class).info("Retrieved user: " + result);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(DaoImpl.class).error("Failed to get user: " + id);
        }

        return result;
    }

    private List<ReimbursementRequest> getRequestsForUser(User u) {
        List<ReimbursementRequest> result = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = " SELECT REQUESTID, REQUESTERID, HANDLERID, STATETYPEID, AMOUNT, PURPOSE, NOTE, DATEREQUESTED, DATEHANDLED " +
                "FROM REQUEST " +
                "INNER JOIN users ON REQUEST.REQUESTERID = USERS.USERID " +
                "WHERE REQUESTERID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, u.getId());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.add(new ReimbursementRequest(
                        rs.getInt(1),
                        rs.getInt(2),
                        (rs.getInt(3) != 0 ? getUser(rs.getInt(3)).getEmail() : null),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8).toLocalDate(),
                        (rs.getDate(9) != null ? rs.getDate(9).toLocalDate() : null)
                ));
            }

            Logger.getLogger(DaoImpl.class).info("Retrieved requests for user: " + u.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(DaoImpl.class).error("Failed to get requests for user: " + u.getEmail());
        }

        return result;
    }

    @Override
    public int addRequest(ReimbursementRequest req) {
        int result = 0;

        try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO request(requesterId, stateTypeId, amount, " +
                "purpose, dateRequested) VALUES(?, ?, ?, ?, ?) RETURNING requestId INTO ?";

            OraclePreparedStatement ps = (OraclePreparedStatement) conn.prepareStatement(sql);

            ps.setInt(1, req.getRequesterId());
            ps.setInt(2, req.getState().ordinal());
            ps.setDouble(3, req.getAmount());
            ps.setString(4, req.getPurpose());
            ps.setDate(5, Date.valueOf(req.getDateRequested()));

            ps.registerReturnParameter(6, OracleTypes.NUMBER);

            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getReturnResultSet();
                rs.next();
                result = rs.getInt(1);
            }

            Logger.getLogger(DaoImpl.class).info("added req: " + result);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(DaoImpl.class).error("Failed to add req: " + req);
        }

        return result;
    }

    @Override
    public ReimbursementRequest getRequest(int id) {
        ReimbursementRequest result = null;

        try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM request WHERE requestId=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new ReimbursementRequest(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3) != 0 ? getUser(rs.getInt(3)).getEmail() : null,
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8) != null ? rs.getDate(8).toLocalDate() : null,
                        rs.getDate(9) != null ? rs.getDate(9).toLocalDate() : null
                );
                result.setRequesterEmail(getUser(result.getRequesterId()).getEmail());
            }

            Logger.getLogger(DaoImpl.class).info("Retrieved request: " + result);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(DaoImpl.class).error("Failed to retrieve request: " + id);
        }

        return result;
    }

    @Override
    public List<ReimbursementRequest> getAllRequests() {
        List<ReimbursementRequest> result = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM request INNER JOIN users ON REQUEST.REQUESTERID = USERS.USERID";
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ReimbursementRequest newReq = new ReimbursementRequest(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3) != 0 ? getUser(rs.getInt(3)).getEmail() : null,
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8) != null ? rs.getDate(8).toLocalDate() : null,
                        rs.getDate(9) != null ? rs.getDate(9).toLocalDate() : null
                );
//                newReq.setRequesterEmail(getUser(newReq.getRequesterId()).getEmail());
                newReq.setRequesterEmail(rs.getString(11));
                result.add(newReq);
            }

            Logger.getLogger(DaoImpl.class).info("Retrieved all requests");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(DaoImpl.class).error("Failed to retrieve all requests");
        }

        return result;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User newUser = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        (rs.getInt(6) == 1 ? true : false)
                );
                result.add(newUser);
            }

            Logger.getLogger(DaoImpl.class).info("Retrieved all users");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(DaoImpl.class).error("Failed to retrieve all requests");
        }

        return result;
    }

    @Override
    public boolean updateRequest(ReimbursementRequest req) {
        boolean result = false;

        try {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "UPDATE REQUEST " +
                "SET REQUESTERID=?, HANDLERID=?, STATETYPEID=?, AMOUNT=?, " +
                "PURPOSE=?, NOTE=?, DATEREQUESTED=?, DATEHANDLED=? " +
                "WHERE REQUESTID=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, req.getRequesterId());
            ps.setInt(2, getUser(req.getHandlerEmail()).getId());
            ps.setInt(3, req.getState().ordinal());
            ps.setDouble(4, req.getAmount());
            ps.setString(5, req.getPurpose());
            ps.setString(6, req.getNote());
            ps.setDate(7, Date.valueOf(req.getDateRequested()));

            LocalDate dateHandled = req.getDateResolved();
            ps.setDate(8, dateHandled != null ? Date.valueOf(dateHandled) : null);

            ps.setInt(9, req.getId());

            if (ps.executeUpdate() == 1) {
                result = true;
            }

            Logger.getLogger(DaoImpl.class).info("Updated req: " + req);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(DaoImpl.class).error("Failed to update req: " + req);
        }

        return result;
    }
}

