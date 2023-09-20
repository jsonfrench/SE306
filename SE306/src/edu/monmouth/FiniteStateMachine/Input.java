package edu.monmouth.FiniteStateMachine;

public enum Input {
	INPUT_0, 
	INPUT_1, 
	INPUT_2, 
	INPUT_3, 
	INPUT_4, 
	INPUT_5, 
	INPUT_6, 
	INPUT_7, 
	INPUT_8, 
	INPUT_9, 
	MAX_INPUT; 
	
	public static Input fromInteger(int num) {
		switch (num) {
		case 0: 
			return INPUT_0;
		case 1: 
			return INPUT_1;
		case 2: 
			return INPUT_2;
		case 3: 
			return INPUT_3;
		case 4: 
			return INPUT_4;
		case 5: 
			return INPUT_5;
		case 6: 
			return INPUT_6;
		case 7: 
			return INPUT_7;
		case 8: 
			return INPUT_8;
		case 9: 
			return INPUT_9; 
		default: 
			return MAX_INPUT;
		
		}
	}
}
