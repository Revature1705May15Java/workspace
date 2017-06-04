package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.bank.logs.Logger;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.util.ConnectionFactory;
import com.bank.util.ConnectionsUtil;

public class DaoImpl implements DAO{
	
	static Logger logger = new Logger();
	static DateTimeFormatter form = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
	static LocalDateTime now;
	static Date today;
	
	public void newAccount(int accountType,int userid){
		try(Connection connection =ConnectionFactory.getInstance().getConnection();){
			String sql="{call new_account(?,?)}";
			CallableStatement cs = connection.prepareCall(sql);
			cs.setInt(1, accountType);
			cs.setInt(2, userid);	
			cs.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public ArrayList<AccountType> fetchAccountTypes(){
		ArrayList<AccountType> accounttypes=new ArrayList<AccountType>();
		Statement statement = null;
		try(Connection connection =ConnectionFactory.getInstance().getConnection();){
			String sql="select * from accounttype order by typeid";
			statement = connection.createStatement();
			
			ResultSet info = statement.executeQuery(sql);
			
			while(info.next()){
				AccountType temp = new AccountType();
				temp.setId(info.getInt(1));
				temp.setName(info.getString(2));
				accounttypes.add(temp);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return accounttypes;
	}
	public ArrayList<Integer> findAccounts(int userid){
		ArrayList<Integer> accounts=new ArrayList<Integer>();
		try(Connection connection =ConnectionFactory.getInstance().getConnection();){
			String sql=" select * from user_account where userid=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userid);
			
			ResultSet info = ps.executeQuery();
			
			if(!info.isBeforeFirst()){
				logger.log("User:ID:"+userid+": User has no accounts");
				return null;
			}
			while(info.next()){
				accounts.add(info.getInt(2));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return accounts;
	}
	public ArrayList<Integer> findAccountHolders(int accountid){
		ArrayList<Integer> holders=new ArrayList<Integer>();
		try(Connection connection =ConnectionFactory.getInstance().getConnection();){
			String sql=" select * from user_account where accountid=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, accountid);
			
			ResultSet info = ps.executeQuery();
			
			if(!info.isBeforeFirst()){
				logger.log("Account:ID:"+accountid+": User has no accounts");
				return null;
			}
			while(info.next()){
				holders.add(info.getInt(1));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return holders;
	}
	public int updateBalance(Account account,double newbal){
		return 0;
	}
	@Override
	public int addUser(String fn,String ln, String uname, String pw){
		
		try(Connection connection =ConnectionFactory.getInstance().getConnection();){
			String sql=" insert into users(FIRSTNAME,LASTNAME,PASSWORD,USERNAME)"
					+"values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, pw);
			ps.setString(4, uname);
			
			int num = ps.executeUpdate();
			logger.log(num+" users added");
			System.out.println();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public User getUser(int id) {
		User u = new User();
		try(Connection connection =ConnectionFactory.getInstance().getConnection();){
			
			String sql="select * from users where "
					+"userid=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet info = ps.executeQuery();
			
			if(!info.isBeforeFirst()){
				logger.log("ID:"+id+": No User found");
				return null;
			}
			while(info.next()){
				
				u.setId(info.getInt(1));
				u.setFn(info.getString(2));
				u.setLn(info.getString(3));
				u.setPw(info.getString(4));
				u.setUname(info.getString(4));;
				logger.log("User found by ID: User ID: "+u.getId()+" Name: "+u.getFn()+" "+u.getLn());
				return u;
			}
				
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return u;
	}
	@Override
	public User getUser(String uname){
		User u = new User();
		try(Connection connection =ConnectionFactory.getInstance().getConnection();){
			
			String sql="select * from users where "
					+"username=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, uname);
			
			ResultSet info = ps.executeQuery();
			
			if(!info.isBeforeFirst()){
				logger.log("User: "+uname+" not found");
				return null;
			}
			while(info.next()){
				u.setId(info.getInt(1));
				u.setFn(info.getString(2));
				u.setLn(info.getString(3));
				u.setPw(info.getString(3));
				u.setUname(info.getString(4));
				logger.log("User found by username: User ID: "+u.getId()+" Name: "+u.getFn()+" "+u.getLn());
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return u;
	}
	public Account getAccount(int id) {
		Account a = new Account();
		try(Connection connection =ConnectionFactory.getInstance().getConnection();){
			
			String sql="select * from account where "
					+"accountid=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			if(!info.isBeforeFirst()){
				logger.log("ID:"+id+": No Account found");
				return null;
			}
			while(info.next()){
				a.setId(info.getInt(1));
				a.setBalance(info.getDouble(2));
//				a.setType(info.getInt(3));
				a.setDateOpened(info.getDate(4));
				a.setDateClosed(info.getDate(5));
				logger.log("Account found: Account ID: "+id);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return a;
	}
	private boolean changeUserInfo(String vartochange,String newinfo,String uname){
		User u=new User();
		u=getUser(uname);
		if(u!=null){
			try(Connection connection =ConnectionFactory.getInstance().getConnection();){
				String sql="update users set "+vartochange+" = ? where username = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, newinfo);
				ps.setString(2, uname);
				ps.executeUpdate(sql);
				}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return(u!=null);
	}
	private boolean changeAccountInfo(String vartochange, double newinfo, int id){
		Account a=getAccount(id);
		if(a!=null){
			try(Connection connection =ConnectionFactory.getInstance().getConnection();){
					if(vartochange.equals("closed")){
						String sql="update account set closed = current_date where accountid = ?";
						PreparedStatement ps = connection.prepareStatement(sql);
						ps.setInt(1, id);
						ps.executeUpdate();
						logger.log("Account number "+id+"has been closed.");
					}
					if(vartochange.equals("balance")){
						double newbalance=a.getBalance()+newinfo;
						if(newbalance>0){
							String sql="update account set balance = balance + ? where accountid = ?";
							PreparedStatement ps = connection.prepareStatement(sql);
							ps.setDouble(1, newinfo);
							ps.setInt(2, id);
							ps.executeUpdate();
							if(newinfo>0){
								logger.log("Account "+id+" deposit made for $"+newinfo+", new balance is $"+newbalance);
							}else{
								logger.log("Account "+id+" withdrawal made for $"+newinfo+", new balance is $"+newbalance);
							}
							return true;
						}else{
							logger.log("Funds in account "+id+" insufficient for withdrawal, transaction declined.");
							return false;
						}
					}
					
				}catch(SQLException e){
				e.printStackTrace();
				}
		}
		return(a!=null);
	}
	public boolean receiveGenericChange(String tabletochange,String vartochange,String newinfo,String idname){
		if(tabletochange.equals("users")){
			return changeUserInfo(vartochange,newinfo,idname);
			
		}
		if(tabletochange.equals("account")){
			if(vartochange.equals("closed")){
				return changeAccountInfo("closed",0,Integer.parseInt(idname));
			}else{
				System.out.println("changing balance");
			return changeAccountInfo(vartochange,Double.parseDouble(newinfo),Integer.parseInt(idname));

			}
		}
		return false;
	}
	
	
}
