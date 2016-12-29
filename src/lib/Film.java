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
	 * 取得电影名字
	 * 返回类型 String
	*/
	public String getName(){
		return name;
	}
	/**
	 * 取得电影简介
	 * 返回类型 String
	*/
	public String getBrief(){
		return brief;
	}
	
}
