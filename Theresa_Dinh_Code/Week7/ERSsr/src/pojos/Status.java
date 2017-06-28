package pojos;

public class Status 
{
	int statusId; 
	String statusName;
	
	public Status() 
	{
		super();
		statusId = 0; 
		statusName = "pending"; 
	}
	
	public Status(int statusId)
	{
		super(); 
		this.statusId = statusId; 
		
		switch(statusId)
		{
			case 0:
				statusName = "pending"; 
				break;
			case 1: 
				statusName = "approved"; 
				break;
			case 2:
				statusName = "denied"; 
				break; 
		}
	}
	
	
	public int getStatusId() {
		return statusId;
	}
	
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	public String getStatusName() {
		return statusName;
	} 
}
