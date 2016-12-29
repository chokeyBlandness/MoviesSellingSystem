package login;

public class Account {
	public String accountNumber;
	String password;
	public String level;
	
	public Account() {
		
	}
	
	Account(String accountNumber, String password, String level) {
		this.accountNumber = accountNumber;
		this.password = password;
		this.level = level;
	}

	public Account(String accountNumber) {
		this.accountNumber=accountNumber;
	}
}
