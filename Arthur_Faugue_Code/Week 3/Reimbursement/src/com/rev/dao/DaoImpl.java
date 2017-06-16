package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.util.ConnectionFactory;
import com.rev.pojo.Request;
import com.rev.pojo.User;

public class DaoImpl implements DAO {

	@Override
	public User userLogin(String em, String pw) {
		User u = new User();
		ArrayList<Integer> reqs = new ArrayList<Integer>();
		try (Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM USER_E WHERE EMAIL = ? AND PASSWRD = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, pw);

			ResultSet userinfo = ps.executeQuery();
			while (userinfo.next()) {
				u.setId(userinfo.getInt(1));
				u.setEm(userinfo.getString(2));
				u.setPw(userinfo.getString(3));
				u.setFn(userinfo.getString(4));
				u.setLn(userinfo.getString(5));
				u.setIsBoss(userinfo.getInt(6));
			}
			reqs = getUserRequest(u);
			u.setUserRequest(reqs);

			// System.out.println(u.toString());
			return u;

		} catch (SQLException e) {
			System.out.println("userLogin Error");
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public ArrayList<Integer> getUserRequest(User u) {
		ArrayList<Integer> reqArr = new ArrayList<Integer>();
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT *  FROM REQUEST R " + "INNER JOIN USER_E E " + "ON R.REQUESTER_ID = E.U_ID "
					+ "where E.U_ID = ?";

			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, u.getId());

			ResultSet userinfo = ps.executeQuery();
			while (userinfo.next()) {
				// System.out.println(req.toString());
				reqArr.add(userinfo.getInt(1));
			}
			return reqArr;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reqArr;
	}
	
	@Override
	public ArrayList<Request> getUserRequests(User u) {
		ArrayList<Request> reqArr = new ArrayList<Request>();
		Request req = new Request();
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT *  FROM REQUEST R "
					+ "INNER JOIN USER_E E "
					+ "ON R.REQUESTER_ID = E.U_ID "
					+ "where E.U_ID = ?";
			
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, u.getId());
			
