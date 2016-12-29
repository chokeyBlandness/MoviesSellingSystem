package lib;

import java.util.ArrayList;
import java.util.HashSet;

import login.Account;

public class SellingSystem {
	private ArrayList<Screening> screeningList; // 所有场次
	public HashSet<Film> allFilmSet;	//所有电影
	public HashSet<Studio> allStudioSet; //所有电影院
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
	 * 读取各种数据   （待完成）
	*/
	private void readData() {
		Studio s1 =new Studio("万达");
		Studio s2 =new Studio("金鹰");
		Film f1=new Film("你的名字","啦啦啦");
		Film f2=new Film("变态假面","呜呜呜");
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
	 * 根据电影 返回所有有这个电影的影城
	 * 参数 Film 
	 * 返回类型  ArrayList<Studio>
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
	 * 根据电影院 返回所有里面有的电影
	 * 参数 Studio
	 * 返回类型  ArrayList<Film>
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
	 * 根据电影院和电影  返回此电影的所有场次
	 * 返回类型  ArrayList<Screening>
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
	 * 返回所有的电影
	 * 返回类型  Film[]
	*/
	public Film[] getAllFilmSet(){
		Film[] film= allFilmSet.toArray(new Film[allFilmSet.size()]);
		return film;
	}
	/**
	 * 返回所有的电影院
	 * 返回类型  Studio[]
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
