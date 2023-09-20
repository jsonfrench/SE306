package edu.monmouth.FiniteStateMachine;

import java.util.*;

public class FiniteStateMachine {
	State state; 
	Input input; 
		
	FiniteStateMachine() {
		state = State.STATE_0;
	}
	
	FiniteStateMachine(State state) {
		this.state = state;
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in); 
		int number; 
		
		while (state != State.MAX_STATE) {
			if (state != State.STATE_4) {
				//get input from keyboard  
				while(true) {
					System.out.printf("The system is in the state of %s%n", state);
					System.out.printf("Please enter a number from 0-9%n");
					
					number = scanner.nextInt(); 
										
					if (number>=0 && number < 10) {
						break; 
					}
					else {
						System.out.printf("Wrong input. Enter again.%n"); 
					}
					input = Input.fromInteger(number); 				
				}
			}

				
			//state transition 
			switch(state) {
			case STATE_0: 
				if(input == Input.INPUT_2) {
					state = State.STATE_1; 
					System.out.printf("State: %s%n", state);
				}
				else {
					state = State.STATE_0; 
					System.out.printf("State: %s%n", state);						
				}
			case STATE_1: 
				if(input == Input.INPUT_0) {
					state = State.STATE_2; 
					System.out.printf("State: %s%n", state);
				}
				else {
					state = State.STATE_0; 
					System.out.printf("State: %s%n", state);						
				}
			case STATE_2: 
				if(input == Input.INPUT_1) {
					state = State.STATE_3; 
					System.out.printf("State: %s%n", state);
				}
				else {
					state = State.STATE_0; 
					System.out.printf("State: %s%n", state);						
				}
			case STATE_3: 
				if(input == Input.INPUT_7) {
					state = State.STATE_4; 
					System.out.printf("State: %s%n", state);
				}
				else {
					state = State.STATE_0; 
					System.out.printf("State: %s%n", state);						
				}
			case STATE_4: 
				state = State.MAX_STATE;
				System.out.printf("The safe is open!%n");
				
				break; 
			default: 
				System.out.printf("you shouldn't have done that.%n"); 
			} //switch
		} //while
	}		
}
