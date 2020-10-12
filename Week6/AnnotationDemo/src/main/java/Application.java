

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.service.CustomerService;
import com.ex.service.CustomerServiceImpl;

public class Application {

	public static void main(String[] args) {
		//CustomerService service = new CustomerServiceImpl();
		// new instance of app context, using context sensitive help
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CustomerService service = appContext.getBean("customerService", CustomerService.class);
		//using interface instead of concrete class
		System.out.println(service.findAll().get(0).getFirstname());
	}

}