package com.ex.test;

import com.rev.dao.DAO;
import com.rev.dao.DaoImpl;
import com.rev.pojo.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO dao = new DaoImpl();
		User u = new User();
		
		u = dao.userLogin("test", "test");
		System.out.println(u.toString());
		dao.getUserRequestsByStateId(u, 3);
//		dao.makeRequest(u, 50, note);
	}

}
