package dao;

import org.hibernate.SessionFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Employee;
import model.Request;

@Transactional
public class EmployeeDao implements Dao 
{
	private static AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml"); 
	private SessionFactory sessionFactory;
	
	public EmployeeDao()
	{
	}
	
	// constructor injection 
	public EmployeeDao(SessionFactory sf)
	{
		sessionFactory = sf; 
	}
	
	public static Dao getInstance()
	{
		return appContext.getBean("dao", Dao.Class); 
	}
	
	// setter injection 
	public void setSessionFactory(SessionFactory sf)
	{
		sessionFactory = sf; 
	}
	
	public Employee createEmployee(Employee employee)
	{
		return null; 
	}
	
	public Request submitRequest(Request request)
	{
		return null; 
	}
}
