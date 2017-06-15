package com.revature.ers.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.ers.pojos.User;
import com.revature.ers.pojos.Request;
import com.revature.ers.pojos.RequestState;
import com.revature.ers.util.ConnectionFactory;
import com.revature.ers.util.PasswordStorage;
import com.revature.ers.util.PasswordStorage.CannotPerformOperationException;
import com.revature.ers.util.PasswordStorage.InvalidHashException;
import com.revature.ers.util.TempLogger;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleTypes;

public class DbDAO implements DAO {
  
  private ConnectionFactory factory = ConnectionFactory.getInstance();
  private TempLogger logger = new TempLogger();

  @Override
  public boolean addUser(String email, String firstname, String lastname, boolean isManager) {
    boolean success = false;
    try (Connection conn = factory.getConnection();) {
      conn.setAutoCommit(false);
      Savepoint save = conn.setSavepoint();
      String sql = "insert into employee (email,  passwordHash, firstname, lastname, isManager) "
          + "values (?, ?, ?, ?, ?)";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      ps.setString(2, PasswordStorage.createHash(email));
      ps.setString(3, firstname);
      ps.setString(4, lastname);
      ps.setInt(5, isManager ? 1 : 0);
      
      int rowCount = ps.executeUpdate();
      if (rowCount == 1) {
        success = true;
        conn.commit();
      } else {
        conn.rollback(save);
      }
    } catch (SQLException | CannotPerformOperationException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return success;
  }

  @Override
  public Integer addRequest(User requester, BigDecimal amount, String purpose) {
    Integer result = null;
    if (requester.isSetupDone()) {
      try (Connection conn = factory.getConnection();) {
        conn.setAutoCommit(false);
        Savepoint save = conn.setSavepoint();
        String sql = "insert into request (requesterId, amount, purpose) values (?, ?, ?) returning id into ?";
        OraclePreparedStatement ops = (OraclePreparedStatement) conn.prepareStatement(sql);
        ops.setInt(1, requester.getId());
        ops.setBigDecimal(2, amount);
        ops.setString(3, purpose);
        ops.registerReturnParameter(4, OracleTypes.NUMBER);
        
        int rowCount = ops.executeUpdate();
        if (rowCount == 1) {
          ResultSet info = ops.getReturnResultSet();
          if (info.next()) {
            result = info.getInt(1);
            conn.commit();
          } else {
            conn.rollback(save);
          }
        } else {
          conn.rollback(save);
        }
      } catch (SQLException ex) {
        logger.catching(ex);
        ex.printStackTrace();
      }
    }
    return result;
  }

  @Override
  public boolean checkPassword(String email, String password) {
    boolean correct = false;
    try (Connection conn = factory.getConnection();) {
      String sql = "select passwordHash from employee where email=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        correct = PasswordStorage.verifyPassword(password, info.getString(1));
      }
    } catch (SQLException | CannotPerformOperationException | InvalidHashException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return correct;
  }

  @Override
  public ArrayList<User> getAllUsers() {
    ArrayList<User> users = new ArrayList<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select id, email, firstname, lastname, isManager, emailAlertsOn, setupDone, latestLogout from employee";
      Statement statement = conn.createStatement();
      
      ResultSet info = statement.executeQuery(sql);
      while (info.next()) {
        users.add(new User(info.getInt(1), info.getString(2), info.getString(3), info.getString(4),
            info.getInt(5)==1, info.getInt(6)==1, info.getInt(7)==1,
            info.getTimestamp(8)==null ? null : info.getTimestamp(8).toLocalDateTime()));
      }
    } catch (SQLException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return users;
  }
  
  

  @Override
  public ArrayList<User> getAllEmployees() {
    ArrayList<User> employees = new ArrayList<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select id, email, firstname, lastname, isManager, emailAlertsOn, setupDone, latestLogout "
          + "from employee where isManager=0";
      Statement statement = conn.createStatement();
      
      ResultSet info = statement.executeQuery(sql);
      while (info.next()) {
        employees.add(new User(info.getInt(1), info.getString(2), info.getString(3), info.getString(4),
            info.getInt(5)==1, info.getInt(6)==1, info.getInt(7)==1,
            info.getTimestamp(8)==null ? null : info.getTimestamp(8).toLocalDateTime()));
      }
    } catch (SQLException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return employees;
  }

  @Override
  public ArrayList<User> getAllManagers() {
    ArrayList<User> managers = new ArrayList<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select id, email, firstname, lastname, isManager, emailAlertsOn, setupDone, latestLogout "
          + "from employee where isManager=1";
      Statement statement = conn.createStatement();
      
      ResultSet info = statement.executeQuery(sql);
      while (info.next()) {
        managers.add(new User(info.getInt(1), info.getString(2), info.getString(3), info.getString(4),
            info.getInt(5)==1, info.getInt(6)==1, info.getInt(7)==1,
            info.getTimestamp(8)==null ? null : info.getTimestamp(8).toLocalDateTime()));
      }
    } catch (SQLException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return managers;
  }

  @Override
  public ArrayList<Request> getAllRequests() {
    ArrayList<Request> requests = new ArrayList<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select rq.id, rs.id, rs.name, rq.amount, e.email, m.email, rq.requestedTimestamp, rq.resolvedTimestamp, "
          + "rq.purpose, rq.note from request rq, requestState rs, employee e, employee m "
          + "where rq.requesterId=e.id and rq.resolverId=m.id and rq.stateId=rs.id";
      Statement statement = conn.createStatement();
      
      ResultSet info = statement.executeQuery(sql);
      while (info.next()) {
        requests.add(new Request(info.getInt(1), new RequestState(info.getInt(2), info.getString(3)), info.getBigDecimal(4), 
            info.getString(5), info.getString(6), info.getTimestamp(7).toLocalDateTime(), info.getTimestamp(8).toLocalDateTime(), 
            info.getString(9), info.getString(10)));
      }
    } catch (SQLException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return requests;
  }

  @Override
  public ArrayList<RequestState> getAllRequestStates() {
    ArrayList<RequestState> states = new ArrayList<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select id, name from requestState order by id";
      Statement statement = conn.createStatement();
      
      ResultSet info = statement.executeQuery(sql);
      while (info.next()) {
        states.add(new RequestState(info.getInt(1), info.getString(2)));
      }
    } catch (SQLException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return states;
  }

  @Override
  public User getUser(int id) {
    User result = null;
    try (Connection conn = factory.getConnection();) {
      String sql = "select id, email, firstname, lastname, isManager, emailAlertsOn, setupDone, latestLogout "
          + "from employee where id=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, id);
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        result = new User(info.getInt(1), info.getString(2), info.getString(3), info.getString(4),
            info.getInt(5)==1, info.getInt(6)==1, info.getInt(7)==1,
            info.getTimestamp(8)==null ? null : info.getTimestamp(8).toLocalDateTime());
      }
    } catch (SQLException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return result;
  }

  @Override
  public User getUser(String email) {
    User result = null;
    try (Connection conn = factory.getConnection();) {
      String sql = "select id, email, firstname, lastname, isManager, emailAlertsOn, setupDone, latestLogout "
          + "from employee where email=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        result = new User(info.getInt(1), info.getString(2), info.getString(3), info.getString(4),
            info.getInt(5)==1, info.getInt(6)==1, info.getInt(7)==1,
            info.getTimestamp(8)==null ? null : info.getTimestamp(8).toLocalDateTime());
      }
    } catch (SQLException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return result;
  }

