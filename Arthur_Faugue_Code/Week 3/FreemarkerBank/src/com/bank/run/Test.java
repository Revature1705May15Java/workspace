package com.bank.run;


import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojo.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO dao = new DaoImpl();
		Account a = new Account();
		User u = new User();
		
		u = dao.getUser("test", "test");
		System.out.println(u.toString());
//		a = dao.getAccount(10007);
//		System.out.println(a.toString());
//		dao.updateBalance(a, 5.00);
//		System.out.println(a.toString());
//		dao.updateBalance(a, -10);
//		System.out.println(a.toString());
	}

}
