package rev1;

public class Q5 {
	
		public static double AddSubMultDiv(double num1,double num2,String op){
			double numout=0;
			if(op=="add"||op=="Add"){
				numout=num1+num2;
			}
			if(op=="subtract"||op=="Subtract"){
				numout=num1-num2;
			}
			if(op=="multiply"||op=="Multiply"){
				numout=num1*num2;
			}
			if(op=="divide"||op=="Divide"){
				numout=num1/num2;
			}
			
			return numout;	
		}
		public static void main(String[] args) {
			double added=AddSubMultDiv(3,2,"add");
			System.out.println(added);
			double subtracted=AddSubMultDiv(3,2,"subtract");
			System.out.println(subtracted);
			double multiplied=AddSubMultDiv(3,2,"multiply");
			System.out.println(multiplied);
			double divided=AddSubMultDiv(3,2,"divide");
			System.out.println(divided);
		}
		
		
		
}