  @Override
  public Request getRequest(int id) {
    Request result = null;
    try (Connection conn = factory.getConnection();) {
      String sql = "select rq.id, rs.id, rs.name, rq.amount, e.email, e.firstname, e.lastname, "
          + "m.email, m.firstname, m.lastname, rq.requestedTimestamp, rq.resolvedTimestamp, "
          + "rq.purpose, rq.note from request rq, requestState rs, employee e, employee m "
          + "where rq.id=? and rq.requesterId=e.id and rq.resolverId=m.id and rq.stateId=rs.id";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, id);
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        result = new Request(info.getInt(1), new RequestState(info.getInt(2), info.getString(3)), info.getBigDecimal(4), 
            info.getString(5), info.getString(6), info.getTimestamp(7).toLocalDateTime(), info.getTimestamp(8).toLocalDateTime(), 
            info.getString(9), info.getString(10));
      }
    } catch (SQLException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return result;
  }

  @Override
  public ArrayList<Request> getRequestsByRequester(String email) {
    ArrayList<Request> requests = new ArrayList<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select rq.id, rs.id, rs.name, rq.amount, e.email, e.firstname, e.lastname, "
          + "m.email, m.firstname, m.lastname, rq.requestedTimestamp, rq.resolvedTimestamp, "
          + "rq.purpose, rq.note from request rq, requestState rs, employee e, employee m "
          + "where e.email=? and rq.requesterId=e.id and rq.resolverId=m.id and rq.stateId=rs.id";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        requests.add(new Request(info.getInt(1), new RequestState(info.getInt(2), info.getString(3)), info.getBigDecimal(4), 
            info.getString(5), info.getString(6), info.getTimestamp(7).toLocalDateTime(), info.getTimestamp(8).toLocalDateTime(), 
            info.getString(9), info.getString(10)));
      }
    } catch (SQLException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return requests;
  }

  @Override
  public ArrayList<Request> getRequestsByResolver(String email) {
    ArrayList<Request> requests = new ArrayList<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select rq.id, rs.id, rs.name, rq.amount, e.email, e.firstname, e.lastname, "
          + "m.email, m.firstname, m.lastname, rq.requestedTimestamp, rq.resolvedTimestamp, "
          + "rq.purpose, rq.note from request rq, requestState rs, employee e, employee m "
          + "where m.email=? and rq.resolverId=m.id and rq.requesterId=e.id and rq.stateId=rs.id";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        requests.add(new Request(info.getInt(1), new RequestState(info.getInt(2), info.getString(3)), info.getBigDecimal(4), 
            info.getString(5), info.getString(6), info.getTimestamp(7).toLocalDateTime(), info.getTimestamp(8).toLocalDateTime(), 
            info.getString(9), info.getString(10)));
      }
    } catch (SQLException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return requests;
  }

  @Override
  public ArrayList<Request> getRequestsByState(RequestState state) {
    ArrayList<Request> requests = new ArrayList<>();
    try (Connection conn = factory.getConnection();) {
      String sql = "select rq.id, rs.id, rs.name, rq.amount, e.email, e.firstname, e.lastname, "
          + "m.email, m.firstname, m.lastname, rq.requestedTimestamp, rq.resolvedTimestamp, "
          + "rq.purpose, rq.note from request rq, requestState rs, employee e, employee m "
          + "where rs.id=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, state.getId());
      
      ResultSet info = ps.executeQuery();
      while (info.next()) {
        requests.add(new Request(info.getInt(1), new RequestState(info.getInt(2), info.getString(3)), info.getBigDecimal(4), 
            info.getString(5), info.getString(6), info.getTimestamp(7).toLocalDateTime(), info.getTimestamp(8).toLocalDateTime(), 
            info.getString(9), info.getString(10)));
      }
    } catch (SQLException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return requests;
  }
  
  @Override
  public boolean promoteEmployee(User e) {
    boolean success = false;
    if (!e.isManager()) {
      try (Connection conn = factory.getConnection();) {
        conn.setAutoCommit(false);
        Savepoint save = conn.setSavepoint();
        String sql = "update employee set isManager=1 where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, e.getId());
        
        int rowCount = ps.executeUpdate();
        if (rowCount == 1) {
          success = true;
          conn.commit();
        } else {
          conn.rollback(save);
        }
      } catch (SQLException ex) {
        logger.catching(ex);
        ex.printStackTrace();
      }
    }
    return success;
  }
  
  @Override
  public boolean updateUser(User old, String email, String firstname, String lastname, boolean emailAlertsOn) {
    boolean success = false;
    try (Connection conn = factory.getConnection();) {
      conn.setAutoCommit(false);
      Savepoint save = conn.setSavepoint();
      String sql = "update employee set email=?, firstname=?, lastname=?, emailAlertsOn=? where id=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, email);
      ps.setString(2, firstname);
      ps.setString(3, lastname);
      ps.setInt(4, emailAlertsOn ? 1 : 0);
      ps.setInt(5, old.getId());

      int rowCount = ps.executeUpdate();
      if (rowCount == 1) {
        success = true;
        conn.commit();
      } else {
        conn.rollback(save);
      }
    } catch (SQLException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return success;
  }

  @Override
  public boolean updateUserLatestLogout(User e) {
    boolean success = false;
    try (Connection conn = factory.getConnection();) {
      conn.setAutoCommit(false);
      Savepoint save = conn.setSavepoint();
      String sql = "update employee set latestLogout=localtimestamp where id=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, e.getId());
      
      int rowCount = ps.executeUpdate();
      if (rowCount == 1) {
        success = true;
        conn.commit();
      } else {
        conn.rollback(save);
      }
    } catch (SQLException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return success;
  }

  @Override
  public boolean updateUserPassword(User e, String password) {
    boolean success = false;
    try (Connection conn = factory.getConnection();) {
      conn.setAutoCommit(false);
      Savepoint save = conn.setSavepoint();
      String sql = "update employee set passwordHash=?, setupDone=1 where id=?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, PasswordStorage.createHash(password));
      ps.setInt(2, e.getId());
      
      int rowCount = ps.executeUpdate();
      if (rowCount == 1) {
        success = true;
        conn.commit();
      } else {
        conn.rollback(save);
      }
    } catch (SQLException | CannotPerformOperationException ex) {
      logger.catching(ex);
      ex.printStackTrace();
    }
    return success;
  }

  @Override
  public boolean updateRequest(Request r, User resolver, RequestState state, String note) {
    boolean success = false;
    if (resolver.isSetupDone()) {
      if (state.getName().equalsIgnoreCase("approved") || state.getName().equalsIgnoreCase("denied")) {
        try (Connection conn = factory.getConnection();) {
          conn.setAutoCommit(false);
          Savepoint save = conn.setSavepoint();
          String sql = "update request set resolverId=?, stateId=?, note=? where id=?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, resolver.getId());
          ps.setInt(2, state.getId());
          ps.setString(3, note);
          ps.setInt(4, r.getId());
          
          int rowCount = ps.executeUpdate();
          if (rowCount == 1) {
            success = true;
            conn.commit();
          } else {
            conn.rollback(save);
          }
        } catch (SQLException ex) {
          logger.catching(ex);
          ex.printStackTrace();
        }
      }
    }
    return success;
  }

}
