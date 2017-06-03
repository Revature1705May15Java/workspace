package com.revature.ers.dao;

import com.revature.ers.pojos.User;
import com.revature.ers.util.ConnectionFactory;
import com.revature.ers.util.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
                Logger.log("1 user added");
                result = true;
            }

        } catch (Exception e) {
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
                Logger.log("updated user w/ id " + u.getId());
            }

        } catch (Exception e) {
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
                Logger.log("retrieved user w/ email " + email);
            }

        } catch (Exception e) {
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
                Logger.log("retrieved user w/ id " + id);
            }

        } catch (Exception e) {
            Logger.log(e.getMessage());
        }

        return result;
    }

}

