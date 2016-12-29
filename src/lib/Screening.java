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
	 * 取得电影
	 * 返回类型 Film
	*/
	public Film getFilm(){
		return film;
	}
	/**
	 * 取得电影院
	 * 返回类型 Studio
	*/
	public Studio getStudio(){
		return studio;
	}
	/**
	 * 取得电影时间
	 * 返回类型 String
	*/
	public String getTime(){
		return time;
	}
	/**
	 * 取得场次的座位
	 * 返回类型 Seat[]
	*/
	public Seat[] getSeat(){
		return seat.clone();
	}
	/**
	 * 座位设置为  空(EMPTY)
	*/
	public void setEmpty(int index){
		seat[index]=Seat.EMPTY;
	}
	/**
	 * 座位设置为  被预定(BOOKED)
	*/
	public void setBooked(int index){
		seat[index]=Seat.BOOKED;
	}
	/**
	 * 座位设置为  被选中(CHOSEN)
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
