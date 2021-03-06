import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ex.repository.CustomerRepository;
import com.ex.repository.CustomerRepositoryImpl;
import com.ex.service.CustomerService;
import com.ex.service.CustomerServiceImpl;
/*
 * To replace our XML config files, wer're
 * going to use a Java file with the @Configuration
 * annotation. The Java files with these
 * replace any XML context that we've previously used. 
 * Configuration is done at class level with these
 * annotations 
 * Summary:
 * applicationContext is replaced by @Configuration
 * @Configuration is done at class level 
 * Spring Beans are defined by @Bean
 * @Bean at method level (method returns an instance of a bean)
 * 
 */
@Configuration // tells spring to look for any config info from this file 
public class AppConfig {
	// even though we keep the @Bean naming
	//convention, the method can be named whatever 
	@Bean(name = "customerService")
	public CustomerService getCustomerService(){
		//return new CustomerServiceImpl();
		// we replace this when doing injection 
		CustomerServiceImpl service = new CustomerServiceImpl();
		service.setCustomerRepository(getCustomerRepository());
		return service;
	}
	
	/*
	 * going to implement setter injection
	 * by default we deal with singleton beans
	 * meaning that we only implement the setter method once
	 * then every time we need a bean we return a cached instance of it 
	 * 
	 */
	@Bean(name="customerRepository")
	public CustomerRepository getCustomerRepository(){
		return new CustomerRepositoryImpl();
	}
}
