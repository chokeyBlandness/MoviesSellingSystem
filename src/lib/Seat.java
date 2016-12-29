package lib;

import java.io.Serializable;

/**
 * һ����λ״̬��ö��  �п�(EMPTY)����Ԥ��(BOOKED)����ѡ��(CHOSEN)����
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
