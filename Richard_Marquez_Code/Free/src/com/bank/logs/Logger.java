package com.bank.logs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
	//private static String filename = "src/com/bank/logs/log.txt";
	private static String filename = "./log.txt";

	public static void log(String log) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			LocalDateTime now = LocalDateTime.now();
			bw.write(now.toString() + " : " + log + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