			ResultSet userinfo = ps.executeQuery();
			while(userinfo.next()){
				req.setId(userinfo.getInt(1));
				req.setStateId(userinfo.getInt(2));
				req.setReqDate(userinfo.getDate(3));
				req.setResDate(userinfo.getDate(4));
				req.setAmount(userinfo.getDouble(5));
				req.setReqId(userinfo.getInt(6));
				req.setResId(userinfo.getInt(7));
				req.setPurpose(userinfo.getString(8));
				req.setNote(userinfo.getString(9));
				
//				System.out.println(req.toString());
				reqArr.add(req);
				req = new Request();
			}
			return reqArr;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return reqArr;
	}
	
	@Override
	public ArrayList<Request> getUserRequestsByStateId(User u, int id){
		ArrayList<Request> reqArr = new ArrayList<Request>();
		Request req = new Request();
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT *  FROM REQUEST R "
					+ "INNER JOIN USER_E E "
					+ "ON R.REQUESTER_ID = E.U_ID "
					+ "where E.U_ID = ?"
					+ "AND R.STATE_ID = ?";
			
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.setInt(2, id);
			
			ResultSet userinfo = ps.executeQuery();
			while(userinfo.next()){
				req.setId(userinfo.getInt(1));
				req.setStateId(userinfo.getInt(2));
				req.setReqDate(userinfo.getDate(3));
				req.setResDate(userinfo.getDate(4));
				req.setAmount(userinfo.getDouble(5));
				req.setReqId(userinfo.getInt(6));
				req.setResId(userinfo.getInt(7));
				req.setPurpose(userinfo.getString(8));
				req.setNote(userinfo.getString(9));
				
				System.out.println(req.toString());
				reqArr.add(req);
				req = new Request();
			}
			return reqArr;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return reqArr;
	}

	@Override
	public String getRequestType(Request r) {
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean makeRequest(User u, double amount, String note) {
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			String sql = "INSERT INTO REQUEST(AMOUNT, REQUESTER_ID, PURPOSE)"
					+ "VALUES(?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, u.getId());
			ps.setString(3, note);
			
			int x = ps.executeUpdate();
			System.out.println(x +" Rows Affected");
			
			if(x==0){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User u, String em, String pw) {
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			String sql = "UPDATE USER_E "
					+ "SET EMAIL = ?, PASSWRD = ? "
					+ "WHERE U_ID = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, pw);
			ps.setInt(3, u.getId());
			
			int x = ps.executeUpdate();
			System.out.println(x +" Rows Updated");
			
			if(x==0){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUser(User u) {
		ArrayList<Integer> reqs = new ArrayList<Integer>();
		try (Connection connect = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM USER_E WHERE U_ID = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, u.getId());

			ResultSet userinfo = ps.executeQuery();
			while (userinfo.next()) {
				u.setId(userinfo.getInt(1));
				u.setEm(userinfo.getString(2));
				u.setPw(userinfo.getString(3));
				u.setFn(userinfo.getString(4));
				u.setLn(userinfo.getString(5));
				u.setIsBoss(userinfo.getInt(6));
			}
			reqs = getUserRequest(u);
			u.setUserRequest(reqs);

			// System.out.println(u.toString());
			return u;

		} catch (SQLException e) {
			System.out.println("userLogin Error");
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public ArrayList<Request> getAllRequests() {
		ArrayList<Request> reqArr = new ArrayList<Request>();
		Request req = new Request();
		ArrayList<String> info = new ArrayList<String>();
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM REQUEST INNER JOIN USER_E ON REQUEST.REQUESTER_ID = USER_E.U_ID";
            Statement stmt = connect.createStatement();

            ResultSet userinfo = stmt.executeQuery(sql);
            while (userinfo.next()) {
            	req.setId(userinfo.getInt(1));
				req.setStateId(userinfo.getInt(2));
				req.setReqDate(userinfo.getDate(3));
				req.setResDate(userinfo.getDate(4));
				req.setAmount(userinfo.getDouble(5));
				req.setReqId(userinfo.getInt(6));
				req.setResId(userinfo.getInt(7));
				req.setPurpose(userinfo.getString(8));
				req.setNote(userinfo.getString(9));
				
				info = getUserFromId(userinfo.getInt(6));//get requester fn/ln
				req.setReqFn(info.get(0));
				req.setReqLn(info.get(1));
				info = new ArrayList<String>();
				
				info = getUserFromId(userinfo.getInt(7));//get resolver fn/ln
				if(info.isEmpty()){
					
				}else{
					req.setResFn(info.get(0));
					req.setResLn(info.get(1));
					info = new ArrayList<String>();
				}
				
				
//				System.out.println(req.toString());
				reqArr.add(req);
				req = new Request();
            }
            return reqArr;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reqArr;
	}

	@Override
	public ArrayList<String> getUserFromId(int id) {
		ArrayList<String> info = new ArrayList<String>();
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT FIRSTNAME, LASTNAME FROM USER_E "
					+ "WHERE U_ID = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet userinfo = ps.executeQuery();
			while (userinfo.next()) {
				info.add(userinfo.getString(1));
				info.add(userinfo.getString(2));
			}
			return info;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public int allRequested() {
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM REQUEST INNER JOIN USER_E ON REQUEST.REQUESTER_ID = USER_E.U_ID";
            Statement stmt = connect.createStatement();

            ResultSet userinfo = stmt.executeQuery(sql);
            int x = 0;
            while (userinfo.next()) {
            	x++;
            }
            return x;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int allResolved() {
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM REQUEST INNER JOIN USER_E ON REQUEST.REQUESTER_ID = USER_E.U_ID "
					+ "WHERE REQUEST.STATE_ID = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, 2);

			ResultSet userinfo = ps.executeQuery();
            int x = 0;
            while (userinfo.next()) {
            	x++;
            }
            return x;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int allPending() {
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM REQUEST INNER JOIN USER_E ON REQUEST.REQUESTER_ID = USER_E.U_ID "
					+ "WHERE REQUEST.STATE_ID = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, 1);

			ResultSet userinfo = ps.executeQuery();
            int x = 0;
            while (userinfo.next()) {
            	x++;
            }
            return x;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int allDenied() {
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM REQUEST INNER JOIN USER_E ON REQUEST.REQUESTER_ID = USER_E.U_ID "
					+ "WHERE REQUEST.STATE_ID = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, 3);

			ResultSet userinfo = ps.executeQuery();
            int x = 0;
            while (userinfo.next()) {
            	x++;
            }
            return x;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Request> getAllRequestsByStateId(int id) {
		ArrayList<Request> reqArr = new ArrayList<Request>();
		Request req = new Request();
		ArrayList<String> info = new ArrayList<String>();
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM REQUEST INNER JOIN USER_E ON REQUEST.REQUESTER_ID = USER_E.U_ID "
					+ "WHERE REQUEST.STATE_ID = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet userinfo = ps.executeQuery();
            while (userinfo.next()) {
            	req.setId(userinfo.getInt(1));
				req.setStateId(userinfo.getInt(2));
				req.setReqDate(userinfo.getDate(3));
				req.setResDate(userinfo.getDate(4));
				req.setAmount(userinfo.getDouble(5));
				req.setReqId(userinfo.getInt(6));
				req.setResId(userinfo.getInt(7));
				req.setPurpose(userinfo.getString(8));
				req.setNote(userinfo.getString(9));
				
				info = getUserFromId(userinfo.getInt(6));//get requester fn/ln
				req.setReqFn(info.get(0));
				req.setReqLn(info.get(1));
				info = new ArrayList<String>();
				
				info = getUserFromId(userinfo.getInt(7));//get resolver fn/ln
				if(info.isEmpty()){
					
				}else{
					req.setResFn(info.get(0));
					req.setResLn(info.get(1));
					info = new ArrayList<String>();
				}
				
				
//				System.out.println(req.toString());
				reqArr.add(req);
				req = new Request();
            }
            return reqArr;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reqArr;
	}

	@Override
	public boolean approveRequest(int rid, int sid, int resid, String note){
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			System.out.println("here1");
			String sql = "UPDATE REQUEST SET STATE_ID = ?, NOTE = ?, RESOLVER_ID = ?, "
					+ " DATE_RESOLVE = CURRENT_TIMESTAMP WHERE R_ID = ? ";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, sid);
			ps.setString(2, note);
			ps.setInt(3, resid);
			ps.setInt(4, rid);
			
			int x = ps.executeUpdate();
			System.out.println(x +" Rows Updated");
			if(x==0){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<User> getAllEmployees() {
		ArrayList<User> usrArr = new ArrayList<User>();
		User usr = new User();
		ArrayList<String> info = new ArrayList<String>();
		DAO dao = new DaoImpl();
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM USER_E ";
            Statement stmt = connect.createStatement();

            ResultSet userinfo = stmt.executeQuery(sql);
            while (userinfo.next()) {
				usr.setId(userinfo.getInt(1));
				usr.setEm(userinfo.getString(2));
				usr.setPw(userinfo.getString(3));
				usr.setFn(userinfo.getString(4));
				usr.setLn(userinfo.getString(5));
				usr.setIsBoss(userinfo.getInt(6));
				usr.setUserRequest(dao.getUserRequest(usr));
				
//				System.out.println(usr.toString());
				usrArr.add(usr);
				usr = new User();
            }
            return usrArr;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usrArr;
	}
	

}
