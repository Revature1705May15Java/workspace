package com.bank.test;
import com.bank.pojos.User;
import com.bank.service.Service;
public class Test {

	public static void main(String[] args) {
		Service s = new Service();
        
        User u = s.getUser("test4");
        //s.addUser("test", "test", "12423545", "12412");
        
        System.out.println(u);
	}
}
