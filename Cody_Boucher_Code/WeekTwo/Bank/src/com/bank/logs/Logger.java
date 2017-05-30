package com.bank.logs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
	static String filename = "src/com/Bank/logs/log.txt";
	static DateTimeFormatter formater = DateTimeFormatter.ofPattern("MM/DD/YYYY HH:MM:SS");
	static LocalDateTime now;
	
	public static void log(String log) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			now = LocalDateTime.now();
			bw.write(now + " " + log + "\n");
			
		} catch (IOException e) {
		  e.printStackTrace();
		}
	}
}
