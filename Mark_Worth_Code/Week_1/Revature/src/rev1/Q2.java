package rev1;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		
		Scanner nums=new Scanner(System.in);
		System.out.println("Enter three numbers:");
		int[] numvars=new int[3];
		for(int i=0;i<3;i++){
			numvars[i]=nums.nextInt();
		}
		if(numvars[0]>=numvars[1] && numvars[0]>=numvars[2]){
			System.out.println("Maximum number is :"+ numvars[0]);
		}
		else if(numvars[1]>=numvars[2]){
			System.out.println("Maximum number is : "+ numvars[1]);
		}else{
			System.out.println("Maximum number is : "+ numvars[2]);
		}
	}
}
