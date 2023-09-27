package edu.monmouth.assignment2;

public enum Input {
	KEY, 
	SEAT, 
	UNSEAT, 
	BELT, 
	UNBELT, 
	TIMER_EXPIRES, 
	TERMINATE; 

	public static Input fromInteger(int num) {
		switch (num) {
		case 0:
			return TERMINATE;
		case 1: 
			return KEY; 
		case 2: 
			return SEAT; 
		case 3: 
			return UNSEAT; 
		case 4: 
			return BELT; 
		case 5: 
			return UNBELT; 
		case 6: 
			return TIMER_EXPIRES; 
		default:
			return TERMINATE; 
		}
	}
}