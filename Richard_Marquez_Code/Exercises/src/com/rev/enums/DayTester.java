package com.rev.enums;

enum Day {
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY
}

public class DayTester {
	public static void main(String[] args) {
		Day day = Day.WEDNESDAY;
		
		System.out.println(day);
	}
}