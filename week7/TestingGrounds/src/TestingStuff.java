import com.ex.testpojo.User;
import com.ex.testpojo.UserStatus;

public class TestingStuff {
	public static void main(String[] args) {
		User u = new User();
		UserStatus us = new UserStatus(0, "normal");
		
		u.setFirstName("Dave");
		u.setLastName("Terry");
		u.setPassword("password");
		u.setEmail("Happy@this.works");
		
		//if(u.getStatus() == null) u.setStatus(us);
        if(u.isIntBaby() == 0) {
        	System.out.println("here");
        	u.setBaby(true);
        }
		
        
        System.out.println("done");
        System.out.println(u.toString());
		
		
		
	}
}
