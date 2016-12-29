package lib;

import java.io.Serializable;

public class Film implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String brief;
	
	Film(String name,String brief){
		this.name=name;
		this.brief=brief;
	}
	@Override
	public boolean equals(Object arg0) {
		Film film=(Film)arg0;
		return this.name.equals(film.name);
	}
	/**
	 * ȡ�õ�Ӱ����
	 * �������� String
	*/
	public String getName(){
		return name;
	}
	/**
	 * ȡ�õ�Ӱ���
	 * �������� String
	*/
	public String getBrief(){
		return brief;
	}
	
}
