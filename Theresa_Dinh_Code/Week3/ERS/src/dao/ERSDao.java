package dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import ersUtil.ConnectionFactory;
import pojos.Employee;
import pojos.Request; 

public class ERSDao 
{
	public ERSDao()
	{
		super(); 
	}
	
	// register a new Employee into the database 
	// Paramters: Employee that has at least its first and last names, email, 
	// and password set 
	public Employee registerEmployee(Employee employee)
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			c.setAutoCommit(false);
			
			// email, password, id, firstname, lastname, manager
			String s = "INSERT INTO EMPLOYEE (EMAIL, PASSWORD, FIRSTNAME, LASTNAME)"
					+ "VALUES (?, ?, ?, ?)"; 
			PreparedStatement ps = c.prepareStatement(s); 
			
			ps.setString(1, employee.getEmail());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getFirstName());
			ps.setString(4, employee.getLastName());
			
			int rowCheck = ps.executeUpdate();
			if(rowCheck != 1)
			{
				System.out.println("Row Update Failure");
				throw new SQLException(); 
			}
			
			c.commit();
			ps.close();
			c.setAutoCommit(true);
			c.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null; 
	}
	
    // update an Employee's data in the db 
    // parameter: an Employee with the new names and emails set 
    public boolean updateEmployee(Employee employee)
    {
        try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			c.setAutoCommit(false);
			
			String s = "UPDATE EMPLOYEE SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ? WHERE ID = ?";
			PreparedStatement ps = c.prepareStatement(s); 
			ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName()); 
            ps.setString(3, employee.getEmail()); 
            ps.setInt(4, employee.getId());
			
			int rowCheck = ps.executeUpdate();		// safety check for later 
			if(rowCheck != 1)
			{
				System.out.println("Row Update Failure");
				return false; 
			}
			
			c.commit();
			ps.close();
			c.setAutoCommit(true);	
			c.close();
			return true; 
		}
		catch(SQLException e)
		{
			e.printStackTrace(); 
		}
        return false; 
    }
    
	// allow a manager to set another Employee as manager 
	// or to demote an Employee from manager
	// Parameters: the email of the Employee to be promoted/demoted 
	// and a boolean TRUE if manager, FALSE if not manager 
	public boolean setManager(Employee employee, boolean isManager)
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			c.setAutoCommit(false);
			
			String s = "UPDATE EMPLOYEE SET ISMANAGER = ? WHERE EMAIL = ?";
			PreparedStatement ps = c.prepareStatement(s); 
			ps.setString(2, employee.getEmail());
			
			if(isManager)			// promote to manager in db 
				ps.setInt(1, 1);
			else					// demote from manager in db 
				ps.setInt(1, 0);
			
			int rowCheck = ps.executeUpdate();		// safety check for later 
			if(rowCheck != 1)
			{
				System.out.println("Row Update Failure");
				return false;
			}
			
			c.commit();
			ps.close();
			c.setAutoCommit(true);	
			c.close();
			return true; 
		}
		catch(SQLException e)
		{
			e.printStackTrace(); 
		}
		return false; 
	}
	
	// retrieves an Employee's information from the database and
	// returns it as an Employee object 
	// Parameter: Employee that has at least its email set 
	public Employee getEmployee(Employee employee) 
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			String s = "SELECT * FROM EMPLOYEE WHERE EMAIL = ?"; 
			PreparedStatement ps = c.prepareStatement(s);
			
			ps.setString(1, employee.getEmail());
			
			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				// email, password, firstname, lastname, ismanager 
				Employee temp = new Employee(); 
				temp.setEmail(rs.getString(1));
				temp.setPassword(rs.getString(2));
				temp.setId(rs.getInt(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setManagerId(rs.getInt(6));
			
				return temp; 
			}
			c.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		return null;
	}
	
	// retrieves an Employee's information from the database and
	// returns it as an Employee object 
	// Parameter: Employee's email 
	public Employee getEmployee(String email) 
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			String s = "SELECT * FROM EMPLOYEE WHERE EMAIL = ?"; 
			PreparedStatement ps = c.prepareStatement(s);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				// email, password, id, firstname, lastname, ismanager 
				Employee temp = new Employee(); 
				temp.setEmail(rs.getString(1));
				temp.setPassword(rs.getString(2));
				temp.setId(rs.getInt(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setManagerId(rs.getInt(6));
			
				return temp; 
			}
			c.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		return null;
	}
    
	public Employee getEmployee(int id)
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			String s = "SELECT * FROM EMPLOYEE WHERE ID = ?"; 
			PreparedStatement ps = c.prepareStatement(s);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				// email, password, id, firstname, lastname, ismanager 
				Employee temp = new Employee(); 
				temp.setEmail(rs.getString(1));
				temp.setPassword(rs.getString(2));
				temp.setId(rs.getInt(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setManagerId(rs.getInt(6));
				return temp; 
			}
			c.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		return null;
	}
	
	// returns an ArrayList of all Employees
	public ArrayList<Employee> getAllEmployees()
	{
		ArrayList<Employee> employees = new ArrayList<Employee>(); 
        
        try(Connection c = ConnectionFactory.getInstance().getConnection();)
        {
            String s = "SELECT * FROM EMPLOYEE"; 
            PreparedStatement ps = c.prepareStatement(s); 

            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
				Employee temp = new Employee(); 
				temp.setEmail(rs.getString(1));
				temp.setPassword(rs.getString(2));
				temp.setId(rs.getInt(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setManagerId(rs.getInt(6));
                employees.add(temp); 
            }
            c.close(); 
        }
        catch(SQLException e)
        {
            e.printStackTrace(); 
        }
        return employees; 
	}
	
	// returns an ArrayList of all Employees that are Managers
	public ArrayList<Employee> getAllManagers()
	{
		ArrayList<Employee> employees = new ArrayList<Employee>(); 
        
        try(Connection c = ConnectionFactory.getInstance().getConnection();)
        {
            String s = "SELECT * FROM EMPLOYEE WHERE ISMANAGER = 1"; 
            PreparedStatement ps = c.prepareStatement(s); 

            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
				Employee temp = new Employee(); 
				temp.setEmail(rs.getString(1));
				temp.setPassword(rs.getString(2));
				temp.setId(rs.getInt(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setManagerId(rs.getInt(6));
                employees.add(temp); 
            }
            c.close(); 
        }
        catch(SQLException e)
        {
            e.printStackTrace(); 
        }
        return employees; 
	}
	
    // returns an ArrayList of all Requests ever submitted by the Employee
    // takes the Employee's username/email to find all their requests in db 
    public ArrayList<Request> getRequests(String email)
    {
        ArrayList<Request> requests = new ArrayList<Request>(); 
        Employee employee = getEmployee(email); 
        
        try(Connection c = ConnectionFactory.getInstance().getConnection();)
        {
            String s = "SELECT * FROM REQUEST WHERE REQUESTERID = ?"; 
            PreparedStatement ps = c.prepareStatement(s); 
            ps.setInt(1, employee.getId()); 
            
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                Request temp = new Request(); 
                temp.setStatusId(rs.getInt(1)); 
                temp.setRequestDate(rs.getTimestamp(2));
                temp.setResolveDate(rs.getTimestamp(3));
                temp.setAmount(rs.getDouble(4));
                temp.setPurpose(rs.getString(5));
                temp.setRequestId(rs.getInt(6));
                temp.setRequesterId(rs.getInt(7));
                temp.setApproverId(rs.getInt(8));
                requests.add(temp); 
            }
            c.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace(); 
        }
        return requests; 
    }
    
	
	public ArrayList<Request> getAllRequests()
	{
		ArrayList<Request> requests = new ArrayList<Request>(); 

    	try(Connection c = ConnectionFactory.getInstance().getConnection();)
        {
            String s = "SELECT * FROM REQUEST"; 
            PreparedStatement ps = c.prepareStatement(s); 
            
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                Request temp = new Request(); 
                temp.setStatusId(rs.getInt(1)); 
                temp.setRequestDate(rs.getTimestamp(2));
                temp.setResolveDate(rs.getTimestamp(3));
                temp.setAmount(rs.getDouble(4));
                temp.setPurpose(rs.getString(5));
                temp.setRequestId(rs.getInt(6));
                temp.setRequesterId(rs.getInt(7));
                temp.setApproverId(rs.getInt(8));
                requests.add(temp); 
            }
            c.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace(); 
        }
        return requests; 
	}
    
    public ArrayList<Request> getApprovedRequests()
    {
    	ArrayList<Request> requests = new ArrayList<Request>(); 

    	try(Connection c = ConnectionFactory.getInstance().getConnection();)
        {
            String s = "SELECT * FROM REQUEST WHERE STATUSID = 1"; 
            PreparedStatement ps = c.prepareStatement(s); 
            
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                Request temp = new Request(); 
                temp.setStatusId(rs.getInt(1)); 
                temp.setRequestDate(rs.getTimestamp(2));
                temp.setResolveDate(rs.getTimestamp(3));
                temp.setAmount(rs.getDouble(4));
                temp.setPurpose(rs.getString(5));
                temp.setRequestId(rs.getInt(6));
                temp.setRequesterId(rs.getInt(7));
                temp.setApproverId(rs.getInt(8));
                requests.add(temp); 
            }
            c.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace(); 
        }
        return requests; 
    }
	
    public ArrayList<Request> getDeniedRequests()
    {
    	ArrayList<Request> requests = new ArrayList<Request>(); 

    	try(Connection c = ConnectionFactory.getInstance().getConnection();)
        {
            String s = "SELECT * FROM REQUEST WHERE STATUSID = 2"; 
            PreparedStatement ps = c.prepareStatement(s); 
            
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                Request temp = new Request(); 
                temp.setStatusId(rs.getInt(1)); 
                temp.setRequestDate(rs.getTimestamp(2));
                temp.setResolveDate(rs.getTimestamp(3));
                temp.setAmount(rs.getDouble(4));
                temp.setPurpose(rs.getString(5));
                temp.setRequestId(rs.getInt(6));
                temp.setRequesterId(rs.getInt(7));
                temp.setApproverId(rs.getInt(8));
                requests.add(temp); 
            }
            c.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace(); 
        }
        return requests;     	
    }
    
    // returns an ArrayList of all requests that are still pending 
    // Parameter: none 
    public ArrayList<Request> getPendingRequests()
    {
        ArrayList<Request> requests = new ArrayList<Request>(); 
        
        try(Connection c = ConnectionFactory.getInstance().getConnection();)
        {
            String s = "SELECT * FROM REQUEST WHERE STATUSID = 0"; 
            PreparedStatement ps = c.prepareStatement(s); 
            
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                Request temp = new Request(); 
                temp.setStatusId(rs.getInt(1)); 
                temp.setRequestDate(rs.getTimestamp(2));
                temp.setResolveDate(rs.getTimestamp(3));
                temp.setAmount(rs.getDouble(4));
                temp.setPurpose(rs.getString(5));
                temp.setRequestId(rs.getInt(6));
                temp.setRequesterId(rs.getInt(7));
                temp.setApproverId(rs.getInt(8));
                requests.add(temp); 
            }
            c.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace(); 
        }
        return requests; 
    }
    
    // Retrieve info about one specific Request 
    // Parameter : a Request that has at least its RequestID set 
    public Request getRequest(Request request)
    {    	
    	try(Connection c = ConnectionFactory.getInstance().getConnection();)
        {	
            String s = "SELECT * FROM REQUEST WHERE REQUESTID = ?"; 
            PreparedStatement ps = c.prepareStatement(s); 
            ps.setInt(1, request.getRequestId());
            
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
            	Request	temp = new Request(); 
                temp.setStatusId(rs.getInt(1)); 
                temp.setRequestDate(rs.getTimestamp(2));
                temp.setResolveDate(rs.getTimestamp(3));
                temp.setAmount(rs.getDouble(4));
                temp.setPurpose(rs.getString(5));
                temp.setRequestId(rs.getInt(6));
                temp.setRequesterId(rs.getInt(7));
                temp.setApproverId(rs.getInt(8));
                return temp; 
            }
            c.close();
        }
        catch(SQLException e)
        {
        	System.out.println("exception caught");
            e.printStackTrace(); 
        }
        return null; 
    }
    
    //may return boolean later 
    // approves a Request by setting its status ID to 1 in the database 
    // may not need to update resolve date, have db trigger do it 
	// Parameters: Request that has its Request ID and the ID of the approving Manager set 
    public boolean approveRequest(Request request)
    {
    	try(Connection c = ConnectionFactory.getInstance().getConnection();)
    	{
    		c.setAutoCommit(false);
    		
	    	String s = "UPDATE REQUEST SET STATUSID = 1, APPROVERID = ? "
	    			+ "WHERE REQUESTID = ?"; 
	    	PreparedStatement ps = c.prepareStatement(s); 
	    	
	    	ps.setInt(1, request.getApproverId());
	    	ps.setInt(2, request.getRequestId());
	    	
	    	int rowCheck = ps.executeUpdate();  
			if(rowCheck != 1)
			{
				System.out.println("Row Update Failure");
				return false; 
			}
			
	    	c.commit();
	    	ps.close();
	    	c.setAutoCommit(true);
	    	c.close();
	    	return true; 
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return false; 
    }
    
    // denies a Request by settings its status ID to 2 in the database
	// Parameters: Request that has its Request ID and the ID of the denying Manager set 

    public boolean denyRequest(Request request)
    {
    	try(Connection c = ConnectionFactory.getInstance().getConnection();)
    	{
    		c.setAutoCommit(false);
    		
	    	String s = "UPDATE REQUEST SET STATUSID = 2, APPROVERID = ? "
	    			+ "WHERE REQUESTID = ?"; 
	    	PreparedStatement ps = c.prepareStatement(s); 
	    	
			ps.setInt(1, request.getApproverId());
	    	ps.setInt(2, request.getRequestId());
	    	
	    	int rowCheck = ps.executeUpdate(); 
			if(rowCheck != 1)
			{
				System.out.println("Row Update Failure");
				return false; 
			}
	    	c.commit();
	    	ps.close();
	    	c.setAutoCommit(true);
	    	c.close();
	    	return true; 
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return false; 
    }
    
	// submit a Request 
	// Parameters: Request that has its amount requested, 
	// its purpose, and the Employee's email set 
    public boolean submitRequest(Request request)
    {
    	try(Connection c = ConnectionFactory.getInstance().getConnection();)
    	{
    		c.setAutoCommit(false);
    		
	    	String s = "INSERT INTO REQUEST	(AMOUNTREQUESTED, PURPOSE, REQUESTERID) "
	    			+ "VALUES (?, ?, ?)"; 
	    	PreparedStatement ps = c.prepareStatement(s); 
	    	
	    	ps.setDouble(1, request.getAmount());
	    	ps.setString(2, request.getPurpose());
	    	ps.setInt(3, request.getRequesterId());
	    	
	    	int rowCheck = ps.executeUpdate(); 
			if(rowCheck != 1)
			{
				System.out.println("Row Update Failure");
				return false; 
			}
			
	    	c.commit();
	    	ps.close();
	    	c.setAutoCommit(true);
	    	c.close();
	    	return true; 
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace(); 
    	}
    	return false; 
    }
}
