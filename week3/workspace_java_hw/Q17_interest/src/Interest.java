import java.util.Scanner;

/*
 * Q17. Write a program that calculates the simple interest on the principal,
 *      rate of interest and number of years provided by the user. Enter principal,
 *      rate and time through the console using the Scanner class.
				
				Interest = Principal* Rate* Time
 */
public class Interest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double interest, principal, rate, time;
		
		do{
			try {
				System.out.print("What is the principal amount? ");
				principal = Double.parseDouble(input.nextLine().trim());
				System.out.print("\nWhat is the interest rate? ");
				rate = Double.parseDouble(input.nextLine().trim());
				System.out.print("\nHow many years? ");
				time = Double.parseDouble(input.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry, please try again.\n\n");
				continue;
			}
			break;
		}while(true);
		
		interest = principal*rate*time;
		System.out.println("Interest = " + interest);
	}
}
