package lib;

import java.io.Serializable;

import exception.SeatHaveBeenBookedException;
import exception.SetSeatSuccessException;

public class Screening implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String time;
	Studio studio;
	Film film;
	Seat[] seat;
	int seatAmount=100;
	public Screening(String time,Studio studio,Film film){
		seat = new Seat[seatAmount];
		this.time=time; this.studio=studio; this.film=film;
		
		for(int i = 0;i<seat.length;i++)
			seat[i]=Seat.EMPTY;
		
		seat[20]=Seat.BOOKED;
	}
	
	@Override
	public boolean equals(Object obj) {
		Screening screening =(Screening)obj;
		return this.film.equals(screening.film)&&this.studio.equals(screening.studio)
				&&this.time.equals(screening.time);
	}

	public Screening() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ȡ�õ�Ӱ
	 * �������� Film
	*/
	public Film getFilm(){
		return film;
	}
	/**
	 * ȡ�õ�ӰԺ
	 * �������� Studio
	*/
	public Studio getStudio(){
		return studio;
	}
	/**
	 * ȡ�õ�Ӱʱ��
	 * �������� String
	*/
	public String getTime(){
		return time;
	}
	/**
	 * ȡ�ó��ε���λ
	 * �������� Seat[]
	*/
	public Seat[] getSeat(){
		return seat.clone();
	}
	/**
	 * ��λ����Ϊ  ��(EMPTY)
	*/
	public void setEmpty(int index){
		seat[index]=Seat.EMPTY;
	}
	/**
	 * ��λ����Ϊ  ��Ԥ��(BOOKED)
	*/
	public void setBooked(int index){
		seat[index]=Seat.BOOKED;
	}
	/**
	 * ��λ����Ϊ  ��ѡ��(CHOSEN)
	*/
	public void setChosen(int index){
		seat[index]=Seat.CHOSEN;
	}

	public void setSeat(Seat[] seatOfClient) throws SeatHaveBeenBookedException, SetSeatSuccessException {
		synchronized (this) {
			for(Seat s:seatOfClient)
				if(s.isChosen())
					if(this.seat[s.ordinal()].isBooked())
						throw new SeatHaveBeenBookedException();
					else
						this.seat[s.ordinal()]=Seat.BOOKED;
			throw new SetSeatSuccessException();
		}
	}
}
