package com.revature.services;

        import com.revature.dao.Dao;
        import com.revature.dao.DaoImpl;
        import com.revature.model.Employee;
        import com.revature.model.ReimbursementRequest;

public class RequestService {
    private static RequestService INSTANCE = new RequestService();
    Dao dao = DaoImpl.getInstance();

    private RequestService() {
    }

    public static RequestService getInstance() {
        return INSTANCE;
    }


    public boolean addRequest(double amount, int requesterId, String purpose) {
        ReimbursementRequest r = new ReimbursementRequest();
        r.setAmount(amount);
//        r.setHandlerId(handlerId);
        r.setRequesterId(requesterId);
        r.setPurpose(purpose);
        r.setStatus("pending");

        return dao.addRequest(r);
    }

    public Employee getEmployeeById(int id) {
        return dao.getEmployeeById(id);
    }

    public Employee getEmployeeByEmail(String email) {
        return dao.getEmployeeByEmail(email);
    }

    public Employee login(String email, String password) {
        Employee e = dao.getEmployeeByEmail(email);
        if (e.getPassword().equals(password)) {
            return e;
        } else {
            return null;
        }

    }

}
