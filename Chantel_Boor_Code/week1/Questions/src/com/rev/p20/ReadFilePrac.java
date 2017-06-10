package com.rev.p20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadFilePrac 
{
	static String filename = "src/com/rev/p20/data.txt"; 
	
	public static void main(String[] args) 
	{
		ArrayList<MoviePerson> print = new ArrayList<MoviePerson>();
		ReadFilePrac f = new ReadFilePrac ();
		
		
		print = f.getAll();
		
		for(MoviePerson m: print)
			System.out.println(m);
	}
	
	
	public ArrayList<MoviePerson> getAll() {
		
		//array list used to store and return all students
		ArrayList<MoviePerson> people = new ArrayList<MoviePerson>();
		
		try{
			
			//set up reader and string that holds current line
			BufferedReader br = new BufferedReader (new FileReader(filename));
			String line = null;
			
			while((line = br.readLine()) != null)
			{
				
				//creates student object based on current line info
				String[] curr = line.split(":");
				MoviePerson temp = new MoviePerson ();
				
			
				temp.setName(curr[0] + " " + curr[1]);
				temp.setAge(Integer.parseInt(curr[2]));
				temp.setState(curr[3]);
				
				//adds the built object to the array
				people.add(temp);
				
				
			}
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		return people;
	}
	
}


