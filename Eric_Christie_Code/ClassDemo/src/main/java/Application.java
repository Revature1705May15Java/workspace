import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.model.Customer;
import com.ex.service.CustomerService;

public class Application {
  
  public static void main(String[] args) {
//    CustomerService service = new MyCustomerService();
    @SuppressWarnings("resource")
    ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    CustomerService service = appContext.getBean("customerService", CustomerService.class);
    for (Customer c: service.findAll()) {
      System.out.println(c.getFirstname() + " " + c.getLastname());
    }
    
  }
}