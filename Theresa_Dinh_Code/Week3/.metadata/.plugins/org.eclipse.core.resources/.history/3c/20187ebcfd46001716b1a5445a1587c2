package pojos;

public class AccountType 
{
	// 1 for CHECKING
	// 2 for SAVING
	// 3 for CREDIT
	int id; 
	String name;
	
	public AccountType() {
		super();
	}
	
	public AccountType(int id)
	{
		super(); 
		this.id = id; 
		
		switch(id)
		{
			case 1: 
				name = "Checking";
				break;
			case 2: 
				name = "Saving"; 
				break;
			case 3: 
				name = "Credit"; 
				break;
		}
	}
	
	public AccountType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AccountType [id=" + id + ", name=" + name + "]";
	} 
	
}
