import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Q14. Write a program that demonstrates the switch case. 
 *      Implement the following functionalities in the cases:
 *      Case 1: Find the square root of a number using the Math class method. 
		Case 2: Display today’s date.
		Case 3: Split the following string and store it in a sting array. 
				“I am learning Core Java”

 */
public class Switch {
	public static void main(String[] args) {
		int selector = 3;
		int num = 144;
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date dateToday = new Date();
		
		String splitMe = "I am learning Core Java";
		
		switch(selector){
			case 1:
				Math.sqrt(num);
				break;
			case 2:
				System.out.println(dateFormat.format(dateToday));
				break;
			case 3:
				String[] splitter = splitMe.split(" ");
				for(int i = 0; i < splitter.length; i++){
					System.out.print(splitter[i] + " ");
				}
		}
	}

}
