package com.bank.logs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
	String filename = "src/com/bank/logs/log.txt";
	static DateTimeFormatter form = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
	static LocalDateTime now;
	
	public void log(String log){
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){
			now = LocalDateTime.now();
			bw.write(now + " " + log + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
