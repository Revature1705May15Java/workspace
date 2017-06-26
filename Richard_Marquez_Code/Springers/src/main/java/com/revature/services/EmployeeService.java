package com.revature.services;

import com.revature.dao.Dao;
import com.revature.dao.DaoImpl;
import com.revature.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
//    private static EmployeeService INSTANCE = new EmployeeService();
//    Dao dao = DaoImpl.getInstance();
//
//    private EmployeeService() {
//    }
//
//    public static EmployeeService getInstance() {
//        return INSTANCE;
//    }

    @Autowired
    Dao dao;


    public boolean addEmployee(String email, String password, String firstName, String lastName, int isManager) {
        Employee e = new Employee();
        e.setEmail(email);
        e.setFirstname(firstName);
        e.setLastname(lastName);
        e.setPassword(password);
        e.setIsManager(isManager);

        return dao.addEmployee(e);
    }

    public Employee getEmployeeById(int id) {
        return dao.getEmployeeById(id);
    }

    public Employee getEmployeeByEmail(String email) {
        return dao.getEmployeeByEmail(email);
    }

    public Employee login(String email, String password) {
        Employee e = dao.getEmployeeByEmail(email);
        if (e != null && e.getPassword().equals(password)) {
            return e;
        } else {
            return null;
        }

    }

}
