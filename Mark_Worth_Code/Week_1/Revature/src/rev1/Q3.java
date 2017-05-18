package rev1;
public class Q3 {
	public static void main(String[] args){
	boolean a=true;
	boolean b=false;
	boolean check1=!a;
	boolean check2=(a|b);
	boolean check3=((!a&b)|(a&!b));
	System.out.println(""+check1+check2+check3);
	}
}
