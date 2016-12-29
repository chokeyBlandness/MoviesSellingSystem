package login;

import java.util.ArrayList;

public class LoginSystem {
	public ArrayList<Account> account;
	
	LoginSystem(){
		account=new ArrayList<Account>();
		
		account.add(new Account("111","111","vip"));
		account.add(new Account("222","222","normal"));
		account.add(new Account("333","333","vip"));
	}
}
