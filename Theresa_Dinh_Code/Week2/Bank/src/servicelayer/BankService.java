package servicelayer;

import dao.BankDao;
import dao.Dao;
import pojos.User;

public class BankService 
{
	Dao dao = new BankDao(); 
	
	public User addUser(String fn, String ln, Sring pw, String email)
	{
		User temp = new User(); 
		temp = dao.getUser(email); 
		if(temp != null)
			//username exists prompt to try another username 
		else
			dao.addUser(fn, ln, pw, email); 
		return dao.getUser(email); 
	}
}