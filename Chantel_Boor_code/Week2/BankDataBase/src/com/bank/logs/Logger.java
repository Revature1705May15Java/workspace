package com.bank.logs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Logger 
{
	static String filename = "src/com/bank/logs/log.txt";
	static DateTimeFormatter form = DateTimeFormatter.ofPattern("MM/DD/YY HH:mm:ss");
	static LocalDateTime now;
	
	public void log (String logs)
	{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter (filename,true)))
		{
			now = LocalDateTime.now();
			bw.write(now + " "+logs+"\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
