import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.service.CustomerService;
import com.ex.service.cService;

public class Test 
{

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
//		Service service = new CustomerService(); 
//		System.out.println(service.findAll().get(0).getFirstName());
		
		ApplicationContext context = new ClassPathXmlApplicationContext("AppContext.xml"); 
		cService service = context.getBean("customerService", CustomerService.class); 
		System.out.println(service.findAll().get(0).getFirstName()); 
		service.timer(); 
	}
}
