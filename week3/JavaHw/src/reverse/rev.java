package reverse;

public class rev {
	
	public String StringRev(String s){
	
		String result="";
		
		for(int i=s.length();i!=0;i--){
			result = s.concat(s.substring(i-1, i));
			
		}

		return result;
		
	}

}
