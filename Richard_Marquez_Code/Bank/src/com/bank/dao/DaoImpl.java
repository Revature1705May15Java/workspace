package com.bank.dao;

import com.bank.logs.Logger;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.util.ConnectionUtil;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;

public class DaoImpl implements Dao {

    @Override
    public boolean addUserToAccount(User u, Account a) {
        return false;
    }

    @Override
    public boolean addUser(String fName, String lName, String password, String email) {
        boolean result = false;

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO banker(fname, lname, password, email) VALUES(?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, password);
            ps.setString(4, email);

            if (ps.executeUpdate() == 1) {
                Logger.log("1 user added");
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Account addAccount(User u, int typeId) {
        Account a = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "insert into account(typeid) values(?) returning accountid into ?";

            OraclePreparedStatement ps = (OraclePreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, typeId);
            ps.registerReturnParameter(2, OracleTypes.NUMBER);

            int count = ps.executeUpdate();

            if (count > 0) {
                ResultSet rs = ps.getReturnResultSet();


                if (rs.next()) {
                    int newAccountId = rs.getInt(1);

                    String sql2 = "insert into bankeraccount values(?, ?)";

                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setInt(1, u.getId());
                    ps2.setInt(2, newAccountId);

                    ps2.executeUpdate();
                    a = getAccount(newAccountId);

                    Logger.log("added acct " + newAccountId);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return a;
    }

    @Override
    public boolean updateUser(User u) {
        boolean result = false;

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "update banker set fname=?, lname=?, password=?, email=? where userid=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getFirstName());
            ps.setString(2, u.getLastName());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getEmail());
            ps.setInt(5, u.getId());

            int count = ps.executeUpdate();

            if (count == 1) {
                result = true;
                Logger.log("updated user w/ id " + u.getId());
            }

        } catch (SQLException e) {
            //e.printStackTrace();
            Logger.log("failed to update user w/ id " + u.getId());
        }

        return result;
    }

    @Override
    public boolean updateAccount(Account a) {
        boolean result = false;

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "update account set balance=?, closed=? where accountid=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, a.getBalance());
            ps.setDate(2, (a.getClosed() == null) ? null : Date.valueOf(a.getClosed()));
            ps.setInt(3, a.getId());

            int count = ps.executeUpdate();

            if (count == 1) {
                result = true;
                Logger.log("updated acct w/ id " + a.getId());
            }

        } catch (SQLException e) {
            //e.printStackTrace();
            Logger.log("failed to update acct w/ id " + a.getId());
        }

        return result;
    }

    @Override
    public User getUser(String email) {
        User result = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM banker WHERE email=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                result.setAccounts(getAccountIdsForUser(result));
                Logger.log("retrieved user w/ email " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.log("failed to retrieve user w/ email " + email);
        }

        return result;
    }

    private ArrayList<Integer> getAccountIdsForUser(User u) {
        ArrayList<Integer> accountIds = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT BANKERACCOUNT.ACCOUNTID FROM bankeraccount WHERE USERID=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, u.getId());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                accountIds.add(rs.getInt(1));
                Logger.log("retrieved acct id " + rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.log("failed to retrieve acct ids for user " + u);
        }

        return accountIds;
    }


    private ArrayList<Integer> getUserIdsForAccount(Account a) {
        ArrayList<Integer> userIds = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT BANKERACCOUNT.USERID FROM bankeraccount WHERE ACCOUNTID=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, a.getId());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                userIds.add(rs.getInt(1));
                Logger.log("retrieved user id " + rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.log("failed to retrieve user ids for user " + a);
        }

        return userIds;
    }

    @Override
    public User getUser(int id) {
        User result = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM banker WHERE userid=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                result.setAccounts(getAccountIdsForUser(result));
                Logger.log("retrieved user w/ id " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.log("failed to retrieve user w/ id " + id);
        }

        return result;
    }

    @Override
    public Account getAccount(int id) {
        Account result = null;

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM account inner join ACCOUNTTYPE on ACCOUNT.TYPEID=ACCOUNTTYPE.TYPEID " +
                    "where account.accountid=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new Account(
                        rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDate(4).toLocalDate(),
                        rs.getDate(5) == null ? null : rs.getDate(5).toLocalDate(),
                        new AccountType(rs.getInt(3), rs.getString(7))
                );
                result.setUsers(getUserIdsForAccount(result));
                Logger.log("retrieved acct w/ id " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.log("failed to retrieve acct w/ id " + id);
        }

        return result;
    }

    @Override
    public ArrayList<Account> getAccountsForUser(User u) {
        ArrayList<Account> accounts = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select account.accountid, account.balance, account.opened, account.closed, accounttype.typeid, accounttype.name " +
                    "from bankeraccount " +
                    "inner join banker on bankeraccount.userid = banker.userid " +
                    "inner join account on bankeraccount.accountid = account.accountid " +
                    "inner join accounttype on accounttype.typeid = account.typeid " +
                    "where banker.userId=?";


            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, u.getId());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Account a = new Account(
                        rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDate(3).toLocalDate(),
                        rs.getDate(4) != null ? rs.getDate(4).toLocalDate() : null,
                        new AccountType(rs.getInt(5), rs.getString(6))
                );
                a.setUsers(getUserIdsForAccount(a));
                accounts.add(a);
                Logger.log("retrieved account w/ id " + a.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.log("failed to retrieve accts associate w/ " + u.getEmail());
        }

        return accounts;
    }

    @Override
    public ArrayList<User> getUsersForAccount(Account a) {
        ArrayList<User> users = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select banker.userId, banker.fName, banker.lName, banker.password, banker.email, account.accountid " +
                    "from bankeraccount " +
                    "inner join banker on bankeraccount.userid = banker.userid " +
                    "inner join account on bankeraccount.accountid = account.accountid " +
                    "where account.accountId=?";


            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, a.getId());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                u.setAccounts(getAccountIdsForUser(u));

                users.add(u);
                Logger.log("retrieved user w/ id " + u.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.log("failed to retrieve users associated w/ " + a.getId());
        }

        return users;
    }

    @Override
    public int getNumOfAccounts(User u) {
        int result = 0;

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "{ ? = call getNumAccounts(?) }";

            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(2, u.getId());
            cs.registerOutParameter(1, Types.INTEGER);

            cs.execute();
            result = cs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.log("failed to retrieve  number of accts for userid w/ " + u.getId());
        }

        return result;
    }

    @Override
    public ArrayList<AccountType> getAccountTypes() {
        ArrayList<AccountType> types = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from ACCOUNTTYPE";

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                AccountType at = new AccountType(
                        rs.getInt(1),
                        rs.getString(2)
                );
                types.add(at);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Logger.log("failed to retrieve acct types");
        }

        return types;
    }

    @Override
    public boolean transferFunds(int fromId, int toId, double amt) {
        boolean result = false;

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "{ call transferFunds(?, ?, ?) }";

            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, fromId);
            cs.setInt(2, toId);
            cs.setDouble(3, amt);

            cs.execute();
            result = true;

        } catch (SQLException e) {
//			e.printStackTrace();
            Logger.log("failed to transfer funds from " + fromId + " to " + toId);
        }

        return result;
    }
}
