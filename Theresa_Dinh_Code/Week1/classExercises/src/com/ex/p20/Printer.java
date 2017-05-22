package com.ex.p20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Printer 
{
	public static void main(String[] args)
	{
		try(BufferedReader br = new BufferedReader(new FileReader("src/com/ex/p20/Data.txt")))
		{
			String line = null; 
			
			while((line = br.readLine()) != null)
			{
				String[] userInfo = line.split(":"); 
				System.out.println("Name: " + userInfo[0] + " " + userInfo[1] + "\n" + 
						"Age: " + userInfo[2] + " years \n" +
						"State: " + userInfo[3] + " state \n");
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
