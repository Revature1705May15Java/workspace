package dao;

import model.Employee;
import model.Request;

public interface Dao {

	Employee createEmployee(Employee employee);

	Request submitRequest(Request request);

}