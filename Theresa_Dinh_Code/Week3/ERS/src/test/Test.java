package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import pojos.Employee;
import pojos.Request;
import service.ErsService;

public class Test {

	public static void main(String[] args) throws IOException
	{
		ErsService service = new ErsService(); 
		
//		Employee e = new Employee();
//		e.setEmail("ms@email.com");
//		e.setFirstName("Mary");
//		e.setLastName("Sue");
//		e.setPassword("test");
//		
//		service.registerEmployee("ms@email.com", "test", "Mary", "Sue");
//		service.setManager("ms@email.com", true);
//		System.out.println(service.getEmployee(e));
//		service.submitRequest(6.66, "", "ms@email.com");
//		System.out.println(service.getRequests("ms@email.com"));
//		System.out.println(service.getPendingRequests());
//		service.approveRequest(21, e);
//		service.denyRequest(21, e);
		
//		Employee e = new Employee();
//		e.setEmail("gs@email.com");
//		e.setFirstName("Gary");
//		e.setLastName("Stu");
//		e.setPassword("test");
		
//		service.registerEmployee("gs@email.com", "test", "Gary", "Stu");
//		service.setManager("gs@email.com", true);
//		System.out.println(service.getEmployee(e));
//		service.submitRequest(777, "", "gs@email.com");
//		System.out.println(service.getRequests("gs@email.com"));
//		System.out.println(service.getPendingRequests());
//		service.approveRequest(41, e);
//		service.denyRequest(21, e);
		
		BufferedWriter writer; 
		writer =  new BufferedWriter(new FileWriter("src/data/pendingRequests.txt", false));
		// { "data": [
		writer.write("{\"data\":[");
		ArrayList<Request> list = service.getPendingRequests(); 
//		for(Request r : service.getPendingRequests())
		for(int i = 0; i < list.size(); i++)
		{
			Request r = list.get(i); 
			Employee e = service.getEmployee(r.getRequesterId()); 
			// [ "firstName", "lastName", "email", "amount", "date submit", "approve/deny"],
			writer.write("[\"" + e.getFirstName() + "\",\"" + e.getLastName() + 
					"\",\"" + e.getEmail() + "\",\"" + r.getAmount() + "\",\"" +
					r.getRequestDate() + "\",\"" + "\"]");	// what do for approve button 
			if(i == list.size()-1)
				continue;
			writer.write(",");
		}
		// ]}
		writer.write("]}");
		writer.close();
	}

}