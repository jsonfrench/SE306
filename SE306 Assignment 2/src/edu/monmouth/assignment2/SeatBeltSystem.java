package edu.monmouth.assignment2;

import java.util.*;

public class SeatBeltSystem {
	State state; 
	Input input; 
	
	SeatBeltSystem() {
		state = State.OFF;
	}
	
	SeatBeltSystem(State state) {
		this.state = state;
	}
	
	public void run() {
		
		int number; 
		String output;	
		boolean terminated = false;
		Scanner scanner = new Scanner(System.in); 
		System.out.printf("Please enter a number from 0-6%n");
		
		while (!terminated) {
			while (true) {
				number = scanner.nextInt(); 
				if (number>=0 && number <= 6) {
					if (Input.fromInteger(number) == Input.TERMINATE) {
						terminated = true;
					}
					break; 
				}
				else {
					System.out.printf("Wrong input. Enter again.%n"); 
				}
			}// input handling
			
			input = Input.fromInteger(number);
			System.out.printf("%s --> ", state);
			output = "";

			//state transition
			switch (state) {
			case OFF:
				if (input == Input.SEAT) {
					state = State.SEATED;
				}
				break; 
			case SEATED:
				if (input == Input.BELT) {
					state = State.READY;
				}
				else if (input == Input.UNSEAT) {
					state = State.OFF;
				}
				else if (input == Input.KEY) {
					state = State.TIMING;
					output = "timer_on";
				}
				break; 
			case READY:
				if (input == Input.UNBELT) {
					state = State.SEATED;
				}
				else if (input == Input.KEY) {
					state = State.BELTED;
				}
				break;
			case BELTED: 
				if (input == Input.KEY) {
					state = State.READY;
				}
				else if (input == Input.UNBELT) {
					state = State.TIMING;
					output = "timer_on";
				}
				break;
			case TIMING: 
				if (input == Input.BELT) {
					state = State.BELTED;
					output = "timer_off";
				}
				else if (input == Input.KEY) {
					state = State.SEATED;
					output = "timer_off";	
				}
				else if (input == Input.TIMER_EXPIRES) {
					state = State.BUZZER;
					output = "buzzer_on";	
				}
				break;
			case BUZZER: 
				if (input == Input.KEY) {
					state = State.READY;
					output = "buzzer_off";	
				}
				else if(input == Input.BELT) {
					state = State.BELTED;
					output = "buzzer_off";					
				}
				break;
			default: 
				System.out.printf("SWITCH STATE ERROR%n");
				break;				
			}//switch
			
			System.out.printf("%s%n", state);
			System.out.printf("%s%n", output);
			
		}//while
		System.out.printf("program terminated%n");
	}
}
