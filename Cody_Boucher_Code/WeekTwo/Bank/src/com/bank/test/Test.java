package com.bank.test;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class Test {
	public static void main(String[] args) {
		DAO dao = new DaoImpl();
	//	dao.addUser("B", "B", "B", "B");
		User temp = dao.getUser("B");
	//	System.out.println(temp.toString());
//		User temp = dao.getUserById(121);
//		System.out.println(temp.toString());
	//	Account tempAccount = dao.getAccount(21);
	//	System.out.println(temp.toString());
	//	System.out.println(tempAccount.toString());
	//	dao.addAcount(temp, 1);
	//	dao.getAllAccounts(temp);
	//	dao.getAccountType();
//		dao.upDateAccount(temp);
	//	dao.addAccountUser(u, tempAccount);
		dao.transfer(21, 22, 250);
	}
}
