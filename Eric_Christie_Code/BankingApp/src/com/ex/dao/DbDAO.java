package com.ex.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashSet;

import com.ex.logging.Logger;
import com.ex.pojos.Account;
import com.ex.pojos.AccountType;
import com.ex.pojos.User;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleTypes;

/*
 * TODO add more logging to the methods in this class.
 * TODO figure out which methods need to have autoCommit disabled
 */

public class DbDAO implements DAO {
  
//  private Logger logger;
  private ConnectionFactory factory;
  
  public DbDAO(Logger logger) {
//    this.logger = logger;
    this.factory = ConnectionFactory.getInstance();
  }
  
  @Override
  public boolean addUser(String email, String passwordHash, String firstname, String lastname) {
    boolean success = false;
    int rowsAffected = 0;
    try (Connection conn = factory.getConnection();) {
      String sql = "insert into bankUser(email, passwordHash, firstname, lastname) "
          + "values (?, ?, ?, ?)";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      ps.setString(2, passwordHash);
      ps.setString(3, firstname);
      ps.setString(4, lastname);
      
      rowsAffected = ps.executeUpdate();
      success = rowsAffected == 1;
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
//    System.out.println("DbDAO: " + success);
    return success;
  }
  
  @Override
  public Integer addAccount(User u, AccountType type) {
    Integer accountId = null;
    try (Connection conn = factory.getConnection();) {
      conn.setAutoCommit(false);
      Savepoint save = conn.setSavepoint("before_add_account");
      // this could also be done as a callable statement
      String sql1 = "insert into account(typeid) values (?) returning id into ?";
      String sql2 = "insert into accountHolder(accountId, accountHolderId) values (?, ?)";
      OraclePreparedStatement ps1 = (OraclePreparedStatement) conn.prepareStatement(sql1);
      ps1.setInt(1, type.getId());
      ps1.registerReturnParameter(2, OracleTypes.NUMBER);
      
      if (ps1.executeUpdate() == 1) {
        ResultSet info = ps1.getReturnResultSet();
        if (info.next()) {
          PreparedStatement ps2 = conn.prepareStatement(sql2);
          ps2.setInt(1, info.getInt(1));
          ps2.setInt(2, u.getId());
          
          if (ps2.executeUpdate() == 1) {
            conn.commit();
            accountId = info.getInt(1);
          } else {
            conn.rollback(save);
          }
        }
      } else {
        conn.rollback(save);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return accountId;
  }

  @Override
  public boolean addAccountHolder(Account a, int accountHolderId) {
    boolean success = false;
    int rowsAffected = 0;
    try (Connection conn = factory.getConnection();) {
      String sql = "insert into accountHolder(accountId, accountHolderId) values (?, ?)";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, a.getId());
      ps.setInt(2, accountHolderId);
      
      rowsAffected = ps.executeUpdate();
      success = rowsAffected == 1;
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return success;
  }

  @Override
  public boolean addAccountHolder(Account a, String accountHolderEmail) {
    boolean success = false;
    int rowsAffected = 0;
    try (Connection conn = factory.getConnection();) {
      String sql = "insert into accountHolder(accountId, accountHolderId) values (?, "
          + "(select id from bankUser where email=?))";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, a.getId());
      ps.setString(2, accountHolderEmail);
      
      rowsAffected = ps.executeUpdate();
      success = rowsAffected == 1;
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return success;
  }

  @Override
  public HashSet<User> getAllUsers() {
    HashSet<User> users = new HashSet<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select id, email, firstname, lastname from bankUser";
      Statement statement = conn.createStatement();
      
      ResultSet info = statement.executeQuery(sql);
      while (info.next()) {
        users.add(new User(info.getInt(1), info.getString(2), info.getString(3), info.getString(4)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return users;
  }

  @Override
  public HashSet<Account> getAllAccounts() {
    HashSet<Account> accounts = new HashSet<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select a.id, a.balance, a.typeid, t.name, a.openDate, a.closeDate "
          + "from account a left outer join accoutType t where a.typeid=t.id";
      Statement statement = conn.createStatement();
      
      ResultSet info = statement.executeQuery(sql);
      while (info.next()) {
        accounts.add(new Account(info.getInt(1), info.getBigDecimal(2),
            new AccountType(info.getInt(3), info.getString(4)),
            info.getDate(5).toLocalDate(), (info.getDate(6) == null) ? null : info.getDate(6).toLocalDate()));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return accounts;
  }

  @Override
  public HashSet<AccountType> getAllAccountTypes() {
    HashSet<AccountType> types = new HashSet<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select id, name from accountType";
      Statement statement = conn.createStatement();
      
      ResultSet info = statement.executeQuery(sql);
      while (info.next()) {
        types.add(new AccountType(info.getInt(1), info.getString(2)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return types;
  }

  @Override
  public User getUser(int id) {
    User result = null;
    try (Connection conn = factory.getConnection();) {
      String sql = "select id, email, passwordHash, firstname, lastname "
          + "from bankUser where id=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, id);
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        result = new User(info.getInt(1), info.getString(2), info.getString(3), info.getString(4), info.getString(5));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return result;
  }
  
  @Override
  public User getUser(String email) {
    User result = null;
    try (Connection conn = factory.getConnection();) {
      String sql = "select id, email, passwordHash, firstname, lastname "
          + "from bankUser where email=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        result = new User(info.getInt(1), info.getString(2), info.getString(3), info.getString(4), info.getString(5));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public User getUser(String email, String passwordHash) {
    User result = null;
    try (Connection conn = factory.getConnection();) {
      String sql = "select id, email, passwordHash firstname, lastname "
          + "from bankUser where email=? and passwordHash=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      ps.setString(2, passwordHash);
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        result = new User(info.getInt(1), info.getString(2), info.getString(3), info.getString(4), info.getString(5));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return result;
  }
  
  @Override
  public String getUserPasswordHash(String email) {
    String result = null;
    try (Connection conn = factory.getConnection();) {
      String sql = "select passwordHash from bankUser where email=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        result = info.getString(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return result;
  }

  public Account getAccount(int id) {
    Account result = null;
    try (Connection conn = factory.getConnection();) {
      String sql = "select a.id, a.balance, a.typeid, t.name, a.openDate, a.closeDate "
          + "from account a, accountType t where a.id=? and a.typeid=t.id";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, id);
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        result = new Account(info.getInt(1), info.getBigDecimal(2),
            new AccountType(info.getInt(3), info.getString(4)),
            info.getDate(5).toLocalDate(), (info.getDate(6) == null) ? null : info.getDate(6).toLocalDate());
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return result;
  }
  
  @Override
  public HashSet<Account> getAccountsForUser(int id) {
    HashSet<Account> accounts = new HashSet<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select a.id, a.balance, a.typeid, t.name, a.openDate, a.closeDate "
          + "from accountholder h, account a, accoutType t "
          + "where h.accountholderid=? and h.accountid=a.id and a.typeid=t.id";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, id);

      ResultSet info = ps.executeQuery();
      while (info.next()) {
        accounts.add(new Account(info.getInt(1), info.getBigDecimal(2),
            new AccountType(info.getInt(3), info.getString(4)),
            info.getDate(5).toLocalDate(), (info.getDate(6) == null) ? null : info.getDate(6).toLocalDate()));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return accounts;
  }

  @Override
  public HashSet<Account> getAccountsForUser(String email) {
    HashSet<Account> accounts = new HashSet<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select a.id, a.balance, a.typeid, t.name, a.openDate, a.closeDate "
          + "from bankuser u, accountholder h, account a, accoutType t "
          + "where u.email=? and u.id=h.accountholderid and h.accountid=a.id and a.typeid=t.id";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);

      ResultSet info = ps.executeQuery();
      while (info.next()) {
        accounts.add(new Account(info.getInt(1), info.getBigDecimal(2),
            new AccountType(info.getInt(3), info.getString(4)),
            info.getDate(5).toLocalDate(), (info.getDate(6) == null) ? null : info.getDate(6).toLocalDate()));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return accounts;
  }

  @Override
  public HashSet<Account> getCurrentAccountsForUser(int id) {
    HashSet<Account> currentAccounts = new HashSet<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select a.id, a.balance, a.typeid, t.name, a.openDate, a.closeDate "
          + "from accountholder h, account a, accoutType t "
          + "where h.accountholderid=? and h.accountid=a.id and a.typeid=t.id "
          + "and (a.closeDate is null or a.closeDate > current_date) "
          + "and (h.unlinkDate is null or h.unlinkDate > current_date)";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, id);

      ResultSet info = ps.executeQuery();
      while (info.next()) {
        currentAccounts.add(new Account(info.getInt(1), info.getBigDecimal(2),
            new AccountType(info.getInt(3), info.getString(4)),
            info.getDate(5).toLocalDate(), (info.getDate(6) == null) ? null : info.getDate(6).toLocalDate()));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return currentAccounts;
  }

  @Override
  public HashSet<Account> getCurrentAccountsForUser(String email) {
    HashSet<Account> currentAccounts = new HashSet<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select a.id, a.balance, a.typeid, t.name, a.openDate, a.closeDate "
          + "from bankUser u, accountHolder h, account a, accountType t "
          + "where u.email=? and u.id=h.accountholderid and h.accountid=a.id and a.typeid=t.id "
          + "and (a.closeDate is null or a.closeDate > current_date) "
          + "and (h.unlinkDate is null or h.unlinkDate > current_date)";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);

      ResultSet info = ps.executeQuery();
      while (info.next()) {
        currentAccounts.add(new Account(info.getInt(1), info.getBigDecimal(2),
            new AccountType(info.getInt(3), info.getString(4)),
            info.getDate(5).toLocalDate(), (info.getDate(6) == null) ? null : info.getDate(6).toLocalDate()));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return currentAccounts;
  }

  @Override
  public HashSet<String> getAccountHolderEmails(Account a) {
    HashSet<String> accountHolders = new HashSet<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select u.email from accountHolder h, bankUser u "
          + "where h.accountid=? and h.accountholderid=u.id";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, a.getId());
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        accountHolders.add(info.getString(1));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return accountHolders;
  }

  @Override
  public HashSet<String> getCurrentAccountHolderEmails(Account a) {
    HashSet<String> accountHolders = new HashSet<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select u.email from accountHolder h, bankUser u "
          + "where h.accountid=? and h.accountholderid=u.id "
          + "and (h.unlinkDate is null or h.unlinkDate > current_date)";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, a.getId());
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        accountHolders.add(info.getString(1));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return accountHolders;
  }

 
  @Override
  public boolean updateUser(User old, String email, String passwordHash, String firstname, String lastname) {
    boolean success = false;
    int rowsAffected = 0;
    try (Connection conn = factory.getConnection();) {
      if (email == null) { email = old.getEmail(); }
      if (passwordHash == null) { passwordHash = old.getPasswordHash(); }
      if (firstname == null) { firstname = old.getFirstname(); }
      if (lastname == null) { lastname = old.getLastname(); }
      String sql = "update bankUser set email=?, passwordHash=?, firstname=?, lastname=? "
          + "where id=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      ps.setString(2, passwordHash);
      ps.setString(3, firstname);
      ps.setString(4, lastname);
      ps.setInt(5, old.getId());
      
      rowsAffected = ps.executeUpdate();
      success = rowsAffected == 1;
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return success;
  }

  @Override
  public boolean updateBalance(Account a, BigDecimal balance) {
    boolean success = false;
    int rowsAffected = 0;
    try (Connection conn = factory.getConnection();) {
      String sql = "update account set balance=? where id=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setBigDecimal(1, balance);
      ps.setInt(2, a.getId());
      
      rowsAffected = ps.executeUpdate();
      success = rowsAffected == 1;
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return success;
  }

  @Override
  public boolean performTransfer(int fromId, int toId, BigDecimal amount) {
    boolean success = false;
    try (Connection conn = factory.getConnection();) {
      String sql = "{? = call transfer_money(?, ?, ?)}";
      CallableStatement cs = conn.prepareCall(sql);
      cs.registerOutParameter(1, Types.BOOLEAN);
      cs.setInt(2, fromId);
      cs.setInt(3, toId);
      cs.setBigDecimal(4, amount);
      
      cs.execute();
      success = cs.getBoolean(1);
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return success;
  }

  @Override
  public boolean unlinkAccount(String email, Account a) {
    boolean success = false;
    int rowsAffected = 0;
    try (Connection conn = factory.getConnection();) {
      String sql = "update accountHolder set unlinkDate=current_date "
          + "where accountholderid=(select id from bankUser where email=?) and accountid=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      ps.setInt(2, a.getId());
      
      rowsAffected = ps.executeUpdate();
      success = rowsAffected == 1;
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return success;
  }

  @Override
  public boolean closeAccount(Account a) {
    boolean success = false;
    int rowsAffected = 0;
    try (Connection conn = factory.getConnection();) {
      String sql = "update account set closeDate=current_date where id=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, a.getId());
      
      rowsAffected = ps.executeUpdate();
      success = rowsAffected == 1;
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return success;
  }

  @Override
  public boolean checkPasswordHash(String email, String passwordHash) {
    boolean isCorrect = false;
    try (Connection conn = factory.getConnection();) {
      String sql = "{? = check_password_hash(?, ?)}";
      CallableStatement cs = conn.prepareCall(sql);
      cs.registerOutParameter(1, Types.BOOLEAN);
      cs.setString(2, email);
      cs.setString(3, passwordHash);
      
      cs.execute();
      isCorrect = cs.getBoolean(1);
    } catch (SQLException e) {
      e.printStackTrace();
      e.printStackTrace();
    }
    return isCorrect;
  }

}
