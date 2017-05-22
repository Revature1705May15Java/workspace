
package com.rev.singleton;
import java.util.*;

public class Show {
	private static final Show Instance = new Show();
	private Set <String> availableSeats;
	
	//private static final bingo Instance1 = new bingo(); 
	private Set <String> reamining;

	
	public static Show getInstance(){
		
		return Instance;
		
	}
	
	private Show(){
		availableSeats = new HashSet<String>();
		availableSeats.add("1A");
		availableSeats.add("1B");
	}
	
	
	public boolean bookSeat(String seat){
		return availableSeats.remove(seat);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ticketAgentBooks("1A");
		ticketAgentBooks("1A");
		
	}
	
	public static void ticketAgentBooks(String seat){
		Show show = Show.getInstance();
		System.out.println(show.bookSeat(seat));
	}

}
