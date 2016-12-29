package lib;

import java.io.Serializable;

/**
 * 一个座位状态的枚举  有空(EMPTY)，被预定(BOOKED)，被选中(CHOSEN)三种
*/
public enum Seat {
	EMPTY,BOOKED,CHOSEN;

	public boolean isEmpty() {
		return this==EMPTY;
	}
	
	public boolean isBooked() {
		return this==BOOKED;
	}
	
	public boolean isChosen() {
		return this==CHOSEN;
	}
	
//	public static String[] seatArryaToString(Seat[] a){
//		return "";
//	}
	

}
