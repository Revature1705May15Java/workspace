package rev1;

public class UseCustomers {
	public static void main(String[] args) {
		Customer obj=new Customer();
		int idcheck =obj.getID(2);
		System.out.println("Customer ID is : "+idcheck);
		Customer obj2=new Customer();
		idcheck=obj2.getID();
		System.out.println("Customer 2 ID is : "+idcheck);
	}
}
