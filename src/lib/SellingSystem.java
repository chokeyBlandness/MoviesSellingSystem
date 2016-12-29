package lib;

import java.util.ArrayList;
import java.util.HashSet;

import login.Account;

public class SellingSystem {
	private ArrayList<Screening> screeningList; // ���г���
	public HashSet<Film> allFilmSet;	//���е�Ӱ
	public HashSet<Studio> allStudioSet; //���е�ӰԺ
	Screening searchScreening;
	public Account account;
	public SellingSystem(){
		searchScreening =new Screening();
		screeningList = new ArrayList<Screening>();
		allFilmSet =new HashSet<Film>();
		allStudioSet =new HashSet<Studio>();
		account=new Account();
		readData();
	}
	
	/**
	 * ��ȡ��������   ������ɣ�
	*/
	private void readData() {
		Studio s1 =new Studio("���");
		Studio s2 =new Studio("��ӥ");
		Film f1=new Film("�������","������");
		Film f2=new Film("��̬����","������");
		allStudioSet.add(s1);
		allStudioSet.add(s2);
		allFilmSet.add(f1);
		allFilmSet.add(f2);
		screeningList.add(new Screening("13:00",s1,f1));
		screeningList.add(new Screening("15:00",s1,f1));
		screeningList.add(new Screening("13:00",s1,f2));
		screeningList.add(new Screening("15:00",s1,f2));
		screeningList.add(new Screening("13:00",s2,f1));
		screeningList.add(new Screening("15:00",s2,f1));
		screeningList.add(new Screening("13:00",s2,f2));
		screeningList.add(new Screening("15:00",s2,f2));
	}
	
	/**
	 * ���ݵ�Ӱ ���������������Ӱ��Ӱ��
	 * ���� Film 
	 * ��������  ArrayList<Studio>
	*/
	public Studio[] showStudioByFilm(){
		Film film =searchScreening.getFilm();
		HashSet<Studio> studioSet =new HashSet<Studio>();
		for(Screening present:screeningList){
			if(present.film.equals(film))
				studioSet.add(present.studio);
		}
		return studioSet.toArray(new Studio[allStudioSet.size()]);
	}	
	
	/**
	 * ���ݵ�ӰԺ �������������еĵ�Ӱ
	 * ���� Studio
	 * ��������  ArrayList<Film>
	*/
	public Film[] showFilmByStudio(){
		Studio studio =searchScreening.getStudio();
		HashSet<Film> filmSet =new HashSet<Film>();
		for(Screening present:screeningList){
			if(present.studio.equals(studio))
				filmSet.add(present.film);
			}
		return filmSet.toArray(new Film[allFilmSet.size()]);
	}
	
	/**
	 * ���ݵ�ӰԺ�͵�Ӱ  ���ش˵�Ӱ�����г���
	 * ��������  ArrayList<Screening>
	*/
	public ArrayList<Screening> showScreening(){
		Film film=searchScreening.getFilm();
		Studio studio=searchScreening.getStudio();
		ArrayList<Screening> screenings =new ArrayList<Screening>();
		for(Screening present:screeningList){
			if(present.film.equals(film)&&present.studio.equals(studio))
				screenings.add(present);
		}
		return screenings;
	}
	/**
	 * �������еĵ�Ӱ
	 * ��������  Film[]
	*/
	public Film[] getAllFilmSet(){
		Film[] film= allFilmSet.toArray(new Film[allFilmSet.size()]);
		return film;
	}
	/**
	 * �������еĵ�ӰԺ
	 * ��������  Studio[]
	*/
	public Studio[] getAllStudioSet(){
		Studio[] studio=(Studio[]) allStudioSet.toArray();
		return studio;
	}

	public void setSerachFilm(Film film) {
		searchScreening.film=film;
	}

	public void setSerachStudio(Studio studio) {
		searchScreening.studio=studio;
		
	}

	public boolean isSelectFinish() {
		return (searchScreening.film!=null)&&(searchScreening.studio!=null);
	}

	public void resetStudio() {
		searchScreening.studio=null;
	}

	public void resetFilm() {
		searchScreening.film=null;
	}

	public Screening searchScreening(Screening screening) {
		for(Screening present:screeningList){
			if(present.equals(screening))
				return present;
		}
		return null;
	}

	public void setAccount(String account) {
		this.account.accountNumber=account;
		
	}

}
