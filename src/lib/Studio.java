package lib;

import java.io.Serializable;

public class Studio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	Studio(String name){
		this.name=name;
	}
	
	/**
	 * ȡ�õ�ӰԺ����
	 * �������� String
	*/
	public String getName(){
		return name;
	}
	@Override
	public boolean equals(Object arg0) {
		Studio sudio=(Studio) arg0;
		return this.name.equals(sudio.name);
	}
}
