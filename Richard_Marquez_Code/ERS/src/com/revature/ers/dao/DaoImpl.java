package com.revature.ers.dao;

import com.revature.ers.pojos.ReimbursementRequest;
import com.revature.ers.pojos.User;
import com.revature.ers.util.ConnectionFactory;
import com.revature.ers.util.Logger;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleTypes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {

    @Override
    public boolean addUser(String email, String password, String fName, String lName, boolean isManager) {
        boolean result = false;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
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

        } catch (Exception e) {
            e.printStackTrace();
            Logger.log(e.getMessage());
        }

        return result;
    }

    @Override
    public User updateUser(User u) {
        User result = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
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

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Logger.log(e.getMessage());
        }

        return result;
    }

    @Override
    public User getUser(String email) {
        User result = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
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

        } catch (Exception e) {
            e.printStackTrace();
            Logger.log(e.getMessage());
        }

        return result;
    }

    @Override
    public User getUser(int id) {
        User result = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
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
            }

        } catch (Exception e) {
            e.printStackTrace();
            Logger.log(e.getMessage());
        }

        return result;
    }

    private List<ReimbursementRequest> getRequestsForUser(User u) {
        List<ReimbursementRequest> result = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
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

        } catch (Exception e) {
            e.printStackTrace();
            Logger.log(e.getMessage());
        }

        return result;
    }

    @Override
    public int addRequest(ReimbursementRequest req) {
        int result = 0;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
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

        } catch (Exception e) {
            e.printStackTrace();
            Logger.log(e.getMessage());
        }

        return result;
    }

    @Override
    public ReimbursementRequest getRequest(int id) {
        ReimbursementRequest result = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
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
            }

        } catch (Exception e) {
            e.printStackTrace();
            Logger.log(e.getMessage());
        }

        return result;
    }
}

