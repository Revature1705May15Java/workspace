package exercise1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DataFile {
	
	public static void main(String[] args) {
			ArrayList<String> input = new ArrayList<String>();
			ArrayList<String> output = new ArrayList<String>();
			input.add("Mickey:Mouse:35:Arizona");
			input.add("Hulk:Hogan:50:Virginia");
			input.add("Roger:Rabbit:22:California");
			input.add("Wonder:Woman:18:Montana");
			output = read(input);
			
		
	}
	public static ArrayList<String> read(ArrayList<String> s){
		ArrayList<String> result= new ArrayList<String>();
		try{
			PrintWriter file = new PrintWriter("src/exercise1/Data.txt", "UTF-8");
			for(int i =0; i < s.size(); i++){
				file.println(s.get(i));
			}
			file.close();
			
		}catch(IOException e){
			
		}
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("src/exercise1/Data.txt"));
			String line = null; //current line place holder
			 while((line = br.readLine()) != null){
				 String[] curr = line.split(":");
				 result.add("Name: " + curr[0] + " " + curr[1]);
				 result.add("Age: " + curr[2]);
				 result.add("State: "+ curr[3] + " State");
				 System.out.println("Name: " + curr[0] + " " + curr[1]); 
				 System.out.println("Age: " + curr[2]);
				 System.out.println("State: "+ curr[3] + " State");
			 }
			 br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
