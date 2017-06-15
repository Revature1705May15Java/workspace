/*
 * Q13. Display the triangle on the console as follows using any type of loop.
 *      Do NOT use a simple group of print statements to accomplish this.
 */
public class TrianglePrint {
	public static void main(String[] args) {
		int num = 0, length = 4, line = 1;
		do{
			for(int i = 1; i <= line; i++){
				System.out.print(num + " ");
				if(num == 0) num = 1;
				else num = 0;
			}
			System.out.println();
			if(length == line) break;
			line++;
		}while(true);
	}
}