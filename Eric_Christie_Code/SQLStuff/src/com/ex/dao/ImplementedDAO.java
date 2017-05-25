package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.ex.pojos.Customer;
import com.ex.pojos.Order;
import com.ex.util.ConnectionUtil;

public class ImplementedDAO {

  /**
   * STATEMENT to update adds order to demo_order table
   * 
   * @param customerId
   *          ID of customer that placed the order
   * @param total
   *          total cost of the order
   */
  public void addOrder(int customerId, /* BigDecimal */double total) {
    try (Connection connection = ConnectionUtil.getConnection();) {
      // this connection has the ability to auto-commit
      // connection.setAutoCommit(false);

      // only use a Statement object if you are not taking in any input

      // don't ever do this in a real project unless you want Russian hackers to
      // do sql injection on your database
      String sql = "insert into demo_order(customer_id, order_total) " + "values (" + customerId + ", " + total + ")";
      Statement statement = connection.createStatement();
      int numRowsAffected = statement.executeUpdate(sql);
      System.out.println("Number of rows affected: " + numRowsAffected);
      // connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * PREPARED STATEMENT used to update adds a new customer
   * 
   * @param fName
   * @param lName
   * @param state
   * @param credit
   * @param email
   */
  public void addCustomer(String fName, String lName, String state, double credit, String email) {
    try (Connection connection = ConnectionUtil.getConnection();) {
      String sql = "insert into demo_customer"
          + "(cust_first_name, cust_last_name, cust_state, credit_limit, cust_email) " + "values (?, ?, ?, ?, ?)";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, fName);
      ps.setString(2, lName);
      ps.setString(3, state);
      ps.setDouble(4, credit);
      ps.setString(5, email);

      int numRowsAffected = ps.executeUpdate();
      System.out.println("Number of rows affected: " + numRowsAffected);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * PREPARED STATEMENT to execute query
   * 
   * @param id
   *          ID of the customer to get
   * @return all the infos for the desired customer
   */
  public Customer getCustomer(int id) {
    try (Connection connection = ConnectionUtil.getConnection();) {
      Customer result = null;
      String sql = "select customer_id, cust_first_name, cust_last_name, cust_state, "
          + "credit_limit, cust_email from demo_customer where customer_id=?";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, id);

      ResultSet info = ps.executeQuery();
      // the order and names of the fields can also be determined by specifying
      // the columns
      // in the select statement and giving them aliases
      while (info.next()) { // must call .next() before trying to access result
                            // fields
        result = new Customer(info.getInt(1), info.getString(2), info.getString(3),
            info.getString(4), info.getDouble(5), info.getString(6));
      }
      return result;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public ArrayList<Customer> getAllCustomers() {
    ArrayList<Customer> customers = new ArrayList<>();
    try (Connection connection = ConnectionUtil.getConnection();) {
      String sql = "select * from demo_customer";
      PreparedStatement ps = connection.prepareStatement(sql);

      ResultSet info = ps.executeQuery();

      while (info.next()) {
        customers.add(new Customer(info.getInt(1), info.getString(2), info.getString(3), info.getString(4),
            info.getDouble(5), info.getString(6)));
      }
      return customers;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * CALLABLE STATEMENT
   */
  public void createOrder(Customer c, double total) {
    int c_id = c.getId();
    try (Connection connection = ConnectionUtil.getConnection();) {
      String addOrder = "{call create_order(?, ?)}";

      CallableStatement cs = connection.prepareCall(addOrder);
      cs.setInt(1, c_id);
      cs.setDouble(2, total);

      int num = cs.executeUpdate();
      System.out.println(num + " rows inserted");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Order> getOrdersByCustomer(Customer c) {
    ArrayList<Order> orders = new ArrayList<>();
    try (Connection connection = ConnectionUtil.getConnection();) {
      String sql = "select order_id as oid, order_total as total, order_timestamp as ts "
          + "from demo_order where customer_id=?";

      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, c.getId());

      ResultSet info = ps.executeQuery();
      while (info.next()) {
        orders.add(new Order(info.getInt("oid"), info.getDate("ts"), info.getDouble("total"), c));
      }
      return orders;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
  
  /**
   * specify which fields to set to NULL for a specific customer
   * @param id The id of the customer being updated
   * @param nullState Whether or not cust_state should be set to NULL
   * @param nullEmail Whether or not cust_email should be set to NULL
   * @param nullCredit Whether or not credit_limit should be set to NULL
   * @return true if successful, false otherwise
   */
  public boolean updateToNull(int id, boolean nullState, boolean nullEmail, boolean nullCredit) {
    Customer old = getCustomer(id);
    try (Connection connection = ConnectionUtil.getConnection();) {
      String sql = "update demo_customer set "
          + "cust_state=?, cust_email=?, credit_limit=? "
          + "where customer_id=?";

      PreparedStatement ps = connection.prepareStatement(sql);
      if (nullState) {
        ps.setNull(1, Types.VARCHAR);
      } else {
        ps.setString(1, old.getState());
      }
      if (nullEmail) {
        ps.setNull(2, Types.VARCHAR);
      } else {
        ps.setString(2, old.getEmail());
      }
      if (nullCredit) {
        ps.setNull(3, Types.NUMERIC);
      } else {
        ps.setDouble(3, old.getCredit());
      }
      ps.setInt(4, old.getId());

      int num = ps.executeUpdate();
      System.out.println(num);
      if (num > 0) {
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
  
  /**
   * update the fields for a specific customer
   * Input null for the new value of a field to keep the current value.
   * Use updateToNull() to set the state, email, or credit limit to null in the database.
   * @param id ID of the customer to be updated
   * @param fName Customer's new first name
   * @param lName Customer's new last name
   * @param state Customer's new state
   * @param email Customer's new email
   * @param credit Customer's new credit limit
   * @return true if successful false otherwise
   */
  public boolean updateCustomer(int id, String newFirstname, String newLastname,
      String newState, String newEmail, Double newCredit) {
    Customer old = getCustomer(id);
//    newFirstname = (newFirstname != null) ? newFirstname : old.getFirstname();
//    newLastname = (newLastname != null) ? newLastname : old.getLastname();
//    newState = (newState != null) ? newState : old.getState();
//    newEmail = (newEmail != null) ? newEmail : old.getEmail();
//    newCredit = (newCredit != null) ? newCredit : old.getCredit();
    
    Customer updated = new Customer(newFirstname, newLastname, newState, newEmail, newCredit);
    return updateCustomer(old, updated);
  }
  
  /**
   * PREPARED STATEMENT
   * only the first name, last name, state, email, and credit from newCustomer will 
   * actually be used in the update statement
   * @param oldCustomer The customer being updated
   * @param newCustomer The desired result of the update
   * @return true if successful, false otherwise
   */
  private boolean updateCustomer(Customer oldCustomer, Customer newCustomer) {
    try (Connection connection = ConnectionUtil.getConnection();) {
      String sql = "update demo_customer set "
          + "cust_first_name=?, cust_last_name=?, cust_state=?, cust_email=?, credit_limit=? "
          + "where customer_id=?";

      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, newCustomer.getFirstname());
      ps.setString(2, newCustomer.getLastname());
      ps.setString(3, newCustomer.getState());
      ps.setString(4, newCustomer.getEmail());
      ps.setDouble(5, newCustomer.getCredit());
      ps.setInt(6, oldCustomer.getId());

      int num = ps.executeUpdate();
      System.out.println(num);
      if (num > 0) {
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
}
