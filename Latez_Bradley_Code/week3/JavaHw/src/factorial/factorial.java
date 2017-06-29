package factorial;

public class factorial {
	public int facto(int num){
		for(int i = num-1;i!=0;i--){
			num*=i;
		}
		return num;
		
	}

}
