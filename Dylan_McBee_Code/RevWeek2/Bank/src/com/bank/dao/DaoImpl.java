package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import com.bank.logs.Logger;
import com.bank.pojos.Account;
import com.bank.pojos.Type;
import com.bank.pojos.User;
import com.bank.util.ConnectionUtil;

public class DaoImpl implements DAO {

	static Logger logger = new Logger();

	@Override
	public boolean updateBalance(int id, double newBal) {
		try (Connection connection = ConnectionUtil.getConnection();) {
			// SQL query for updating the balance of a specific account
			String sql = "UPDATE Account SET balance = ? WHERE acct_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, newBal);
			ps.setInt(2, id);
			
			int row = ps.executeUpdate();
			if (row == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int addUser(String fn, String ln, String uName, String pw) {
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "INSERT INTO USERS(first_name, last_name, password, username) values(?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, pw);
			ps.setString(4, uName);

			int num = ps.executeUpdate();
			logger.log(num + " users added");
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User getUser(String uName) {
		User u = new User();
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select * from users where USERNAME = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, uName.toLowerCase());
			ResultSet info = ps.executeQuery();

			// id fn ln pw uname
			while (info.next()) {
				u.setId(info.getInt(1));
				u.setFn(info.getString(2));
				u.setLn(info.getString(3));
				u.setPw(info.getString(4));
				u.setuName(info.getString(5));
			}

			if (u.getuName() != null) {
				logger.log("retrieved user by username: " + u.toString());
			} else {
				logger.log("User does not exist");
				return null;
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ERROR!");

		return null;

	}

	@Override
	public User getUser(int id) {
		return null;
	}

	@Override
	public int openAccount(int userId, int type_id) {
		int accountId = -1;
		try (Connection connection = ConnectionUtil.getConnection();) {
			connection.setAutoCommit(false);

			// savepoint
			Savepoint s = connection.setSavepoint();

			String sql = "insert into account(type_id) values(?)";

			String generatedColumns[] = { "acct_id" };

			PreparedStatement ps = connection.prepareStatement(sql, generatedColumns);
			ps.setInt(1, type_id);

			int num = ps.executeUpdate();
			if (num == 1) {
				ResultSet info = ps.getGeneratedKeys();
				if (info.next()) {
					int id = info.getInt(1);

					String sql2 = "insert into user_account values(?,?)";

					PreparedStatement ps2 = connection.prepareStatement(sql2);
					ps2.setInt(1, userId);
					ps2.setInt(2, id);

					int num2 = ps2.executeUpdate();
					if (num2 == 1) {
						accountId = id;
					} else
						connection.rollback(s);

				}
			} else {
				System.out.println("Error");
				connection.rollback(s);
			}
			connection.commit();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return accountId;

	}

	public Account getAccountById(int newAccountId) {
		return null;

	}



	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();

		try (Connection connect = ConnectionUtil.getConnection();) {
			String sql = "select * from users";
			PreparedStatement ps = connect.prepareStatement(sql);

			ResultSet info = ps.executeQuery();

			// id, fn, ln, state, credit, email

			while (info.next()) {
				User u = new User();
				u.setId(info.getInt(1));
				u.setFn(info.getString(2));
				u.setLn(info.getString(3));
				u.setPw(info.getString(4));
				u.setuName(info.getString(5));
				users.add(u);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ERROR!");

		return null;
	}

	@Override
	public ArrayList<Account> getAllAccounts(int currId) {
		ArrayList<Account> userAccounts = new ArrayList<Account>();
		try (Connection connection = ConnectionUtil.getConnection();) {
			String sql = "select * from account inner join user_account on account.acct_id = user_account.account_id"
					+ " and user_account.user_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, currId);

			ResultSet info = ps.executeQuery();

			while (info.next()) {
				Account account = new Account();
				account.setId(info.getInt(1));
				account.setBalance(info.getDouble(2));
				int num = info.getInt(3);
				Type type;
				if (num == 1) {
					type = Type.CHECKING;
				} else if (num == 2) {
					type = Type.SAVINGS;
				} else {
					type = Type.CREDIT;
				}
				account.setType(type);
				account.setDateOpened(info.getDate(4).toLocalDate());
				if (info.getDate(5) != null) {
					account.setDateClosed(info.getDate(5).toLocalDate());
				} else {
					account.setDateClosed(null);
				}
				if(account.getDateClosed() ==null){
				userAccounts.add(account);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userAccounts;
	}

	@Override
	public boolean closeAccount(int id) {
		try (Connection connection = ConnectionUtil.getConnection();) {
			 String sql = "{call close_account(?)}";
			
			CallableStatement cs = connection.prepareCall(sql);
			cs.setInt(1, id);
			
			int num = cs.executeUpdate();
			if (num == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}