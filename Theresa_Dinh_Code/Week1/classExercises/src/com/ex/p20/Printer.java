package com.ex.p20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Printer 
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("src/Data.txt"));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
