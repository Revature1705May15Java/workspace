package com.p7;

import java.util.Comparator;

public class CompareAge implements Comparator
{
	public int compare(Object o1,Object o2)
	{  
		Employee e1=(Employee)o1;  
		Employee e2=(Employee)o2;  
		  
		if(e1.getAge()==e2.getAge())  
		return 0;  
		else if(e1.getAge()>e2.getAge())  
		return 1;  
		else  
		return -1;  
	}  

}
