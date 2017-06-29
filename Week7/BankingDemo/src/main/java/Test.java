import com.ex.dao.UserDaoImpl;
import com.ex.domain.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserDaoImpl dao = new UserDaoImpl();
		User u = new User();
		
		u.setPassword("test");
		u.setUsername("tester");
		
		dao.createUser(u);
		
	}

}
