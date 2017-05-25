package com.rev.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
	private static final String filename = "src/com/rev/logs/log.txt";
	private DateTimeFormatter form = DateTimeFormatter.ofPattern("mm/dd/yyyy hh:mm:ss");
	private static LocalDateTime now;
	
	public void log(String log) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			now = LocalDateTime.now();
			
			bw.write(now.toString() + ": " + log + "\n");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
