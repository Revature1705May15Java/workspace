package com.revature.dao;

import com.revature.model.Employee;
import com.revature.model.ReimbursementRequest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface Dao {

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    boolean addEmployee(Employee e);

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    boolean addRequest(ReimbursementRequest r);

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    Employee getEmployeeById(int id);

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    Employee getEmployeeByEmail(String email);
}
